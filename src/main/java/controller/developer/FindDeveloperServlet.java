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

@WebServlet("/find-developer")
public class FindDeveloperServlet extends HttpServlet {
    BaseService<Developer, Long> service = ServiceFactory.of(Developer.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/developer/find-developer-by-name.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Developer> developer = service.findByName(name);
        if(developer.isEmpty())
            getServletContext().getRequestDispatcher("/not-found.jsp").forward(req,resp);
        else {
            req.setAttribute("companies", developer);
            getServletContext().getRequestDispatcher("/developer/show-developers.jsp").forward(req, resp);
        }
    }
}
