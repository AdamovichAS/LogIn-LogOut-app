package by.itacademy.jd2.tomcat.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("login")){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        req.getSession().removeAttribute("login");
        req.getSession().removeAttribute("password");
        req.getSession().removeAttribute("role");
        req.getRequestDispatcher("/WEB-INF/view/logout.jsp").forward(req, resp);
    }
}
