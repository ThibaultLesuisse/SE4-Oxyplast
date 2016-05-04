package be.odisee.oxyplast.dao;
import be.odisee.oxyplast.domain.Team;
import java.util.List;
public interface TeamDao {



	    public Team saveTeam(int id, String naam);
	    public Team getTeamById(int id);
	    public List<Team> getAllTeams();
	    public void updateTeam(Team t);    
	    public void deleteTeam(Team t);
}
