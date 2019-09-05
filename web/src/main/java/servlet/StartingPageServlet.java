package servlet;

import dao.RecipeRepositoryDaoBean;
import freemarker.TemplateProvider;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebServlet("/main")
public class StartingPageServlet extends HttpServlet {

    @EJB
    RecipeRepositoryDaoBean recipeRepositoryDaoBean;
    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        PrintWriter writer = resp.getWriter();
        List<String> parameters = Collections.list(req.getParameterNames());
        List<String> categoriesValues = Arrays.asList(req.getParameterValues("categories[]"));
        List<String> ingredientsValues = Arrays.asList(req.getParameterValues("ingredients[]"));
        List<String> allOrFavouritesValues = Arrays.asList(req.getParameterValues("listOptions[]"));
        out.println(categoriesValues);
        out.println(ingredientsValues);
        out.println(allOrFavouritesValues);

    }

}


