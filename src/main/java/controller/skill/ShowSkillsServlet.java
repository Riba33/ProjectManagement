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

@WebServlet("/show-skills")
public class ShowSkillsServlet extends HttpServlet {
    private BaseService<Skill, Long> service = ServiceFactory.of(Skill.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Skill> all = service.findALL();
        req.setAttribute("skills",all);
        getServletContext().getRequestDispatcher("/view/skill/show-skills.jsp").forward(req,resp);
    }
}
