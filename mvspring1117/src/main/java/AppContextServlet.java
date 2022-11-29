import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.*;

@WebServlet("/AppContextServlet")
public class AppContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AppContextServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Context.class);
		Temperature temperature = (Temperature)applicationContext.getBean("temperatureBean");	
		  response.getWriter().append("Spring Temp Demo : ").append(""+temperature.convertTemperature(34.5));
		

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
