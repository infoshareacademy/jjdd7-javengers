package service;

import dao.RecipeRepositoryDaoBean;
import domain.Recipe;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("recipies")
public class RecipeServlet {
    @EJB
    RecipeRepositoryDaoBean recipeRepositoryDaoBean;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> allRecipes() {
        return recipeRepositoryDaoBean.loadRecipiesList();
    }
}

