package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardCommentInsertController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String comment = request.getParameter("comment");
//		HttpSession session = request.getSession();
//		MemberDTO dto = (MemberDTO) session.getAttribute("user");
//		String id = dto.getId();
		String id = ((MemberDTO)request.getSession().getAttribute("user")).getId();
		BoardService.getInstance().insertBoardComment(bno,id,comment);
		
		return new ModelAndView(request.getContextPath() +"/boardView.do?bno="+bno, true);
	}

}









