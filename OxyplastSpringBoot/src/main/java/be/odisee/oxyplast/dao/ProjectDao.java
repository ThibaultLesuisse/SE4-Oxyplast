package be.odisee.oxyplast.dao;

import be.odisee.oxyplast.domain.*;

import java.util.Date;
import java.util.List;

public interface ProjectDao {

    public Project saveProject(int id ,int teamId, String status, String naam, Date startdate, Date enddate);
    public Project getProjectById(int projectId);
    public List<Project> getAllProjects();
    public void updateProject(Project project);    
    public void deleteProject(Project project);

    
    

}
