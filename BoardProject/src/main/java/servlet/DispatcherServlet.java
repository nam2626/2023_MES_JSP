package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import view.ModelAndView;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getRequestURI());
		String arr[] = request.getRequestURI().split("/");
		String command = arr[arr.length-1];
		System.out.println(command);
		
		//작업할 컨트롤러 생성
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		ModelAndView view = null;//이동할 페이지 경로
		
		if(controller != null)
			view = controller.execute(request, response);
		
		//ajax 처리 하는 부분이면 페이지 이동 X
		if(view == null) return;
		
		//페이지 이동하는 부분
		if(view.isRedirect())
			response.sendRedirect(view.getPath());
		else
			request.getRequestDispatcher(view.getPath()).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
