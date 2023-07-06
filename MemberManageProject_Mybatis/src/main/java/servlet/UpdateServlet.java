package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		
		MemberDTO dto = new MemberDTO(id, passwd, name, age, gender.charAt(0));
		
		response.setContentType("text/html; charset=utf-8");
		try {
			int result = MemberService.getInstance().updateMember(dto);
			response.sendRedirect("main");
			response.getWriter().append("<script>");
			if(result == 0)
				response.getWriter().append("alert('수정할 회원이 없습니다');");
			else
				response.getWriter().append("alert('회원 수정이 정상적으로 이루어졌습니다.');");
			response.getWriter().append("location.href='main';");
			response.getWriter().append("</script>");
		} catch (SQLException e) {
			response.getWriter().append("<script>alert('데이터 수정 실패 입력한 데이터를 확인하세요');"
					+ "history.back();</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}







