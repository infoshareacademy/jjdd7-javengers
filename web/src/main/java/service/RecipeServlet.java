package service;

import dao.RecipeRepositoryDaoBean;
import domain.Recipe;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("main")
public class RecipeServlet {
@Inject
  RecipeRepositoryDaoBean recipeRepositoryDaoBean;
  @GET
  @Path("all-recipies")
  public List<Recipe> loadtRecipesInsideContent(){
    return recipeRepositoryDaoBean.loadRecipiesList();
  }
}
