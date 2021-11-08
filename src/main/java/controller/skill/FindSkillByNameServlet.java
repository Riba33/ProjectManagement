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
import java.util.List;

@WebServlet("/find-skills-by-name")
public class FindSkillByNameServlet extends HttpServlet {
    BaseService<Skill, Long> service = ServiceFactory.of(Skill.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/skill/find-skills-by-name.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Skill> skills = service.findByName(name);
        if(skills.isEmpty())
            getServletContext().getRequestDispatcher("/view/not-found.jsp").forward(req,resp);
        else {
            req.setAttribute("skills", skills);
            getServletContext().getRequestDispatcher("/view/skill/show-skills.jsp").forward(req, resp);
        }
    }
}
