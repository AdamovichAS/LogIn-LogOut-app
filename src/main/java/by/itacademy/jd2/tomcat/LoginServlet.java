package by.itacademy.jd2.tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        if (user == null) {
            request.getSession().setAttribute("user", new User(name, lastName));
            request.getRequestDispatcher("/hello").forward(request, response);
        } else {
            if (name != null && lastName != null)
                request.getSession().removeAttribute("user");
                request.getSession().setAttribute("user", new User(name, lastName));
                request.getRequestDispatcher("/hello").forward(request, response);
        }

    }
}
