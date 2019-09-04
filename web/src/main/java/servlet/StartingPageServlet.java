package servlet;

import dao.RecipeRepositoryDaoBean;
import domain.Recipe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class StartingPageServlet extends HttpServlet {

  @EJB
  RecipeRepositoryDaoBean recipeRepositoryDaoBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    List<String> parametersList = Collections.list(req.getParameterNames());
    for (String parameterName : parametersList) {
      String[] values = req.getParameterValues(parameterName);
      Arrays.stream(values)
              .sorted()
              .forEach(v -> out.println(parameterName + "=" + v));
    }


    }
  }
