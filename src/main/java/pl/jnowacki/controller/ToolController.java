package pl.jnowacki.controller;

import pl.jnowacki.model.User;
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

        String action = req.getParameter("action");

        if (action != null) {
            processAction(action, Long.valueOf(req.getParameter("id")), req);
        }

        req.setAttribute(TOOL_VAR_NAME, toolsService.getTools());
        req.getRequestDispatcher(req.getContextPath() + "/tools.jsp").forward(req, resp);
    }

    private void processAction(String action, Long toolId, HttpServletRequest req) {

        switch (action) {
            case "take":
                User user = (User)req.getSession().getAttribute("user");
                req.setAttribute(TOOL_VAR_NAME, toolsService.takeTool(toolId, user));
                break;
            case "return":
                req.setAttribute(TOOL_VAR_NAME, toolsService.returnTool(toolId));
                break;
        }
    }
}
