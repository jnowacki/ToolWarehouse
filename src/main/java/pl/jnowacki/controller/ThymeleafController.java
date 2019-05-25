package pl.jnowacki.controller;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "Thymeleaf" , value = "/hello-thymeleaf")
public class ThymeleafController extends HttpServlet {

    private TemplateEngine templateEngine;

    @Override
    public void init() throws ServletException {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(getServletContext());
        templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("/WEB-INF/thymeleaf/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheTTLMs(3600000L);
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setHeaders(resp);

        WebContext ctx = new WebContext(req, resp, req.getServletContext());
        ctx.setVariable("currentDate", new Date());

        templateEngine.process("welcome", ctx, resp.getWriter());
    }

    private void setHeaders(HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
    }
}
