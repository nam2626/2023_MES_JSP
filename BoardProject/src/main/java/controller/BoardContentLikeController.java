package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import service.BoardService;
import view.ModelAndView;

public class BoardContentLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String id = request.getParameter("id");
		JSONObject json = new JSONObject();
		
		try {
			//좋아요가 정상적으로 처리가 되었을 때
			BoardService.getInstance().insertBoardContentLike(bno, id);
			json.put("result", true);
			json.put("msg", "해당 게시글에 좋아요를 하셨습니다.");
		}catch (Exception e) {
			//좋아요가 이미 되어 있을 때
			BoardService.getInstance().deleteBoardContentLike(bno, id);
			json.put("result", false);
			json.put("msg", "해당 게시글에 좋아요를 해제 하셨습니다.");
		}
		json.put("blike", BoardService.getInstance().selectBoardLikeCount(bno));
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(json.toString());
		
		return null;
	}

}










