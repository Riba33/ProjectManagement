package controller.company;

import model.Company;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delete-company")
public class DeleteCompanyServlet extends HttpServlet {
    BaseService<Company, Long> service = ServiceFactory.of(Company.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Long id = Long.valueOf(req.getParameter("id"));
    service.deleteById(id);
        getServletContext().getRequestDispatcher("/view/delete-ok.jsp").forward(req,resp);
    }
}
