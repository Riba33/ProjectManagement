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
import java.util.NoSuchElementException;

@WebServlet("/create-skill")
public class CreateSkillServlet extends HttpServlet {
    BaseService<Skill, Long> service = ServiceFactory.of(Skill.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/skill/create-skill.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name = req.getParameter("name");
        final String level = req.getParameter("level");
        final Skill skill= Skill.builder()
                .name(name)
                .level(level)
                .build();
       service.save(skill);
       getServletContext().getRequestDispatcher("/view/create-ok.jsp").forward(req, resp);
    }
}
