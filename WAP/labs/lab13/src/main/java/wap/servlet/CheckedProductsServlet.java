package wap.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import wap.TestData;
import wap.model.ConfirmCheckout;
import wap.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/checkout")
public class CheckedProductsServlet extends HttpServlet {

    private ObjectMapper objectMapper;

    public CheckedProductsServlet() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConfirmCheckout confirmCheckout = objectMapper.readValue(req.getReader(),ConfirmCheckout.class);
        System.out.println(confirmCheckout);

        resp.setContentType("application/text");
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();
        out.print("checkout confirmed successfully");
        out.flush();
    }
}
