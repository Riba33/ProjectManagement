package controller.project;

import lombok.SneakyThrows;
import model.Customer;
import model.Project;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@WebServlet("/update-project")
public class UpdateProjectServlet extends HttpServlet {
    BaseService<Project, Long> service = ServiceFactory.of(Project.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/project/update-project.jsp").forward(req,resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String name = req.getParameter("name");
        final Date date = dateFormat.parse(req.getParameter("date"));
        final String id = req.getParameter("id");
        final Project project = Project.builder()
                        .id(Long.valueOf(id))
                        .name(name)
                        .date(date)
                        .build();
        service.save(project);
        getServletContext().getRequestDispatcher("/update-ok.jsp").forward(req,resp);
    }
}
