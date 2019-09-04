package service;

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
@WebServlet("/name")
public class DeleteServlet extends HttpServlet {
@EJB
  RecipeRepositoryDaoBean recipeRepositoryDaoBean;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    PrintWriter writer = resp.getWriter();

    List<Recipe> recipeList = recipeRepositoryDaoBean.loadRecipiesList();
    for (Recipe recipe : recipeList) {

      writer.println("ID: " + recipe.getId() );
      writer.println("Name: " + recipe.getName());
      writer.println("ID: " + recipe.getId() );
      writer.println("Name: " + recipe.getName());

      writer.println("<button id='btn' data-id='" + recipe.getId() + "' class='delete-user'>Delete user</button></td></tr>");
    }
    writer.println("</form></table></body></html>");

  }

}
