package edu.wap.jobs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wap.jobs.dao.UserDao;
import edu.wap.jobs.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String remember = req.getParameter("remember");

        UserDao userDao = new UserDao();
        User user = new User(req.getParameter("email"),req.getParameter("password"));
        User foundUser = userDao.validateUser(user);

        if(foundUser == null){
//            resp.setStatus(500);
            req.setAttribute("loginScript","<script type=\"text/javascript\">\n" +
                    "                    document.addEventListener('DOMContentLoaded', function() {\n" +
                    "                        $.jGrowl('Invalid username or password', {\n" +
                    "                            header: 'Oh snap!',\n" +
                    "                            theme: 'bg-danger'\n" +
                    "                        });\n" +
                    "                    });\n" +
                    "                </script>");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            return;
        }

        req.getSession().setAttribute("loggedUser",foundUser);

        String userString = objectMapper.writeValueAsString(foundUser);
        if(remember != null){
            Cookie cookie = new Cookie("loggedUser", URLEncoder.encode( userString, "UTF-8" ));
            cookie.setMaxAge(30 * 24 * 60 * 60); //set it for a monthx
            resp.addCookie(cookie);
        }else{
            Cookie cookie = new Cookie("loggedUser",URLEncoder.encode( userString, "UTF-8" ));
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        resp.sendRedirect(req.getContextPath()+"/");
    }
}
