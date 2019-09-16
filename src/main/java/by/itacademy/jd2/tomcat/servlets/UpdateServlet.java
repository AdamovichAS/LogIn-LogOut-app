package by.itacademy.jd2.tomcat.servlets;

import by.itacademy.jd2.tomcat.dao.UserDAO;
import by.itacademy.jd2.tomcat.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getAttribute("login");
        User user = UserDAO.USERS_DATA.getUserByLogin(login);
        String password = req.getParameter("password");
        int money = Integer.parseInt(req.getParameter("money"));
        user.setMoney(money);
        user.setPassword(password);
        if(UserDAO.USERS_DATA.updateUserInfo(user)){
            resp.addCookie(new Cookie("login",user.getLogin()+"/"+user.getPassword()));
            resp.getWriter().write("Update is done, new info: " + user );
        }else {
            resp.getWriter().write("Update is failed");
        }
    }
}
