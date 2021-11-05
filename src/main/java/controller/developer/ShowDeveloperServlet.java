package controller.developer;

import model.Developer;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/show-developers"})
public class ShowDeveloperServlet extends HttpServlet {
    private BaseService<Developer, Long> service = ServiceFactory.of(Developer.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Developer> all = service.findALL();
        req.setAttribute("developers",all);
        getServletContext().getRequestDispatcher("/developer/show-developers.jsp").forward(req,resp);
    }
}
