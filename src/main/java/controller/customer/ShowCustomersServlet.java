package controller.customer;

import model.Customer;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("show-customers")
public class ShowCustomersServlet extends HttpServlet {
    private BaseService<Customer, Long> service = ServiceFactory.of(Customer.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Customer> all = service.findALL();
        req.setAttribute("customers",all);
        getServletContext().getRequestDispatcher("/customer/show-customers.jsp").forward(req,resp);
    }
}