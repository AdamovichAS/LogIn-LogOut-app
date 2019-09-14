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

public class NameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        if (nonNull(session.getAttribute("login")) && nonNull(session.getAttribute("password"))) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            Cookie[] cookies = req.getCookies();
            String cookieName = "loginCookie";
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
                String[] loginPassword = cookieValue.split(",");
                if(UserDAO.USERS_DATA.userIsExist(loginPassword[0],loginPassword[1])) {
                    User user = UserDAO.USERS_DATA.getUserByLogin(cookieValue);
                    session.setAttribute("login", user.getLogin());
                    session.setAttribute("password", user.getPassword());
                    session.setAttribute("role", user.getRole());
                }else {
                    cookies[cookieIndex].setMaxAge(0);
                    res.addCookie(cookies[cookieIndex]);
                    req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
                }
            } else {
                req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
            }
        }
        /*String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if(session.getAttribute("user")!=null){
            filterChain.doFilter(servletRequest,servletResponse);

        }else {
            res.sendRedirect(contextPath + "/login.jsp");
        }*/

    }

    private void moveToMenu(HttpServletRequest req, HttpServletResponse res, User.ROLE role)
            throws ServletException, IOException {


        if (role.equals(User.ROLE.ADMIN)) {

            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);

        } else if (role.equals(User.ROLE.USER)) {

            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);

        } else {

            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
