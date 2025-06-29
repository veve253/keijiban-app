package controller.post;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.PostDao;
import model.User;

@WebServlet("/post/delete")
public class PostDeleteServlet extends HttpServlet {

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

        // パラメータ取得と削除処理
        int postId = Integer.parseInt(req.getParameter("id"));
        PostDao.delete(postId);

        // 一覧へリダイレクト
        res.sendRedirect(req.getContextPath() + "/post/read");
    }
}
