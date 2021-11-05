package controller.project;

import model.Project;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("find-project")
public class FindProjectServlet extends HttpServlet {
    BaseService<Project, Long> service = ServiceFactory.of(Project.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/project/find-project-by-name.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Project> projects = service.findByName(name);
        if(projects.isEmpty())
            getServletContext().getRequestDispatcher("/not-found.jsp").forward(req,resp);
        else {
            req.setAttribute("projects", projects);
            getServletContext().getRequestDispatcher("/project/show-projects.jsp").forward(req, resp);
        }
    }
}
