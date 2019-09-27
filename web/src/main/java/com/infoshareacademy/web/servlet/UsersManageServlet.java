package com.infoshareacademy.web.servlet;

import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.UserService;
import com.infoshareacademy.service.UsersPageService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.infoshareacademy.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/superHero/users")
public class UsersManageServlet extends HttpServlet {

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private UsersPageService usersPageService;

  @Inject
  private UserService userService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    resp.setContentType("text/html;charset=UTF-8");
    List<String> pageNumber = Arrays.asList(getParametersList(req, "page", new String[]{"1"}));
    Integer pageNo = Integer.parseInt(pageNumber.get(0));

    List<User> usersPerPage = usersPageService.getUsersPerPage(pageNo,userService.getUsersList());
    Integer lastPageNo = usersPageService.getLastNumberPage(userService.getUsersList());


    Template template = templateProvider.getTemplate(getServletContext(),
        "admin-view-users.ftlh");

    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("lastPageNumber", lastPageNo);
    dataModel.put("pageNumber", pageNo);
    dataModel.put("usersPerPage", usersPerPage);

    PrintWriter writer = resp.getWriter();
    try {
      template.process(dataModel, writer);
    } catch (TemplateException e) {
      logger.info(e.getMessage());
    }
  }

  public static String[] getParametersList(ServletRequest request, String paramName, String[] defaultValue) {
    if (request.getParameterValues(paramName) != null) {
      return request.getParameterValues(paramName);
    } else {
      return defaultValue;
    }
  }

}
