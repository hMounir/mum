package edu.wap.jobs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wap.jobs.dao.*;
import edu.wap.jobs.domain.Jobs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/jobs")
public class JobsController extends HttpServlet {
    
    private ObjectMapper objectMapper;

    public JobsController() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestType = Optional.ofNullable(req.getParameter("requestType")).orElse("");
        int row = Optional.ofNullable(req.getParameter("row")).map(Integer::valueOf).orElse(1);
        int page = Optional.ofNullable(req.getParameter("page")).map(Integer::valueOf).orElse(15);
        List<Jobs> jobs = new JobsDao().getPaginatedJobs(row-1,page);
        switch (requestType){
            case "LIST_JOBS":
                sendAjaxData(resp,objectMapper.writeValueAsString(jobs));
                break;
            case "LIST_LOCATIONS":
                sendAjaxData(resp,objectMapper.writeValueAsString(new LocationDao().getAll()));
                break;
            case "LIST_JOB_TITLE":
                sendAjaxData(resp,objectMapper.writeValueAsString(new JobTitleDao().getAll()));
                break;
            case "LIST_INDUSTRY":
                sendAjaxData(resp,objectMapper.writeValueAsString(new IndustryDao().getAll()));
                break;
            case "LIST_COMPANY":
                sendAjaxData(resp,objectMapper.writeValueAsString(new CompanyDao().getAll()));
                break;
            case "LIST_SKILLS":
                sendAjaxData(resp,objectMapper.writeValueAsString(new SkillsDao().getAll()));
                break;
            default:
                req.setAttribute("jobs",jobs);
                int noOfPages = (int) Math.ceil(new JobsDao().getAll().size() * 1.0 / page);
                req.setAttribute("noOfPages",noOfPages);
                req.setAttribute("currentPage", row);

                req.setAttribute("locations",new LocationDao().getLimitedesults());
                req.setAttribute("jobTitles",new JobTitleDao().getLimitedesults());
                req.setAttribute("industryList",new IndustryDao().getLimitedesults());
                req.setAttribute("companyList",new CompanyDao().getLimitedesults());
                req.setAttribute("skillsList",new SkillsDao().getLimitedesults());
                req.getRequestDispatcher("pages/jobs/jobs.jsp").forward(req,resp);
        }
    }

    private void sendAjaxData(HttpServletResponse resp,String jsonObject) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.print(jsonObject);
        out.flush();
    }
}