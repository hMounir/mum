package wap.servlet;

import wap.TestData;
import wap.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("uname");
        String password = req.getParameter("psw");
        boolean isRegitered = false;

        User foundUser = TestData.USERS_DATA.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst().orElse(null);

        if(foundUser != null){
            resp.setContentType("application/text");
            resp.setStatus(500);
            PrintWriter out = resp.getWriter();
            out.print("User already regitered");
            out.flush();
            isRegitered = true;
            resp.sendRedirect("/login");
            return;
        }
        else {
            req.getSession().setAttribute("registeredUser",foundUser);
            Cookie cookie = new Cookie("registeredUser",foundUser.toString());
            cookie.setMaxAge(30 * 24 * 60 * 60); //set it for a month
            resp.addCookie(cookie);
            resp.setContentType("application/text");
            resp.setStatus(500);
            PrintWriter out = resp.getWriter();
            out.print("User registered successfully");
            out.flush();
            isRegitered = true;
            resp.sendRedirect("/login");
            return;
        }
    }
}
