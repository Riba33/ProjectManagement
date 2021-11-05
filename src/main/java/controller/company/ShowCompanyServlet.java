package controller.company;

import model.Company;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/show-companies"})
public class ShowCompanyServlet extends HttpServlet {
    private BaseService<Company, Long> service = ServiceFactory.of(Company.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Company> all = service.findALL();
        req.setAttribute("companies",all);
        getServletContext().getRequestDispatcher("/company/show-companies.jsp").forward(req,resp);
    }
}
