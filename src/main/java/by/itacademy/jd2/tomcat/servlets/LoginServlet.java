package by.itacademy.jd2.tomcat.servlets;

import by.itacademy.jd2.tomcat.dao.UserDAO;
import by.itacademy.jd2.tomcat.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (UserDAO.USERS_DATA.userIsExist(login, password)) {
            User user = UserDAO.USERS_DATA.getUserByLogin(login);
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
            session.setAttribute("password", password);
            session.setAttribute("role", user.getRole());
            Cookie cookieLogin = new Cookie("login", login + "/" + password);
            response.addCookie(cookieLogin);
            userAdminRedirect(user.getRole(), request, response);
        }
    }

    private void userAdminRedirect(User.ROLE role, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (role) {
            case USER:
                request.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(request, response);
                break;
            case ADMIN:
                request.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
                break;
        }
    }
}
