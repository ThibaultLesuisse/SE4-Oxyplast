package be.odisee.oxyplast.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import be.odisee.oxyplast.domain.Team;


@Repository("TeamDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class TeamDaoHibernate extends HibernateDao implements TeamDao{

	@Override
	public Team saveTeam(int id, String naam) {
		Team t = new Team(id, naam);
		sessionSaveObject(t);
		return t;
	}
	public Team getTeamById(int id) {
		return (Team) sessionGetObjectById("Team", id);
	}

	@SuppressWarnings("unchecked")

	public List<Team> getAllTeams() {
		return (List<Team>) sessionGetAllObjects("Team");
	}
	public void updateTeam(Team t) {
		sessionUpdateObject(t);
	}
	public void deleteTeam(Team t) {
		sessionDeleteObject(t);
	}

}
