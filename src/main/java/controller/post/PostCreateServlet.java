package controller.post;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Post;
import model.PostDao;
import model.User;

@WebServlet("/post/create")
public class PostCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            res.sendRedirect("/keijiban-app/posts.jsp");
            return;
        }

        String content = req.getParameter("content");
        if (content != null && !content.trim().isEmpty()) {
            Post post = new Post();
            post.setUserId(user.getUserId());
            post.setContent(content);
            PostDao.insert(post);
        }

        res.sendRedirect(req.getContextPath() + "/post/read");
    }
}
