package com.infoshareacademy.web.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(
    filterName = "AdminAuthorizationFilter",
    urlPatterns = {"/admin-view/*","/*", "/user/*"},
    initParams = {
        @WebInitParam(name = "adminType", value = "admin"),
        @WebInitParam(name = "userType", value = "user")
    }
)
public class AdminAuthorisationFilter implements Filter {

  private String admin;
  private String user;

  @Override
  public void init(FilterConfig filterConfig) {
    admin = filterConfig.getInitParameter("adminType");
    user = filterConfig.getInitParameter("userType");
  }

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

    String path = httpServletRequest.getServletPath();
    logger.info("logger{}", path);

    String authorisationType = (String) httpServletRequest.getSession().getAttribute("userType");
    logger.info("logger{}", authorisationType);
    if (authorisationType == null || authorisationType.isEmpty()) {
      authorisationType = "guest";
    }

    if ((path.equals("/admin-view")) && !(authorisationType.equals(admin))) {
      httpServletResponse.sendRedirect("/home"); // add error message
      logger.warn("An unauthorized attempt to access the admin panel has occurred!");
    }else if((path.equals("/user")) && !(authorisationType.equals(user))){
      httpServletResponse.sendRedirect("/home"); // add error message
      logger.warn("An unauthorized attempt to access the user panel has occurred!");
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }

}
