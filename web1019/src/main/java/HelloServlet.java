

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(value={"/hello","/helloworld"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("<h1>doGet ").append("Hello World1</h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//response.getWriter().append("<h1>doPost").append("Hello World222222</h1>");
		String g=request.getParameter("score");
		//response.getWriter().append("<h1>doPost").append(g+"</h1>");
		try {
			int value=Integer.parseInt(g);
			//設置傳形成數字 可以有效避免輸入文字的錯誤
			response.getWriter().append("<h1>doPost Integer ").append(g+"</h1>");
			response.getWriter().close();
			return;
		}catch(NumberFormatException ex) {
			response.getWriter().append("<h1>doPost Integer error ").append(g+"</h1>");
		}
		
		
	}

}
