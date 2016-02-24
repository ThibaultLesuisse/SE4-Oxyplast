package BE.Odisee.Oxyplast.Service;

import BE.Odisee.Oxyplast.Domain.*;

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
	public Project StartProject(int Team, String Status, String Naam);
	
	public int getAantalKlanten();
	
	public Klant zoekKlant(String Naam);
	
	public Boolean getAanvraagAanvaard();
	
	public int getAantalProjecten();
	
	public Project zoekProject(String naam);
	}

