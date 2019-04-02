package edu.wap.jobs.controller;//package edu.wap.jobs.controller;
//
//import edu.wap.jobs.dao.UserDao;
//import edu.wap.jobs.domain.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//
//@WebServlet("/index.jsp")
//public class UserController extends HttpServlet {
//
//    private UserDao userDao = new UserDao();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<User> userList = userDao.getAll();
//        req.setAttribute("userList", userList);
//        req.getRequestDispatcher("index.jsp").forward(req, resp);
//    }
//}
