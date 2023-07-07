package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BoardDTO> list = BoardService.getInstance().selectAllBoard();
		
		request.setAttribute("list", list);
			
		return new ModelAndView("main.jsp", false);
	}

}










