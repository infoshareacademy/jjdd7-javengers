package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.entity.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");




        User user1 = new User();
        user1.setName("Adam");
        user1.setSurname("Adamiak");
        user1.setLogin("AA");
        user1.setPassword("sdsd");
        user1.setUserType("User");
        userService.save(user1);

        User user2 = new User();
        user2.setName("asdAdamasd");
        user2.setSurname("asdAdamiak");
        user2.setLogin("asAasdA");
        user2.setPassword("asdsdsd");
        user2.setUserType("User");
        userService.save(user2);


        Template template = templateProvider.getTemplate(getServletContext(), "index.ftlh");
        Map<String, Object> model = new HashMap<>();
        try {
            template.process(model, resp.getWriter());
        } catch (IOException | TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
