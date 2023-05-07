package ru.rrenat358;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormResultsServlet", urlPatterns = "/formResults.html")
public class FormResultsServlet extends HttpServlet {
    // http://localhost:8080/jee/formResults.html?info=Bob
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        String infoParam = req.getParameter("info");

        out.println("<html><body><h1>" + infoParam + "</h1></body></html>");
        out.close();
    }
}
