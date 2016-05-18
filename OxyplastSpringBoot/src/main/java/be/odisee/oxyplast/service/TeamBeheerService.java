package be.odisee.oxyplast.service;
import java.util.List;

import be.odisee.oxyplast.domain.*;

public interface TeamBeheerService {
	
	public List<Team> geefAlleTeamsTerug();
	public void OnderzoekerToevoegen(String naam, String voornaam, int teamid);
	
	public Team StartTeam(int id, String naam);
	public void verwijderTeam(Team t);
	public void aanpassenTeam(Team t);
	
	public Onderzoeker voegOnderzoekerToe(int id, int sessieId, int teamId, String naam, String voornaam);
	public Onderzoeker voegOnderzoekerToe(int sessieId, int teamId, String naam, String voornaam);
	public Onderzoeker zoekOnderzoekerMetId(int id);
	
	public Team zoekTeam(int id);
}
