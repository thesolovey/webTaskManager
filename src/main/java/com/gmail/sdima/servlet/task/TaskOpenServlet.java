package com.gmail.sdima.servlet.task;

import com.gmail.sdima.Bootstrap;
import com.gmail.sdima.entity.Task;
import com.gmail.sdima.repository.TaskRepositoty;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/taskOpen")
public class TaskOpenServlet extends HttpServlet {

    private final TaskRepositoty taskRepositoty = Bootstrap.taskRepositoty;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/taskOpen.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String taskId = request.getParameter("taskId");
        Task tasks = null;

        final List<Task> taskList = taskRepositoty.getTaskList();
        for (Task task: taskList)
            if (task.getId().equals(taskId)) {
                tasks = task;
            }
        request.getSession().setAttribute("task", tasks);
        response.sendRedirect("taskDelete");
    }
}
