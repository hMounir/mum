package edu.wap.jobs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wap.jobs.dao.StateDao;
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

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    private ObjectMapper objectMapper;

    public ProfileController() {
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("stateList",new StateDao().getAll());
        req.getRequestDispatcher("pages/profile/profile.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = objectMapper.readValue(req.getReader(),User.class);
        UserDao userDao = new UserDao();
        User foundUser = userDao.get(user.getId());

        user.setCreatedDate(foundUser.getCreatedDate());
        user.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        userDao.update(user);

        req.getSession().setAttribute("loggedUser",user);

        resp.setContentType("application/json");
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();
        out.print("{\"message\":\"User Profile updated successfully\"}");
        out.flush();
    }
}
