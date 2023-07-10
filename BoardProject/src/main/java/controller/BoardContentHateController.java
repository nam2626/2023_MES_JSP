package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import service.BoardService;
import view.ModelAndView;

public class BoardContentHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String id = request.getParameter("id");
		JSONObject json = new JSONObject();
		
		try {
			BoardService.getInstance().insertBoardContentHate(bno, id);
			json.put("result", true);
			json.put("msg", "해당 게시글에 싫어요를 하셨습니다.");
		}catch (Exception e) {
			BoardService.getInstance().deleteBoardContentHate(bno, id);
			json.put("result", false);
			json.put("msg", "해당 게시글에 싫어요를 해제 하셨습니다.");
		}
		json.put("bhate", BoardService.getInstance().selectBoardHateCount(bno));
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(json.toString());
		
		return null;
	}

}
