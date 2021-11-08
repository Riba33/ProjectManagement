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
import java.util.List;

@WebServlet("/find-customer")
public class FindCustomerServlet extends HttpServlet {
    BaseService<Customer, Long> service = ServiceFactory.of(Customer.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/customer/find-customer-by-name.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Customer> customer = service.findByName(name);
        if(customer.isEmpty())
            getServletContext().getRequestDispatcher("/view/not-found.jsp").forward(req,resp);
        else {
            req.setAttribute("customer", customer);
            getServletContext().getRequestDispatcher("/view/customer/show-customer.jsp").forward(req, resp);
        }
    }
}
