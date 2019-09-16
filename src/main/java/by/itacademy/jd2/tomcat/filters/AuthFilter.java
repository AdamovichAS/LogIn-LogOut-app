package by.itacademy.jd2.tomcat.filters;

import by.itacademy.jd2.tomcat.dao.UserDAO;
import by.itacademy.jd2.tomcat.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        if (nonNull(session.getAttribute("login")) && nonNull(session.getAttribute("role"))) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            Cookie[] cookies = req.getCookies();
            String cookieName = "login";
            int cookieIndex = -1;
            String cookieValue = null;
            for (int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals(cookieName)){
                    cookieValue = cookies[i].getValue();
                    cookieIndex = i;
                    break;
                }
            }
            if (nonNull(cookieValue)) {
                String[] loginPassword = cookieValue.split("/");
                if(UserDAO.USERS_DATA.userIsExist(loginPassword[0],loginPassword[1])) {
                    User user = UserDAO.USERS_DATA.getUserByLogin(loginPassword[0]);
                    session.setAttribute("login", user.getLogin());
             //       session.setAttribute("password", user.getPassword());
                    session.setAttribute("role", user.getRole());
                }else {
                    cookies[cookieIndex].setMaxAge(0);
                    res.addCookie(cookies[cookieIndex]);
                    req.getRequestDispatcher("login.jsp").forward(req, res);
                }
            } else {
                req.getRequestDispatcher("login.jsp").forward(req, res);
            }
        }

    }




    @Override
    public void destroy() {

    }
}
