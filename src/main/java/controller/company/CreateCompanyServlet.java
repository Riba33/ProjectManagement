package controller.company;

import model.Company;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.NoSuchElementException;

@WebServlet("/create-company")
public class CreateCompanyServlet extends HttpServlet {
    BaseService<Company, Long> service = ServiceFactory.of(Company.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/company/create-company.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name = req.getParameter("name");
        final String safer = req.getParameter("safer");
        final Company company= Company.builder()
                        .name(name)
                        .safer(safer)
                        .build();

            service.create(company);
            getServletContext().getRequestDispatcher("/view/create-ok.jsp").forward(req, resp);
    }
}
