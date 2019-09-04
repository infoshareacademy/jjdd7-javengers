package servlet;

import dao.RecipeRepositoryDaoBean;
import domain.Recipe;
import java.io.IOException;
import java.io.PrintWriter;
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
   /* String name = req.getParameter("name");
    String ingredient = req.getParameter("ingredient");*/

    PrintWriter writer = resp.getWriter();

    List<Recipe> recipeList = recipeRepositoryDaoBean.loadRecipiesList();
    for (Recipe recipe : recipeList) {

      writer.println("Id: " + recipe.getId());
      writer.println("Name: " + recipe.getName());
      writer.println("Category: " + recipe.getRecipeCategory());
      writer.println("Drink Type: " + recipe.getDrinkType());

    }
  }
}