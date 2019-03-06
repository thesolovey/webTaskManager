package com.gmail.sdima;

import com.gmail.sdima.repository.ProjectRepository;
import com.gmail.sdima.repository.TaskRepositoty;

public class Bootstrap {

    public static ProjectRepository projectRepository = new ProjectRepository();

    public static TaskRepositoty taskRepositoty = new TaskRepositoty();

}
