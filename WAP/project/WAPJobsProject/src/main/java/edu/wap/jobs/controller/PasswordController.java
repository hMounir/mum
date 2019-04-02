package edu.wap.jobs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wap.jobs.dao.UserDao;
import edu.wap.jobs.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet("/password")
public class PasswordController extends HttpServlet {


    private ObjectMapper objectMapper;

    public PasswordController() {
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = objectMapper.readValue(req.getReader(),User.class);
        UserDao userDao = new UserDao();
        User foundUser = userDao.get(user.getId());

        user.setCreatedDate(foundUser.getCreatedDate());
        user.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        user.setPassword(req.getParameter("newPassword"));
        userDao.update(user);

        req.getSession().setAttribute("loggedUser",user);

        resp.setContentType("application/json");
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();
        out.print("{\"message\":\"Password updated successfully\"}");
        out.flush();
    }
}
