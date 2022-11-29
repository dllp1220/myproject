package springmvc.configuration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HelloWorldInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(HelloWorldConfiguration.class);
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		  /*
  一般我們在開發web應用時，都會配置這個引數，有兩個好處：
  1、如果初始化過程失敗，則容器會提示啟動失敗，此時我們能夠提前知道相關錯誤；
  2、配置該引數相當於將初始化servlet的工作轉移到容器啟動過程，使得容器只要啟動成功後，就可立即回應web請求。
		  */
				servlet.setLoadOnStartup(1);
				servlet.addMapping("/");
			}
		}
