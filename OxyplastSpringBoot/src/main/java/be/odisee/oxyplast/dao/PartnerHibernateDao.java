package be.odisee.oxyplast.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.oxyplast.domain.Partner;

@Repository("PartnerDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class PartnerHibernateDao extends HibernateDao implements PartnerDao {

	@Override
	public Partner savePartner(int id, String naam, String voornaam) {
		Partner p = new Partner(id, naam, voornaam);
		sessionSaveObject(p);
		return p;
	}

	@Override
	public Partner getPartnerById(int id) {
		return (Partner) sessionGetObjectById("Partner", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partner> getAllPartners() {
		return (List<Partner>) sessionGetAllObjects("Partner");
	}

	@Override
	public void updatePartner(Partner p) {
		sessionUpdateObject(p);
		System.out.println("DEBUG DAO update + partner:" + p.getNaam() + p.getVoornaam());
	}

	@Override
	public void deletePartner(Partner p) {
		sessionDeleteObject(p);
	}

}
