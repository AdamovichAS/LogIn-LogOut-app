package by.itacademy.jd2.tomcat;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if(session !=null && (session.getAttribute("user")!=null)){
            filterChain.doFilter(servletRequest,servletResponse);

        }else {
            res.sendRedirect(contextPath + "/login.jsp");
        }

        /*HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if(session !=null && (session.getAttribute("user")!=null)){
            filterChain.doFilter(servletRequest,servletResponse);

        }else {
            res.sendRedirect(contextPath + "/login.jsp");
        }*/
    }

    @Override
    public void destroy() {

    }
}
