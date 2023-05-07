package ru.rrenat358;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcServlet", urlPatterns = "/sum")
public class CalcServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(CalcServlet.class);

    // GET http://localhost:8080/jee/sum?a=10&b=20
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        int firstNumber = Integer.parseInt(req.getParameter("a"));
        int secondNumber = Integer.parseInt(req.getParameter("b"));
        int sum = firstNumber + secondNumber;

        out.println("<html><body><h1>" + String.format("%d + %d = %d", firstNumber, secondNumber, sum) + "</h1></body></html>");
        out.close();
    }
}
