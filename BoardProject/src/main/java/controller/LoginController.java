package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		ModelAndView view = null;
		
		MemberDTO dto = MemberService.getInstance().login(id,passwd);
		
		if(dto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>");
			response.getWriter().append("alert('로그인 실패 아이디 비밀번호를 확인하세요');");
			response.getWriter().append("history.back();");
			response.getWriter().append("</script>");
		}else {
			view = new ModelAndView("main.jsp", false);
			request.getSession().setAttribute("user", dto);
		}
		
		return view;
	}

}





