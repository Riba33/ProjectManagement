package controller.skill;

import model.Skill;
import service.BaseService;
import service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/find-skill-by-id")
public class FindSkillByIdServlet extends HttpServlet {
    BaseService<Skill, Long> service = ServiceFactory.of(Skill.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/skill/find-skill-by-id.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Optional<Skill> skill = service.findById(id);
        if(!skill.isPresent())
            getServletContext().getRequestDispatcher("/view/not-found.jsp").forward(req,resp);
        else {
            List<Skill> skills = new ArrayList<>();
            skills.add(skill.get());
            req.setAttribute("skills", skills);
            getServletContext().getRequestDispatcher("/view/skill/show-skills.jsp").forward(req, resp);
        }
    }
}
