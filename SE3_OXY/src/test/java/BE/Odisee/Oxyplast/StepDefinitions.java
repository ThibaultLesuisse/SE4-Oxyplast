package BE.Odisee.Oxyplast;

import cucumber.api.java.nl.Gegeven;
import cucumber.api.PendingException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;

import BE.Odisee.Oxyplast.Domain.*;
import BE.Odisee.Oxyplast.Service.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



@SuppressWarnings("unused")
public class StepDefinitions {
	
	ProjectToevoegenService service;
	
	
	
	@Als("^de klant wordt toegevoegd$")
	public void de_klant_wordt_toegevoegd() throws Throwable {
		service = new ProjectBeheerImplementatieService();
		Klant klant = service.KlantToevoegen("Dubai", "DubaiGroup", "Dubai.com", "SEIK");
	    assertNotNull("Klant is niet toegevoegd", klant);
	}

	@Dan("^is de lijst van klanten (\\d+) groot.$")
	public void is_de_lijst_van_klanten_groot(int aantal) throws Throwable {
	   
	    assertEquals("", aantal, service.getAantalKlanten());
	}

	@Dan("^zou de klant \"([^\"]*)\" in de lijst moeten voorkomen$")
	public void zou_de_klant_in_de_lijst_moeten_voorkomen(String naamKlant) throws Throwable {

	    assertNotNull(service.zoekKlant(naamKlant));
	    
	}

	@Als("^de aanvraag wordt aangemaakt$")
	public void de_aanvraag_wordt_aangemaakt() throws Throwable {
		service = new ProjectBeheerImplementatieService();
	    Aanvraag aanvraag = service.AanvraagIndienen("Speciale verf voor stadium in Dubai");
	    assertNotNull("Aanvraag is niet gelukt", aanvraag);
	}

	@Dan("^moet de Boolean aanvaard op true staan$")
	public void moet_de_Boolean_aanvaard_op_true_staan() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		
		assertEquals("Nog niet aanvaard", true, service.getAanvraagAanvaard());
	}

	@Als("^het project wordt toegevoegd$")
	public void het_project_wordt_toegevoegd() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		service = new ProjectBeheerImplementatieService();
	    Project project = service.StartProject(1, "Gestart", "DubaiVerf");
	    assertNotNull("Geen Project aangemaakt", project);
	}

	@Dan("^is de lijst van projecten (\\d+) groot$")
	public void is_de_lijst_van_projecten_groot(int aantal) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		assertEquals("Niets in de lijst", aantal, service.getAantalProjecten());
	}

	@Dan("^zou het project \"([^\"]*)\" van de klant in de lijst moeten voorkomen$")
	public void zou_het_project_van_de_klant_in_de_lijst_moeten_voorkomen(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
	}
}
