package be.odisee.oxyplast.service;

import java.util.List;

import be.odisee.oxyplast.domain.*;
import be.odisee.oxyplast.controller.ProjectController;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:34:49
 */
public interface ProjectToevoegenService {

	/**
	 * 
	 * @param Aanvraag
	 */
	public Aanvraag AanvraagIndienen(String Aanvraag);

	/**
	 * 
	 * @param Formule
	 */
	public void BepaalFormule(String Formule);

	/**
	 * 
	 * @param feedback
	 */
	public void FeedbackToevoegen(String feedback);

	/**
	 * 
	 * @param Achternaam
	 * @param Bedrijfsnaam
	 * @param Email
	 * @param Voornaam
	 * @return 
	 */
	public Klant KlantToevoegen(String Achternaam, String Bedrijfsnaam, String Email, String Voornaam);

	/**
	 * 
	 * @param Formule
	 * @param ProjectID
	 */
	public void PrototypeToevoegen(String Formule, int ProjectID);

	/**
	 * 
	 * @param Kosten
	 * @param Opbrengsten
	 */
	public void RendementBerekenen(double Kosten, double Opbrengsten);

	/**
	 * 
	 * @param Team
	 * @param Status
	 * @param Naam
	 */
	public Project StartProject(int id, int teamId , String status, String naam);
	public boolean verwijderProject(Project p);
	public void aanpassenProject(Project p);
	
	public int getAantalKlanten();
	
	public Klant zoekKlant(String Naam);
	
	public Boolean getAanvraagAanvaard();
	
	public int getAantalProjecten();
	
	public List<Project> geefAlleProjectenTerug();
	
	public Project zoekProject(int id);
	}
	

