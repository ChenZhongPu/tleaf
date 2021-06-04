package tleaf.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TemplateUtils {
    private static TemplateEngine templateEngine;

    private static TemplateEngine getTemplateEngine(ServletContext context) {
        if (templateEngine == null) {
            ServletContextTemplateResolver templateResolver =
                    new ServletContextTemplateResolver(context);
            templateResolver.setTemplateMode(TemplateMode.HTML);
            templateResolver.setPrefix("/WEB-INF/templates/");
            templateResolver.setSuffix(".html");
            templateResolver.setCacheTTLMs(3600000L);
            templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(templateResolver);
        }
        return templateEngine;
    }

    /**
     * Response a HTML using template encoded with UTF-8
     * @param template
     * @param webContext
     * @throws ServletException
     */
    public static void process(String template, WebContext webContext) throws ServletException {
        HttpServletResponse response = webContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            getTemplateEngine(webContext.getServletContext())
                    .process(template, webContext, response.getWriter());
        } catch (Exception e) {
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            throw new ServletException(e);
        }
    }
}
