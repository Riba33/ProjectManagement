package controller.company;

import model.Company;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-company")
public class FindCompanyServlet extends HttpServlet {
    BaseService<Company, Long> service = ServiceFactory.of(Company.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/company/find-company-by-name.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Company> companies = service.findByName(name);
        if(companies.isEmpty())
            getServletContext().getRequestDispatcher("/not-found.jsp").forward(req,resp);
        else {
            req.setAttribute("companies", companies);
            getServletContext().getRequestDispatcher("/company/show-companies.jsp").forward(req, resp);
        }
    }
}
