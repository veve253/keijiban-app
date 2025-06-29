package controller.user;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

@WebServlet("/user/register")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
        	User user = new User(username, password);
        	new UserDao().insert(user);
        } catch(Exception e) {
        	System.out.println(e);
        }
        res.sendRedirect("/keijiban-app/login.jsp");
    }
}
