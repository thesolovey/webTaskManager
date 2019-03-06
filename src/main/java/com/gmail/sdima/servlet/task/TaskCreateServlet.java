package com.gmail.sdima.servlet.task;

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
import java.util.UUID;

@WebServlet("/taskCreate")
public class TaskCreateServlet extends HttpServlet {

    private TaskRepositoty taskRepositoty = Bootstrap.taskRepositoty;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/taskCreate.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String taskName = request.getParameter("Task Name");
        final String id = UUID.randomUUID().toString();
        final String description = request.getParameter("Task Description");
        final String projectId = request.getParameter("Project ID");
        final Task task = new Task();
        task.setId(id);
        task.setTaskName(taskName);
        task.setDescription(description);
        task.setProjectId(projectId);
        taskRepositoty.addtask(task);

        request.setAttribute("task name", taskName);
        doGet(request, response);
    }
}
