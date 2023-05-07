package ru.rrenat358;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// http://localhost:8080/client2/first_servlet
public class FirstServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            resp.getWriter().printf("<h1>Слово" + i + "</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

    /*
    <html><body>
    <h1>0</h1>
    <h1>1</h1>
    <h1>2</h1>
    <h1>3</h1>
    <h1>4</h1>
    <h1>5</h1>
    <h1>6</h1>
    <h1>7</h1>
    <h1>8</h1>
    <h1>9</h1>
    </body></html>
     */

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}