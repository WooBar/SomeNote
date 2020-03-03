//package com.duanxp.module.filter;
//
//import org.apache.catalina.filters.RemoteIpFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
///**
// * @Version
// * @Author dxp
// * @Date 2019/8/19 0019
// */
//@Configuration
//public class WebConfiguration {
//    @Bean
//    public RemoteIpFilter remoteIpFilter() {
//        return new RemoteIpFilter();
//    }
//    @Bean
//    public FilterRegistrationBean testFilterRegistration() {
//
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new MyFilter());
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("MyFilter");
//        registration.setOrder(1);
//        return registration;
//    }
//
//    public class MyFilter implements Filter {
//        @Override
//        public void destroy() {
//            // TODO Auto-generated method stub
//        }
//
//        @Override
//        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
//                throws IOException, ServletException {
//            // TODO Auto-generated method stub
//            HttpServletRequest request = (HttpServletRequest) srequest;
//            System.out.println("this is MyFilter,url :"+request.getRequestURI());
//            filterChain.doFilter(srequest, sresponse);
//        }
//        @Override
//        public void init(FilterConfig arg0) throws ServletException {
//            // TODO Auto-generated method stub
//        }
//    }
//}
