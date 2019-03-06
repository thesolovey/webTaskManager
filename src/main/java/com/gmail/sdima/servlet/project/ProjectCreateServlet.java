package com.gmail.sdima.servlet.project;

import com.gmail.sdima.Bootstrap;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.repository.ProjectRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/projectCreate")
public class ProjectCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/projectCreate.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String projectName = request.getParameter("Project Name");
        final String id = UUID.randomUUID().toString();
        final Project project = new Project(projectName);
        project.setId(id);
        project.setName(projectName);
        final ProjectRepository projectRepository = Bootstrap.projectRepository;
        projectRepository.addProject(project);

        request.setAttribute("project name", projectName);
        doGet(request, response);
    }
}
