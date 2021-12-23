import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import java.io.IOException;

@WebServlet("/result.xml")
public class ResultXML extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        executeRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        executeRequest(req, resp);
    }

    private void executeRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("xml");
        Task task = (Task) req.getSession().getAttribute("task");
        if (task == null){
            resp.sendRedirect("/index.xhtml");
        }else {
            JAXB.marshal(task, resp.getOutputStream());
        }
    }
}
