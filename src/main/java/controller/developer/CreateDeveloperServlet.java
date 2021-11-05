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
import java.util.NoSuchElementException;

@WebServlet("/create-developer")
public class CreateDeveloperServlet extends HttpServlet {
    BaseService<Developer, Long> service = ServiceFactory.of(Developer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/developer/create-developer.jsp").forward(req,resp);
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
        try {
            service.save(developer);
        }
        catch (NoSuchElementException e) {
            getServletContext().getRequestDispatcher("/create-ok.jsp").forward(req, resp);
        }
    }
}
