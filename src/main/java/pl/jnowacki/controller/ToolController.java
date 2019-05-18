package pl.jnowacki.controller;

import pl.jnowacki.service.ToolsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToolList" , value = "/")
public class ToolController extends HttpServlet {

    private static final String TOOL_VAR_NAME = "tools";

    private ToolsService toolsService = new ToolsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initializeTools();

        req.getRequestDispatcher("/tools.jsp").forward(req, resp);
    }

    private void initializeTools() {
        if (getServletContext().getAttribute(TOOL_VAR_NAME) == null) {
            getServletContext().setAttribute(TOOL_VAR_NAME, toolsService.getTools());
        }
    }
}
