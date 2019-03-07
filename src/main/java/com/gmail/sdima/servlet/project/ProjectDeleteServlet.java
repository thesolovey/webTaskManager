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
import java.util.Iterator;
import java.util.List;

@WebServlet("/projectDelete")
public class ProjectDeleteServlet extends HttpServlet {

    private final ProjectRepository projectRepository = Bootstrap.projectRepository;
    private final TaskRepositoty taskRepositoty = Bootstrap.taskRepositoty;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/projectDelete.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String projectId = request.getParameter("projectId");

        List<Task> taskList = taskRepositoty.getTaskList();

        Iterator<Task> it = taskList.iterator();
        while(it.hasNext()){
            Task task = it.next();
            if(task.getProjectId().equals(projectId))
                it.remove();
        }

        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList)
            if (project.getId().equals(projectId)) {
                projectRepository.deleteProject(project);
                break;
            }
            response.sendRedirect("projectList");
        }
    }
