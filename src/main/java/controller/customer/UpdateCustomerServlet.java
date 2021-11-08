package controller.customer;

import model.Customer;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-customer")
public class UpdateCustomerServlet extends HttpServlet {
    BaseService<Customer, Long> service = ServiceFactory.of(Customer.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/customer/update-customer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name = req.getParameter("name");
        final String safer = req.getParameter("safer");
        final String id = req.getParameter("id");
        final Customer customer= new Customer();
        customer.setId(Long.valueOf(id));
        customer.setName(name);
        customer.setSafer(safer);
        service.save(customer);
        getServletContext().getRequestDispatcher("/view/update-ok.jsp").forward(req,resp);
    }
}
