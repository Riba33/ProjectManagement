package controller.project;

import lombok.SneakyThrows;
import model.Project;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.TimeZone;

@WebServlet("create-project")
public class CreateProjectServlet extends HttpServlet {
    BaseService<Project, Long> service = ServiceFactory.of(Project.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/project/create-project.jsp").forward(req,resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String name = req.getParameter("name");
        final Date date = dateFormat.parse(req.getParameter("date"));
        final Project project= Project.builder()
                .name(name)
                .date(date)
                .build();
        try {
            service.save(project);
        }
        catch (NoSuchElementException e) {
            getServletContext().getRequestDispatcher("/create-ok.jsp").forward(req, resp);
        }
    }
}
