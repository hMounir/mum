package wap.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import wap.TestData;
import wap.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = TestData.PRODUCT_LIST();
        resp.setContentType("application/json");
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();
        out.print(new ObjectMapper().writeValueAsString(productList));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestType = req.getParameter("requestType");
        if(requestType.equals("add")){

            List<Product> checkedList =
                    req.getSession().getAttribute("checkedList")!=null
                    ? (List<Product>) req.getSession().getAttribute("checkedList")
                    : new ArrayList<>();

            Product product = new ObjectMapper().readValue(req.getReader(), Product.class);
            checkedList.add(product);
            req.getSession().setAttribute("checkedList",checkedList);

            resp.setContentType("application/text");
            resp.setStatus(200);
            PrintWriter out = resp.getWriter();
            out.print("success");
            out.flush();
        }else {
            if(req.getSession()!=null &&
                    req.getSession().getAttribute("loggedUser")!=null){
                String totalCost = req.getParameter("totalCost");
                req.setAttribute("checkoutProducts",req.getSession().getAttribute("checkedList"));
                req.setAttribute("totalCost",totalCost);
                req.getRequestDispatcher("checkout.jsp").forward(req,resp);
            }else {
                req.getSession().removeAttribute("checkedList");
                resp.sendRedirect("login.jsp");
            }
        }
//            resp.sendRedirect("login.jsp");
        //}
    }
}
