package be.odisee.oxyplast.dao;
import be.odisee.oxyplast.domain.Team;
import java.util.List;
public interface TeamDao {



	    public Team saveTeam(int teamid ,int projectid, String omschrijving, Boolean actief);
	    public Team getTeamById(int teamid);
	    public List<Team> getAllTeams(int teamid);
	    public void updateTeam(Team t);    
	    public void deleteTeam(Team t);
}
