package wap.servlet;

import wap.TestData;
import wap.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("uname");
        String password = req.getParameter("psw");
        String rememberMe = req.getParameter("remember");

        User foundUser = TestData.USERS_DATA.stream()
                .filter(user -> user.equals(new User(userName,password)))
                .findFirst().orElse(null);

        if(foundUser == null){
            resp.setContentType("application/text");
            resp.setStatus(500);
            PrintWriter out = resp.getWriter();
            out.print("User not found");
            out.flush();
            return;
        }

        req.getSession().setAttribute("loggedUser",foundUser);

        if(rememberMe != null){
            Cookie cookie = new Cookie("loggedUser",foundUser.getUserName());
            cookie.setMaxAge(30 * 24 * 60 * 60); //set it for a month
            resp.addCookie(cookie);
        }else{
            Cookie cookie = new Cookie("loggedUser",foundUser.getUserName());
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }

        Cookie cookie = new Cookie("month","$100");
        cookie.setMaxAge(30 * 24 * 60 * 60);
        resp.addCookie(cookie);

        resp.setContentType("application/text");
        PrintWriter out = resp.getWriter();
        out.print("User logged in successfully");
        out.flush();
    }
}
