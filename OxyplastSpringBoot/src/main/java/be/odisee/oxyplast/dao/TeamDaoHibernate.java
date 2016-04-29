package be.odisee.oxyplast.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import be.odisee.oxyplast.domain.Team;
import be.odisee.oxyplast.domain.Project;
import be.odisee.oxyplast.domain.Prototype;


@Repository("prototypeDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class TeamDaoHibernate extends HibernateDao implements TeamDao{

	@Override
	public Team saveTeam(int teamid, int projectid, String omschrijving, Boolean actief) {
		Team t = new Team(teamid ,projectid, omschrijving, actief );
		sessionSaveObject(t);
		return t;
	}
	public Team getTeamById(int teamid) {
		return (Team) sessionGetObjectById("Team", teamid);
	}

	@SuppressWarnings("unchecked")

	public List<Team> getAllTeams(int teamid) {
		return (List<Team>) sessionGetAllObjects("Team");
	}
	public void updateTeam(Team t) {
		sessionUpdateObject(t);
	}
	public void deleteTeam(Team t) {
		sessionDeleteObject(t);
	}

}
