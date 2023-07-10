package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import dto.CommentDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardDTO dto = BoardService.getInstance().selectBoard(bno);
		//댓글 목록 받아서 request에 저장
		List<CommentDTO> list = BoardService.getInstance().selectCommentList(bno);
		
		request.setAttribute("board", dto);
		request.setAttribute("comment", list);
		return new ModelAndView("board_view.jsp", false);
	}

}








