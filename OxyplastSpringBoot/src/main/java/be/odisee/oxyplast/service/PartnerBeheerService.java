package be.odisee.oxyplast.service;

import java.util.List;

import be.odisee.oxyplast.domain.Partner;

public interface PartnerBeheerService {
	
	public Partner CreatePartner(int id, String naam, String voornaam);
	public Partner getPartnerById(int id);
	public List<Partner> geefAllePartnersTerug();
	public void updatePartner(Partner p);
	public void deletePartner(Partner p);
}
