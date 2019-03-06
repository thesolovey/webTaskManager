package com.gmail.sdima.repository;

import com.gmail.sdima.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoty {

    private List<Task> taskList = new ArrayList<>();

    public void addtask(Task task) { taskList.add(task); }

    public List<Task> getTaskList () { return taskList; }

    public void deleteTask(Task task) { taskList.remove(task); }
}
