package be.odisee.oxyplast.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import be.odisee.oxyplast.domain.Onderzoeker;

@Repository("onderzoekerDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class OnderzoekerHibernateDao extends HibernateDao implements OnderzoekerDao {
	@Override
	public Onderzoeker saveOnderzoeker(int id,  String naam, String voornaam, int teamid) {
		Onderzoeker o = new Onderzoeker(id,naam, voornaam, teamid);
		sessionSaveObject(o);
		return o;
	}

	@Override
	public Onderzoeker getOnderzoekerById(int id) {
		return (Onderzoeker) sessionGetObjectById("Onderzoeker", id);
	}

	@SuppressWarnings("unchecked")
	public List<Onderzoeker> getAllOnderzoekers(int id) {
		return (List<Onderzoeker>) sessionGetAllObjectsById("Onderzoeker", "id", id);
	}

	@Override
	public void updateOnderzoeker(Onderzoeker o) {
		sessionUpdateObject(o);
		System.out.println("DEBUG DAO update + naam:" + o.getNaam());
		
	}

	@Override
	public void deleteOnderzoeker(Onderzoeker o) {
		sessionDeleteObject(o);
		
	}

}