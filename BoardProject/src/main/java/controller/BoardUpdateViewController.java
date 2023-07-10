package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardUpdateViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView view = null;
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardDTO dto = BoardService.getInstance().selectBoard(bno);
		if(dto != null) {
			request.setAttribute("board", dto);
			view = new ModelAndView("board_update_view.jsp", false);
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>");
			response.getWriter().append("alert('해당 게시글이 없습니다.');");
			response.getWriter().append("location.href='"+request.getContextPath() + "/main.do'");
			response.getWriter().append("</script>");
		}
		
		return view;
	}

}







