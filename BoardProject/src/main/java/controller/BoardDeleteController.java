package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardDeleteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		MemberDTO member = (MemberDTO) request.getSession().getAttribute("user");
		BoardDTO board = BoardService.getInstance().selectBoard(bno);
		ModelAndView view = null;
		if(member == null || board == null || !member.getId().equals(board.getWriter())) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>");
			response.getWriter().append("alert('게시글 삭제 실패');");
			response.getWriter().append("location.href='"+request.getContextPath() + "/main.do'");
			response.getWriter().append("</script>");
			
		}else {
			BoardService.getInstance().deleteBoard(bno);
			view = new ModelAndView(request.getContextPath() + "/main.do", true);
		}
		
		
		return view;
	}

}











