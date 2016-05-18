package be.odisee.oxyplast.service;
import java.util.List;

import be.odisee.oxyplast.domain.*;



public interface OnderzoekerBeheerService {
	
	public List<Onderzoeker> geefAlleOnderzoekersTerug(int teamid);
	public List<Onderzoeker> geefAlleOnderzoekersTerugZonderId();

}
