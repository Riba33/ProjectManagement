package controller;

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

@WebServlet("/skill/*")
public class SkillServlet extends HttpServlet {
    BaseService<Skill, Long> service = ServiceFactory.of(Skill.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] command = req.getPathInfo().split("/");
        switch (command[1]){

            case "show-skill":
                List<Skill> all = service.findALL();
                req.setAttribute("skills",all);
                getServletContext().getRequestDispatcher("/view/skill/show-skills.jsp").forward(req,resp);
                break;

            case "find-skill-by-id":
                Long id = Long.valueOf(req.getParameter("id"));
                Optional<Skill> optionalSkill = service.findById(id);
                if(optionalSkill.isEmpty()) {
                    req.setAttribute("message","Skill not found!");
                    getServletContext().getRequestDispatcher("/view/message.jsp").forward(req, resp);
                }
                else {
                    Skill skill = optionalSkill.get();
                    req.setAttribute("skill", skill);
                    getServletContext().getRequestDispatcher("/view/skill/show-skill.jsp").forward(req, resp);
                }
                break;

            case "find-skill-by-name":
                String name = req.getParameter("name");
                List<Skill> skills = service.findByName(name);
                if(skills.isEmpty()) {
                    req.setAttribute("message","Skill not found!");
                    getServletContext().getRequestDispatcher("/view/message.jsp").forward(req, resp);
                }
                else {
                    req.setAttribute("skills", skills);
                    getServletContext().getRequestDispatcher("/view/skill/show-skills.jsp").forward(req, resp);
                }
                break;

            case "update-skill":
                doPut(req,resp);
                break;

            case "delete-skill":
                doDelete(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String level = req.getParameter("level");
        final Skill skill= Skill.builder()
                .name(name)
                .level(level)
                .build();
        service.create(skill);
        req.setAttribute("message","Skill created!!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String level = req.getParameter("level");
        final Long id = Long.valueOf(req.getParameter("id"));
        final Skill skill= Skill.builder()
                .id(id)
                .name(name)
                .level(level)
                .build();
        service.update(skill);
        req.setAttribute("message","Skill updated!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        service.deleteById(id);
        req.setAttribute("message","Skill deleted!");
        getServletContext().getRequestDispatcher("/view/message.jsp").forward(req, resp);
    }
}
