package controller;

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

@WebServlet("/customer/*")
public class CustomerServlet extends HttpServlet {
    BaseService<Customer, Long> service = ServiceFactory.of(Customer.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] command = req.getPathInfo().split("/");
        switch (command[1]){
            case "show-customers":
                List<Customer> all = service.findALL();
                req.setAttribute("customers",all);
                getServletContext().getRequestDispatcher("/view/customer/show-customers.jsp").forward(req,resp);
                break;
            case "find-customer":
                String name = req.getParameter("name");
                List<Customer> customer = service.findByName(name);
                if(customer.isEmpty()) {
                    req.setAttribute("message","Customer not found!");
                    getServletContext().getRequestDispatcher("/view/message.jsp").forward(req, resp);
                }
                else {
                    req.setAttribute("customers", customer);
                    getServletContext().getRequestDispatcher("/view/customer/show-customers.jsp").forward(req, resp);
                }
                break;
            case "update-customer":
                doPut(req,resp);
                break;
            case "delete-customer":
                doDelete(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String safer = req.getParameter("safer");
        final Customer customer= Customer.builder()
                .name(name)
                .safer(safer)
                .build();
        service.create(customer);
        req.setAttribute("message","Customer created!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String safer = req.getParameter("safer");
        final String id = req.getParameter("id");
        final Customer customer= new Customer();
        customer.setId(Long.valueOf(id));
        customer.setName(name);
        customer.setSafer(safer);
        service.update(customer);
        req.setAttribute("message","Customer updated!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        service.deleteById(id);
        req.setAttribute("message","Customer deleted");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req,resp);
    }
}
