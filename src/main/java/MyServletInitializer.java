import java.util.EnumSet;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.dream.spring.servlet.MyServlet;

/**
 * Created by ning on 2017/8/29.
 */
public class MyServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet",MyServlet.class);
        myServlet.addMapping("/myServlet");
        
        servletContext.setInitParameter("defaultEncoding", "UTF-8");
		
		FilterRegistration.Dynamic encodeFilter = servletContext.addFilter("encodeFilter", CharacterEncodingFilter.class);
		encodeFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.ASYNC,DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE,DispatcherType.ERROR), false, "/*");
		encodeFilter.setInitParameter("encoding", "UTF-8");
		encodeFilter.setInitParameter("forceEncoding", "false");
    }
}


