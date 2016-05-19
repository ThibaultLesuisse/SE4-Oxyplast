package be.odisee.oxyplast.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.oxyplast.domain.Aanvraag;
import be.odisee.oxyplast.domain.Klant;

@Repository("AanvraagDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class AanvraagHibernateDao extends HibernateDao implements AanvraagDao {


	@Override
	public Aanvraag saveAanvraag(int id, Klant klant, String aanvraag) {
		Aanvraag a = new Aanvraag(id , klant , aanvraag);
		sessionSaveObject(a);
		return a;
	}

	@Override
	public Aanvraag getAanvraagById(int id) {
		return (Aanvraag) sessionGetObjectById("Aanvraag", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aanvraag> getAllAanvragen() {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Aanvraag> getAlleAanvaardeAanvragen() {
		// TODO Auto-generated method stub
		return sessionGetAllObjectsById("Aanvraag", "aanvraagaanvaard", 0);
	}

}
