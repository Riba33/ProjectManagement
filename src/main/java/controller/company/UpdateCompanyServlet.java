package controller.company;

import model.Company;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/update-company")
public class UpdateCompanyServlet extends HttpServlet {
    BaseService<Company, Long> service = ServiceFactory.of(Company.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/company/update-company.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name = req.getParameter("name");
        final String safer = req.getParameter("safer");
        final String id = req.getParameter("id");
        final Company company= new Company();
        company.setId(Long.valueOf(id));
        company.setName(name);
        company.setSafer(safer);
        service.save(company);
        getServletContext().getRequestDispatcher("/view/update-ok.jsp").forward(req,resp);
    }
}
