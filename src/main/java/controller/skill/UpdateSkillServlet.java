package controller.skill;

import model.Skill;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-skill")
public class UpdateSkillServlet extends HttpServlet {
    BaseService<Skill, Long> service = ServiceFactory.of(Skill.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/skill/update-skill.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name = req.getParameter("name");
        final String level = req.getParameter("level");
        final Long id = Long.valueOf(req.getParameter("id"));
        final Skill skill= Skill.builder()
                .id(id)
                .name(name)
                .level(level)
                .build();
                service.save(skill);
        getServletContext().getRequestDispatcher("/update-ok.jsp").forward(req,resp);
    }
}
