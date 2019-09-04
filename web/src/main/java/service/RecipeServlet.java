package service;

import dao.RecipeRepositoryDaoBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/all-recipies")
public class RecipeServlet extends HttpServlet {
  @EJB
  RecipeRepositoryDaoBean recipeRepositoryDaoBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String list = String.valueOf(recipeRepositoryDaoBean.loadRecipiesList());
    resp.getWriter().println(list);
  }
}
