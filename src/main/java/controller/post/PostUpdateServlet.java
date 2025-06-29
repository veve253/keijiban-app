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

@WebServlet("/post/update")
public class PostUpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        // セッション確認
        HttpSession session = req.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;
        if (user == null) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        // パラメータ取得
        int postId = Integer.parseInt(req.getParameter("id"));
        String newContent = req.getParameter("content");

        // 投稿オブジェクト作成
        Post post = new Post();
        post.setId(postId);
        post.setContent(newContent);

        // 更新実行
        PostDao.update(post);

        // 一覧へリダイレクト
        res.sendRedirect(req.getContextPath() + "/post/read");
    }
}
