package controller.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/logout")
public class UserLogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // セッション破棄
        HttpSession session = req.getSession(false); // 既存のセッションのみ取得
        if (session != null) {
            session.invalidate();
        }

        // ログイン画面にリダイレクト
        res.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
