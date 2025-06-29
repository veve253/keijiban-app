package controller.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.User;
import model.UserDao;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new UserDao().findByUsernameAndPassword(username, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            res.sendRedirect("/keijiban-app/post/read");
        } else {
            req.setAttribute("error", "ログイン失敗");
            req.getRequestDispatcher("/login.jsp").forward(req, res);
        }
    }
}

