package be.odisee.oxyplast.dao;

import java.util.List;

import be.odisee.oxyplast.domain.Partner;

public interface PartnerDao {
	
	public Partner savePartner(int id, String naam, String voornaam);
	public Partner getPartnerById(int id);
	public List<Partner> getAllPartners();
	public void updatePartner(Partner p);
	public void deletePartner(Partner p);

}
