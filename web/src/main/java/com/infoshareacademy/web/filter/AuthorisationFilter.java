package com.infoshareacademy.web.filter;


import com.google.common.base.Strings;
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
    urlPatterns = {"/superHero/*","/*", "/home/*"},
    initParams = {
        @WebInitParam(name = "userType", value = "admin"),
    }
)
public class AuthorisationFilter implements Filter {

  private String admin;

  @Override
  public void init(FilterConfig filterConfig) {
    admin = filterConfig.getInitParameter("userType");
  }

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;

    String path = req.getServletPath();
    logger.info("logger{}", path);

    String userType = (String) req.getSession().getAttribute("userType");
    logger.info("logger{}", userType);
    if (userType == null || userType.isEmpty()) {
      userType = "guest";
    }

    //TODO popup with message "An unauthorized attempt to the admin panel has occurred!"

    if ((path.equals("/superHero")) && !(userType.equals(admin))) {
      req.getSession().setAttribute("authorization", "unauthorizedAttempt");
//      resp.sendRedirect("/home?failed=true");
      resp.sendRedirect("/home");
      logger.warn("An unauthorized attempt to the admin panel has occurred!");
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }

}
