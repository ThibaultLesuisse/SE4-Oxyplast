package be.odisee.oxyplast.service;
import java.util.ArrayList;
import java.util.List;
import be.odisee.oxyplast.dao.TeamDao;
import be.odisee.oxyplast.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("TeamBeheerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class TeamBeheerImplementatie implements TeamBeheerService{

private TeamDao TeamDao;
	
	@Autowired
    public void setTeamDao(TeamDao teamDao) {
        this.TeamDao = teamDao;
    }

	@Override
	public List<Team> geefAlleTeamsTerug() {
		// TODO Auto-generated method stub
		return null;
	}
}
