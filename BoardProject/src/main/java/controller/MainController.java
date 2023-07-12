package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;
import vo.PaggingVO;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//페이지 번호 읽어옴, 페이지 번호가 없다면 1로 기본값 처리 - pageNo
		int pageNo = 1;
		if(request.getParameter("pageNo") != null)
			pageNo = Integer.parseInt(request.getParameter("pageNo")); 
		//페이지당 게시글 개수(값이 없으면 기본값 처리 - 10), 페이지 그룹 개수(기본값)
		int pageOfContentCount = 10;
		if(request.getParameter("contentCount") != null)
			pageOfContentCount = Integer.parseInt(request.getParameter("contentCount"));
		//전체 게시글 개수
		int count = BoardService.getInstance().selectBoardCount();
		//PaggingVO 생성 
		PaggingVO vo = new PaggingVO(count, pageNo, pageOfContentCount, 5);
		System.out.println(vo.toString());
		List<BoardDTO> list = BoardService.getInstance().selectBoardList(pageNo, pageOfContentCount);
		
		request.setAttribute("list", list);
		request.setAttribute("pagging", vo);
			
		return new ModelAndView("main.jsp", false);
	}

}










