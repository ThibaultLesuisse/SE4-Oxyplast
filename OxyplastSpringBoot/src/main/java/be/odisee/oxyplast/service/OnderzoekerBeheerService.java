package be.odisee.oxyplast.service;
import java.util.List;

import be.odisee.oxyplast.domain.*;
import utilities.*;
import be.odisee.oxyplast.controller.TeamController;



public interface OnderzoekerBeheerService {
	
	public List<Onderzoeker> geefAlleOnderzoekersTerug(int teamid);

}
