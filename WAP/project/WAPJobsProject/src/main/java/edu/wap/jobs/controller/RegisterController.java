package edu.wap.jobs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import edu.wap.jobs.dao.UserDao;
import edu.wap.jobs.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       UserDao userDao = new UserDao();

        User user = new User(req.getParameter("firstName"),req.getParameter("lastName"),req.getParameter("gender"),req.getParameter("email"), req.getParameter("password"));
        User foundUser = userDao.isExistingUser(user);


        if (foundUser != null) {
            req.setAttribute("script","<script type=\"text/javascript\">\n" +
                    "                    document.addEventListener('DOMContentLoaded', function() {\n" +
                    "                        $.jGrowl('The User Already registered', {\n" +
                    "                            header: 'Oh snap!',\n" +
                    "                            theme: 'bg-danger'\n" +
                    "                        });\n" +
                    "                    });\n" +
                    "                </script>");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }
        else{
            userDao.save(user);
            req.setAttribute("loginScript","<script type=\"text/javascript\">\n" +
                    "                    document.addEventListener('DOMContentLoaded', function() {\n" +
                    "                        $.jGrowl('User Registered Successfully', {\n" +
                    "                            header: 'Well done!',\n" +
                    "                            theme: 'bg-success'\n" +
                    "                        });\n" +
                    "                    });\n" +
                    "                </script>");
            req.getRequestDispatcher("login.jsp").forward(req,resp);

            return;
        }

    }

}
