package controller.developer;

import model.Company;
import model.Developer;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-developer")
public class UpdateDeveloperServlet extends HttpServlet {
    BaseService<Developer, Long> service = ServiceFactory.of(Developer.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/developer/update-developer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        service.save(developer);
        getServletContext().getRequestDispatcher("/update-ok.jsp").forward(req,resp);
    }
}
