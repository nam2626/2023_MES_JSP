package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dto.BoardDTO;
import dto.FileDTO;
import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 업로드할 경로, DiskFileFactory 셋팅
		 * 2. 사용자가 보낸 내용을 받아서, BoardDTO와 FileDTO 셋팅
		 * 3. 파일 쓰기 먼저 수행
		 * 4. DB로 게시글, 파일목록을 테이블에 등록
		*/
		//업로드할 기본 폴더 설정
		File userRoot = new File("c:\\fileupload\\");
		//업로드할 기본 폴더가 없으면 경로까지의 폴더를 생성
		if(!userRoot.exists())
			userRoot.mkdirs();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userRoot);//업로드 될 폴더
		factory.setSizeThreshold(1024*1024);//버퍼 메모리
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		int bno = 0;
		
		try {
			//폼에서 보낸 모든 내용을 받음
			List<FileItem> list = upload.parseRequest(request);
			//DB에 저장할 게시글 정보를 담을 객체
			BoardDTO board = new BoardDTO();
			//DB에 저장할 파일 목록
			ArrayList<FileDTO> fList = new ArrayList<FileDTO>();
			//파일 번호
			int fno = 0;
			//작성자 저장
			board.setWriter(((MemberDTO)request.getSession().getAttribute("user")).getId());
			
			for(FileItem item : list) {
				System.out.println(item.toString());
				//아이템이 폼, 파일인지 구분
				//사용자가 입력한 내용인지 확인
				if(item.isFormField()) {
					//게시글 내용
					switch(item.getFieldName()) {
					case "title":
						board.setTitle(item.getString("utf-8"));
						break;
					case "content":
						board.setContent(item.getString("utf-8"));
					}
				}else {
					//파일 업로드 처리
					//전송된 파일이 없으면 건너뜀
					if(item.getSize() == 0) continue;
					//저장할 파일 경로 및 파일명 셋팅
					System.out.println("매개변수 명 : " + item.getFieldName());
					System.out.println("파일명 : " + item.getName());
					System.out.println("파일크기 : " + item.getSize());
					System.out.println("파일타입 : " + item.getContentType());
					
					//저장할 파일 경로 및 파일명 셋팅
					File uploadFile = new File(userRoot,item.getName());
					FileDTO dto = new FileDTO();
					dto.setPath(uploadFile.getAbsolutePath());
					dto.setFno(++fno);
					dto.setType(item.getContentType());
					fList.add(dto);
					
					//최종 업로드 처리
					item.write(uploadFile);
				}
			}
			//게시글 등록
			//1. 게시글 번호 받음
			bno = BoardService.getInstance().selectBoardNo();
			final int temp = bno;
			//2. 게시글 DB에 저장
			board.setBno(bno);
			BoardService.getInstance().insertBoard(board);
			
			//파일 목록 등록
			//1. FileDTO에 게시글번호(bno)를 저장
			fList.forEach(t -> t.setBno(temp));
			//2. DB에 저장
			BoardService.getInstance().insertFile(fList);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//게시글 등록 후 해당 게시글을 조회하는 페이지로 이동
		//boardView.do?bno=새게시글번호
		return new ModelAndView(request.getContextPath()+"boardView.do?bno="+bno, true);
	}

}











