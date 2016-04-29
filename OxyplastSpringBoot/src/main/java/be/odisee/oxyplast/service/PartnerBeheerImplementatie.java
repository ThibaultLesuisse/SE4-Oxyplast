package be.odisee.oxyplast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.oxyplast.dao.FeedbackDao;
import be.odisee.oxyplast.dao.PartnerDao;
import be.odisee.oxyplast.domain.Partner;

@Service("PartnerBeheerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class PartnerBeheerImplementatie implements PartnerBeheerService {
	
	private PartnerDao partnerDao;
	
	@Autowired
    public void setPartnerDao(PartnerDao partnerDao) {
        this.partnerDao = partnerDao;
    }

	@Override
	public Partner CreatePartner(int id, String naam, String voornaam) {
		return this.partnerDao.savePartner(id, naam, voornaam);
	}

	@Override
	public Partner getPartnerById(int id) {
		System.out.println("DEBUG PTS (zoek): "+ this.partnerDao.getPartnerById(id));
		return this.partnerDao.getPartnerById(id);
	}

	@Override
	// geef lijst van alle partners terug
	public List<Partner> geefAllePartnersTerug() {
		List<Partner> Partnerlist = this.partnerDao.getAllPartners();
		System.out.println(Partnerlist.get(0).getId());
		return Partnerlist;
	}

	@Override
	public void updatePartner(Partner p) {
		System.out.println("DEBUG PTS (update): " + p.getNaam() + p.getVoornaam());
		this.partnerDao.updatePartner(p);
	}

	@Override
	public void deletePartner(Partner p) {
		System.out.println("DEBUG FBS (delete): " + p.getNaam() + p.getVoornaam());
		this.partnerDao.deletePartner(p);
	}

}
