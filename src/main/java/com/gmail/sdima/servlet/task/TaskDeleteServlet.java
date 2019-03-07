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
import java.util.List;

@WebServlet("/taskDelete")
public class TaskDeleteServlet extends HttpServlet {

    private final TaskRepositoty taskRepositoty = Bootstrap.taskRepositoty;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/taskDelete.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String taskId = request.getParameter("taskId");

            final List<Task> taskList = taskRepositoty.getTaskList();
            for (Task task : taskList) {
                if (task.getId().equals(taskId)) {
                    taskRepositoty.deleteTask(task);
                    break;
                }
            }
            response.sendRedirect("taskList");

    }
}
