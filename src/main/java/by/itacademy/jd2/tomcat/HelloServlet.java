package by.itacademy.jd2.tomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "HelloServlet", urlPatterns = {"/sayhello"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        User user = (User) req.getSession().getAttribute("user");
        writer.write(String.format("<p><span style='color: blue;'>Hello, %s %s!</span></p>",user.getName(),user.getLastName()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        User user = (User) req.getSession().getAttribute("user");
        writer.write(String.format("<p><span style='color: blue;'>Hello, %s %s!</span></p>",user.getName(),user.getLastName()));
    }
}
