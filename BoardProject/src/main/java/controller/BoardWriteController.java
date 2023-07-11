package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
				}else {
					//파일 업로드
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return null;
	}

}











