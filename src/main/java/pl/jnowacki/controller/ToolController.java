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

        String action = req.getParameter("action");

        if (action != null) {
            processAction(action, Long.valueOf(req.getParameter("id")));
        }

        req.getRequestDispatcher("/tools.jsp").forward(req, resp);
    }

    private void processAction(String action, Long toolId) {
        switch (action) {
            case "take":
                toolsService.takeTool(toolId);
                break;
            case "return":
                toolsService.returnTool(toolId);
                break;
        }

        initializeTools();
    }

    private void initializeTools() {
        getServletContext().setAttribute(TOOL_VAR_NAME, toolsService.getTools());
    }
}
