package be.odisee.oxyplast.dao;

import be.odisee.oxyplast.domain.*;
import java.util.List;

public interface ProjectDao {

    public Project saveProject(String TeamID, String Status, String naam);

    public Project getProjectById(int projectId);

    public List<Project> getAllProjects();

    public void updateProject(Project project);

}
