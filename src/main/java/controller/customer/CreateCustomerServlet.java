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
import java.util.NoSuchElementException;

@WebServlet("/create-customer")
public class CreateCustomerServlet extends HttpServlet {
    BaseService<Customer, Long> service = ServiceFactory.of(Customer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/customer/create-customer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name = req.getParameter("name");
        final String safer = req.getParameter("safer");
        final Customer customer= Customer.builder()
                        .name(name)
                        .safer(safer)
                        .build();
        try {
            service.save(customer);
        }
        catch (NoSuchElementException e) {
            getServletContext().getRequestDispatcher("/create-ok.jsp").forward(req, resp);
        }
    }
}
