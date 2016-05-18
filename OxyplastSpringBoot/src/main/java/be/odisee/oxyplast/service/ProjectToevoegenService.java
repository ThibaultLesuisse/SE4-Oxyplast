package be.odisee.oxyplast.service;

import java.util.Date;
import java.util.List;

import be.odisee.oxyplast.domain.*;
import utilities.*;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:34:49
 */
public interface ProjectToevoegenService {

	public void PrototypeToevoegen(String Formule, int ProjectID);
	public void RendementBerekenen(double Kosten, double Opbrengsten);
	public Project StartProject(int id, int teamId , String status, String naam, Date startdate, Date enddate);
	public void verwijderProject(Project p);
	public void aanpassenProject(Project p);
	public int getAantalKlanten();
	public Klant zoekKlant(String Naam);
	public Boolean getAanvraagAanvaard();
	public int getAantalProjecten();
	public List<Project> geefAlleProjectenTerug();
	public Project zoekProject(int id);
	public Sessie voegSessieToe(int id, String titel);
	public Sessie voegSessieToe(String titel);
    public Sessie zoekSessieMetId(int id);
	public Persoon voegPersoonToe(int id, String voornaam, String familienaam, String emailadres, String paswoord);
	public Persoon voegPersoonToe(String voornaam, String familienaam, String emailadres, String paswoord);
	public Persoon zoekPersoonMetId(int id);
	public Persoon zoekPersoonMetEmailadres(String username);
	public List<Persoon> geefAllePersonen();
	public Rol voegRolToe(String type, int sessieId, int persoonId, String usernaam) throws RolNotFoundException;
	public Rol zoekRolMetId(int id);
	public Rol zoekRolMetUserid(String userid);
	public Prototype voegPrototypeToe(int prototypeId, int sessieId, int OnderzoekerId, String formule);
	public Prototype voegPrototypeToe(int sessieId, int OnderzoekerId, String formule);
	public Prototype zoekPrototypeMetId(int id);
	public List<Aanvraag> geefAlleAanvragenTerug();
	public Aanvraag voegAanvraagToe (int id, int AanvraagId, Klant klant, String type, String aanvraag);
	public Aanvraag voegAanvraagToe( int AanvraagId, Klant klant, String type, String aanvraag);
	    public Aanvraag zoekAanvraagMetId(int id);
	    public void verwijderAanvraag(Aanvraag aanvraag);
	    public void updateAanvraag(Aanvraag aanvraag);
	    public void toonSessieResultaten(Sessie sessie);
	}
	

