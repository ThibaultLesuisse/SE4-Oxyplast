package be.odisee.oxyplast.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.oxyplast.domain.Aanvraag;
import be.odisee.oxyplast.domain.Bestelling;
import be.odisee.oxyplast.domain.Leverancier;
import be.odisee.oxyplast.domain.Project;
import be.odisee.oxyplast.domain.Prototype;;

@Repository("bestellingDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class BestellingHibernateDao extends HibernateDao implements BestellingDao{
	
	
	public Bestelling saveBestelling(int id, int aantal, Leverancier l, Project p, Prototype pr) {
		Bestelling b = new Bestelling(id, aantal, l, p, pr);
		sessionSaveObject(b);
		return b;
		
	}

	@Override
	public Bestelling getBestellingById(int projectId) {
		// TODO Auto-generated method stub
		return (Bestelling) sessionGetObjectById("Aanvraag", projectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bestelling> getAllBestellingen() {
		return (List<Bestelling>) sessionGetAllObjects("Bestelling");
	}

	@Override
	public void updateBestelling(Bestelling bestelling) {
		sessionUpdateObject(bestelling);
		System.out.println("DEBUG DAO update + naam: "+bestelling.getId());
		
	}

	@Override
	public void deleteBestelling(Bestelling bestelling) {
		sessionDeleteObject(bestelling);
		
	}



}
