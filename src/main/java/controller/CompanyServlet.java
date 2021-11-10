package controller;

import model.Company;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet("/company/*")
public class CompanyServlet extends HttpServlet {
    private BaseService<Company, Long> service = ServiceFactory.of(Company.class);

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String safer = req.getParameter("safer");
        final String id = req.getParameter("id");
        final Company company= new Company();
        company.setId(Long.valueOf(id));
        company.setName(name);
        company.setSafer(safer);
        service.update(company);
        req.setAttribute("message","Company updated!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        service.deleteById(id);
        req.setAttribute("message","Company deleted");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] command = req.getPathInfo().split("/");
        switch (command[1]){
            case "show-companies":
                List<Company> all = service.findALL();
                req.setAttribute("companies",all);
                getServletContext().getRequestDispatcher("/view/company/show-companies.jsp").forward(req,resp);
                break;
            case "find-company":
                String name = req.getParameter("name");
                List<Company> companies = service.findByName(name);
                if(companies.isEmpty()) {
                    req.setAttribute("message","Company not found!");
                    req.getServletContext().getRequestDispatcher("/view/message.jsp").forward(req, resp);
                }
                else {
                    req.setAttribute("companies", companies);
                    req.getServletContext().getRequestDispatcher("/view/company/show-companies.jsp").forward(req,resp);
                }
                break;
            case "update-company":
                doPut(req,resp);
                break;
            case "delete-company":
                doDelete(req,resp);
                break;
        }
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
        req.setAttribute("message","Company saved!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req, resp);
    }
}
