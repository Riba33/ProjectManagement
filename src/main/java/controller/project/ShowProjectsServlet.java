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

@WebServlet("/show-projects")
public class ShowProjectsServlet extends HttpServlet {
    private BaseService<Project, Long> service = ServiceFactory.of(Project.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Project> all = service.findALL();
        req.setAttribute("projects",all);
        getServletContext().getRequestDispatcher("/view/project/show-projects.jsp").forward(req,resp);
    }
}
