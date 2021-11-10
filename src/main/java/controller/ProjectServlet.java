package controller;

import lombok.SneakyThrows;
import model.Project;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/project/*")
public class ProjectServlet extends HttpServlet {
    BaseService<Project, Long> service = ServiceFactory.of(Project.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] command = req.getPathInfo().split("/");
        switch (command[1]){
            case "show-project":
                List<Project> all = service.findALL();
                req.setAttribute("projects",all);
                getServletContext().getRequestDispatcher("/view/project/show-projects.jsp").forward(req,resp);
                break;
            case "find-projects-by-name":
                String name = req.getParameter("name");
                List<Project> projects = service.findByName(name);
                if(projects.isEmpty()) {
                    req.setAttribute("message","Project not found!");
                    getServletContext().getRequestDispatcher("/view/message.jsp").forward(req, resp);
                }
                else {
                    req.setAttribute("projects", projects);
                    getServletContext().getRequestDispatcher("/view/project/show-projects.jsp").forward(req, resp);
                }
                break;
            case "update-project":
                doPut(req,resp);
                break;
            case "delete-project":
                doDelete(req,resp);
                break;
        }
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
        service.create(project);
        req.setAttribute("message","Project created!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }

    @SneakyThrows
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String name = req.getParameter("name");
        final Date date = dateFormat.parse(req.getParameter("date"));
        final String id = req.getParameter("id");
        final Project project = Project.builder()
                .id(Long.valueOf(id))
                .name(name)
                .date(date)
                .build();
        service.update(project);
        req.setAttribute("message","Project updated!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        service.deleteById(id);
        req.setAttribute("message","Project deleted!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }
}
