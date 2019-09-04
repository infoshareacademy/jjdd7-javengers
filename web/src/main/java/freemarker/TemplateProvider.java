package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@RequestScoped
public class TemplateProvider extends HttpServlet {
    private final String TEMPLATE_DIRECTORY_PATH = "WEB-INF/fm-templates";
    private Configuration configuration;
    @Inject
    ConfigProvider configProvider;

    public Template getTemplate(ServletContext servletContext, String templateName) throws IOException {
        configuration = configProvider.getConfiguration();
        configuration.setServletContextForTemplateLoading(servletContext, TEMPLATE_DIRECTORY_PATH);
        return configuration.getTemplate(templateName);
    }
}
