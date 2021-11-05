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

@WebServlet("/delete-customer")
public class DeleteCustomerServlet extends HttpServlet {
    BaseService<Customer, Long> service = ServiceFactory.of(Customer.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Long id = Long.valueOf(req.getParameter("id"));
    service.deleteById(id);
        getServletContext().getRequestDispatcher("/delete-ok.jsp").forward(req,resp);
    }
}