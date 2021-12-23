package servlets;

import beans.MathForm;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "XmlServlet", urlPatterns = "/result.xml")
public class XmlServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/xml;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()){
            MathForm form = (MathForm) req.getSession().getAttribute("MathForm");
            if (form != null) {
                JAXBContext jc = JAXBContext.newInstance(MathForm.class);
                Marshaller marshaller = jc.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(form, out);
            } else {
                out.println("<error>error XML</error>");
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}

