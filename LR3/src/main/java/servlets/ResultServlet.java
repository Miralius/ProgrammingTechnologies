package servlets;

import beans.MathForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResultServlet", urlPatterns = "/html/result.html")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MathForm form = (MathForm) req.getSession().getAttribute("MathForm");
        form.exponentiation();
        getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
    }

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MathForm form = (MathForm) req.getSession().getAttribute("MathForm");
        form.exponentiation();
        getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}