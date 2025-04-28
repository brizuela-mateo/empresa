package filter;

import jakarta.servlet.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Myfilter implements Filter {
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("This is Servlet doFilter() Method !");

        System.out.println("Remote Host: " + servletRequest.getRemoteHost());
        System.out.println("Remote Address: " + servletRequest.getRemoteAddr());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    //Bean for AuthorizationFilter

//    @Bean
//    public FilterRegistrationBean<AuthorizationFilter> filterRegistrationBean() {
//
//        // Filter Registration Bean
//        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
//
//        // Configure Authorization Filter
//        registrationBean.setFilter(new AuthorizationFilter());
//
//        // Specify URL Pattern
//        registrationBean.addUrlPatterns("/userApi/*");
//
//        // Set the Execution Order of Filter
//        registrationBean.setOrder(1);
//
//        return registrationBean;
//    }

}
