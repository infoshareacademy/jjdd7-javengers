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
    urlPatterns = {"/admin-view"},
    initParams = {
        @WebInitParam(name = "type", value = "admin"),
    }
)
public class AdminAuthorisationFilter implements Filter {

  private String userType;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Override
  public void init(FilterConfig filterConfig) {
    userType = filterConfig.getInitParameter("type");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

    String authorisationType = String.valueOf(httpServletRequest.getSession().getAttribute("userType"));
    if (authorisationType == null || authorisationType.isEmpty()) {
      authorisationType = "guest";
    }

    if (!(authorisationType.equals(userType))) {
      httpServletResponse.sendRedirect("/home");
      logger.warn("An unauthorized attempt to access the admin panel has occurred!");
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }

}
