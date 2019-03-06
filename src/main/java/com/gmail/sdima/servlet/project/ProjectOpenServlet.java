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
import java.util.List;

@WebServlet("/projectOpen")
public class ProjectOpenServlet extends HttpServlet {

    private final ProjectRepository projectRepository = Bootstrap.projectRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/projectOpen.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String projectId = request.getParameter("projectId");
        Project projects = null;

        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project: projectList)
            if (project.getId().equals(projectId)) {
                projects = project;
            }
        request.getSession().setAttribute("projects", projects);
        response.sendRedirect("projectDelete");
    }
}
