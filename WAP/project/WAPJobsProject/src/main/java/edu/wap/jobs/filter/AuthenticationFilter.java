package edu.wap.jobs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String staticResourcesURI = request.getContextPath() + "/resources";
        String loginURI = request.getContextPath() + "/login";
        String registerURI = request.getContextPath() + "/register";
        String error404 = request.getContextPath() + "/error_404";
        String error500 = request.getContextPath() + "/error_500";

        boolean loggedIn = session != null && session.getAttribute("loggedUser") != null;
        boolean loginRequest = request.getRequestURI().contains(loginURI)
                || request.getRequestURI().contains(registerURI)
                || request.getRequestURI().contains(error404)
                || request.getRequestURI().contains(error500)
                || request.getRequestURI().contains(staticResourcesURI);

        if (loggedIn || loginRequest) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {

    }
}
