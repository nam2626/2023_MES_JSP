package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//service 호출해서 id passwd 전달 -> dao로 id passwd 보내서 해당 정보가 있는지 Member테이블에서 확인
		MemberDTO member = MemberService.getInstance().login(id,passwd);
		
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
			//아이디 비밀번호가 일치해서 회원정보 조회한 경우
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			//일치하는 정보가 없을 경우
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().append("<script>alert('아이디 비밀번호 확인하세요');"
					+ "history.back();</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
