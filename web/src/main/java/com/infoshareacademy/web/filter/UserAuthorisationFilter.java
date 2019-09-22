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
    filterName = "UserAuthorizationFilter",
    urlPatterns = {"/user/*"},
    initParams = {
        @WebInitParam(name = "user", value = "user"),
            @WebInitParam(name = "admin", value = "admin")
    }
)
public class UserAuthorisationFilter implements Filter {

  private String user;
  private String admin;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Override
  public void init(FilterConfig filterConfig) {
    user = filterConfig.getInitParameter("user");
    admin = filterConfig.getInitParameter("admin");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

    String checkedType = String.valueOf(httpServletRequest.getSession().getAttribute("userType"));
    if (checkedType == null || checkedType.isEmpty()) {
      checkedType = "guest";
    }

    if (!(checkedType.equals(user) || !(checkedType.equals(admin)))){
      httpServletResponse.sendRedirect("/home");
      logger.warn("An unauthorized attempt to access the user view has occurred!");
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }

}
