package be.odisee.oxyplast.dao;

import java.util.List;

import be.odisee.oxyplast.domain.Aanvraag;
import be.odisee.oxyplast.domain.Project;

public class AanvraagHibernateDao extends HibernateDao implements AanvraagDao {


	@Override
	public Aanvraag saveAanvraag(int id, int klantid, String aanvraag) {
		Aanvraag a = new Aanvraag(id , klantid , aanvraag);
		sessionSaveObject(a);
		return a;
	}

	@Override
	public Aanvraag getAanvraagById(int id) {
		// TODO Auto-generated method stub
		return (Aanvraag) sessionGetObjectById("Aanvraag", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aanvraag> getAllAanvragen() {
		// TODO Auto-generated method stub
		return (List<Aanvraag>) sessionGetAllObjects("Aanvraag");
	}

	@Override
	public void updateAanvraag(Aanvraag Aanvraag) {
		sessionUpdateObject(Aanvraag);
		System.out.println("DEBUG DAO update + naam: "+Aanvraag.getAanvraag());
		
	}

	@Override
	public void deleteAanvraag(Aanvraag Aanvraag) {
		sessionDeleteObject(Aanvraag);
	}

}
