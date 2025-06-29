package controller.post;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Post;
import model.PostDao;
import model.User;

@WebServlet("/post/read")
public class PostsReadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        // 投稿一覧を取得してリクエスト属性にセット
        List<Post> posts = PostDao.findAll();
        req.setAttribute("user", user);
        req.setAttribute("posts", posts);

        // JSP へフォワード
        req.getRequestDispatcher("/posts.jsp").forward(req, res);
    }
}
