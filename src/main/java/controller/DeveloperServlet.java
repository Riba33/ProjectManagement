package controller;

import model.Developer;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/developer/*")
public class DeveloperServlet extends HttpServlet {
    BaseService<Developer, Long> service = ServiceFactory.of(Developer.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] command = req.getPathInfo().split("/");
        switch (command[1]){
            case "show-developer":
                List<Developer> all = service.findALL();
                req.setAttribute("developers",all);
                getServletContext().getRequestDispatcher("/view/developer/show-developers.jsp").forward(req,resp);
                break;
            case "find-developer":
                String name = req.getParameter("name");
                List<Developer> developers = service.findByName(name);
                if(developers.isEmpty()) {
                    req.setAttribute("message","Developer not found!");
                    getServletContext().getRequestDispatcher("/view/message.jsp").forward(req, resp);
                }
                else {
                    req.setAttribute("developers", developers);
                    getServletContext().getRequestDispatcher("/view/developer/show-developers.jsp").forward(req, resp);
                }
                break;
            case "update-developer":
                doPut(req,resp);
                break;
            case "delete-developer":
                doDelete(req,resp);
                break;
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final String surname = req.getParameter("surname");
        final String age = req.getParameter("age");
        final String gender = req.getParameter("gender");
        final String salary = req.getParameter("salary");
        final Developer developer= Developer.builder()
                .id(Long.valueOf(id))
                .name(name)
                .surname(surname)
                .age(Integer.parseInt(age))
                .gender(gender)
                .salary(Integer.parseInt(salary))
                .build();
        service.update(developer);
        req.setAttribute("message","Developer updated!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        service.deleteById(id);
        req.setAttribute("message","Developer deleted!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String surname = req.getParameter("surname");
        final String age = req.getParameter("age");
        final String gender = req.getParameter("gender");
        final String salary = req.getParameter("salary");
        final Developer developer= Developer.builder()
                .name(name)
                .surname(surname)
                .age(Integer.valueOf(age))
                .gender(gender)
                .salary(Integer.valueOf(salary))
                .build();
        service.create(developer);
        req.setAttribute("message","Developer created!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }
}
