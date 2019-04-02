package edu.wap.jobs.controller;

import edu.wap.jobs.dao.*;
import edu.wap.jobs.domain.AppliedJobs;
import edu.wap.jobs.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/jobDetails")
public class JobDetailsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        req.setAttribute("jobDetails",new JobsDao().get(Integer.valueOf(id)));
        req.getRequestDispatcher("pages/jobDetails/jobDetails.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppliedJobDao appliedJobDao = new AppliedJobDao();
        int jobId = Integer.parseInt(req.getParameter("id")) ;
        int userId = ((User)req.getSession().getAttribute("loggedUser")).getId();
        appliedJobDao.save(new AppliedJobs(jobId,userId));

        resp.setContentType("application/text");
        PrintWriter out = resp.getWriter();
        out.print("Job Applied successfully");
        out.flush();
    }
}