package pl.jnowacki.controller;

import pl.jnowacki.dao.UserDao;
import pl.jnowacki.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login" , value = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        switch (action) {
            case "login":
                login(req, resp);
                break;
            case "logout":
                logout(req, resp);
                break;
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username != null && "myUser".equals(username)
                && password != null && "myPassword".equals(password)) {
            req.getSession().setAttribute("userName", username);
            resp.sendRedirect("/");
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getSession().invalidate();
        resp.sendRedirect("/login");
    }
}
