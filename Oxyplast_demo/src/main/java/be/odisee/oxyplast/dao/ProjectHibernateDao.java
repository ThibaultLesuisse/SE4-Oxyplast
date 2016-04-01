package be.odisee.oxyplast.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import be.odisee.oxyplast.domain.Project;

@Repository("projectDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class ProjectHibernateDao extends HibernateDao implements ProjectDao {

	//@Override
	public Project saveProject(int id, int teamId , String status, String naam) {
		// TODO Auto-generated method stub
		Project project = new Project(id , teamId , status, naam);
		sessionSaveObject(project);
		return project;
	}

	//@Override
	public Project getProjectById(int projectId) {
		// TODO Auto-generated method stub
		return (Project) sessionGetObjectById("Project", projectId);
	}
	
	
	//@Override
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		
		return (List<Project>) sessionGetAllObjects("Project");
	}

	//@Override
	public void updateProject(Project project) {
		sessionUpdateObject(project);
	}

    
}
