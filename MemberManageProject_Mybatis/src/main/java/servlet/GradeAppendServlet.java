package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.GradeDTO;
import service.MemberService;

/**
 * Servlet implementation class GradeAppendServlet
 */
@WebServlet("/grade/append")
public class GradeAppendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeAppendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gradeNo = Integer.parseInt(request.getParameter("grade_no"));
		String gradeName = request.getParameter("grade_name");
		
		int result = MemberService.getInstance().insertGrade(new GradeDTO(gradeNo,gradeName));
		List<GradeDTO> list = MemberService.getInstance().selectAllGrade();
		
		JSONObject json = new JSONObject();
		if(result == 1) {
			json.put("list", new JSONArray(list));
		}
		json.put("result", result);
		
		response.getWriter().println(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
