package com.gmail.sdima.servlet.project;

import com.gmail.sdima.Bootstrap;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Task;
import com.gmail.sdima.repository.ProjectRepository;
import com.gmail.sdima.repository.TaskRepositoty;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/projectList")
public class ProjectListServlet extends HttpServlet {

    private final ProjectRepository projectRepository = Bootstrap.projectRepository;
    private final TaskRepositoty taskRepositoty = Bootstrap.taskRepositoty;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final List<Project> projectList = projectRepository.getProjectList();
        request.setAttribute("PROJECTLIST", projectList);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/projectList.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String projectId = request.getParameter("projectId");
        if (projectId == null) return;
        List<Task> listForJsp = new ArrayList<>();
        Project projects = null;
        final List<Task> taskList = taskRepositoty.getTaskList();
        for (Task task: taskList)
            if (task.getProjectId().equals(projectId)){
                listForJsp.add(task);
            }

        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList)
            if (project.getId().equals(projectId)) {
                projects = project;
            }
        request.getSession().setAttribute("projects", projects);
        request.getSession().setAttribute("tasks", listForJsp);
        response.sendRedirect("projectOpen");
    }
}
