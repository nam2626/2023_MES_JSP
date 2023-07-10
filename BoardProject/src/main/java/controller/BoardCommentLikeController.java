package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardCommentLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = ((MemberDTO)request.getSession().getAttribute("user")).getId();
		int cno = Integer.parseInt(request.getParameter("cno"));
		JSONObject json = new JSONObject();
		try {
			BoardService.getInstance().insertCommentLike(id,cno);
			json.put("msg", "해당 댓글에 좋아요 하셨습니다");
		}catch (Exception e) {
			BoardService.getInstance().deleteCommentLike(id,cno);
			json.put("msg", "해당 댓글에 좋아요 해제 하셨습니다");
		}
		response.getWriter().println(json.toString());
		return null;
	}

}











