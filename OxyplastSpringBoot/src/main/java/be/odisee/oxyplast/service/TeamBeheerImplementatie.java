package be.odisee.oxyplast.service;
import java.util.List;
import be.odisee.oxyplast.dao.TeamDao;
import be.odisee.oxyplast.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("TeamBeheerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class TeamBeheerImplementatie implements TeamBeheerService{

	public Onderzoeker onderzoeker;
	
private TeamDao TeamDao;
	
	@Autowired
    public void setTeamDao(TeamDao teamDao) {
        this.TeamDao = teamDao;
    }

	@Override
	public List<Team> geefAlleTeamsTerug() {
		// TODO Auto-generated method stub
		return TeamDao.getAllTeams();
	}

	@Override
	public void OnderzoekerToevoegen(String naam, String voornaam, int teamid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Team StartTeam(int id, String naam) {
		// TODO Auto-generated method stub
		return this.TeamDao.saveTeam(id, naam);
	}

	@Override
	public void verwijderTeam(Team t) {
		// TODO Auto-generated method stub
		System.out.println("DEBUG TJS: "+t.getNaam());
		this.TeamDao.deleteTeam(t);
	}

	@Override
	public void aanpassenTeam(Team t) {
		// TODO Auto-generated method stub
		this.TeamDao.updateTeam(t);
	}

	@Override
	public Onderzoeker voegOnderzoekerToe(int id, int sessieId, int teamId, String naam, String voornaam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Onderzoeker voegOnderzoekerToe(int sessieId, int teamId, String naam, String voornaam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Onderzoeker zoekOnderzoekerMetId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team zoekTeam(int id) {
		// TODO Auto-generated method stub
		System.out.println("DEBUG TJS (zoek): "+TeamDao.getTeamById(id));
		return TeamDao.getTeamById(id);
	}
}
