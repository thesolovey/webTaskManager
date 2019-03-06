package com.gmail.sdima.repository;

import com.gmail.sdima.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    private List<Project> projectList = new ArrayList<>();

    public List<Project> getProjectList() { return projectList; }

    public void addProject(Project project) { projectList.add(project); }

    public void deleteProject(Project project) { projectList.remove(project); }
}
