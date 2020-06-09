package spring;
import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by ning on 2017/8/27.
 */
public class WebDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    @Override  
    protected Filter[] getServletFilters() {  
    	CharacterEncodingFilter charFilter = new CharacterEncodingFilter();
        charFilter.setEncoding("UTF-8");
        charFilter.setForceEncoding(true);
        
    	HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter(); 
        return new Filter[] {hiddenHttpMethodFilter,charFilter};  
    } 

 /* protected void customizeRegisteration(ServletRegistration.Dynamic registration){
      registration.setMultipartConfig(new MultipartConfigElement("spring/uploads"));
  }*/
}
