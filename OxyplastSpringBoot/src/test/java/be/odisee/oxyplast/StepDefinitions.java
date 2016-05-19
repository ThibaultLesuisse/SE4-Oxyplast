package be.odisee.oxyplast;

import java.util.ArrayList;
import java.util.List;

import be.odisee.oxyplast.domain.Aanvraag;
import be.odisee.oxyplast.domain.Klant;
import be.odisee.oxyplast.domain.Project;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.Gegeven;

public class StepDefinitions {
	
	public Klant k1;
	public Klant k2;
	public Klant k3;
	public List<Klant> klantenlijst = new ArrayList<Klant>();
	public Aanvraag a1;
	public Aanvraag a2;
	public Aanvraag a3;
	public List<Aanvraag> aanvraagLijst = new ArrayList<Aanvraag>();
	public Project p1;
	public Project p2;
	public Project p3;
	public List<Project> projectenLijst = new ArrayList<Project>();
	
	
	@Gegeven("^\"(.*?)\" is een eerste klant met id=(\\d+)$")
	public void is_een_eerste_klant_met_id(String naam, int id) throws Throwable {
	    k1 = new Klant(id, naam);
	    klantenlijst.add(k1);
	}
	
	@Gegeven("^\"(.*?)\" heeft een eerste aanvraag ingediend met naam=\"(.*?)\"$")
	public void heeft_een_eerste_aanvraag_ingediend_met_naam(String naam, String naamAanvraag) throws Throwable {
	    for (Klant k : klantenlijst){
	    	if (k.getVoornaam() == naam){
	    		a1 = new Aanvraag(1, k, naamAanvraag);
	    		aanvraagLijst.add(a1);
	    	}
	    }
	}

	@Gegeven("^\"(.*?)\" is een tweede klant met id=(\\d+)$")
	public void is_een_tweede_klant_met_id(String naam, int id) throws Throwable {
		k2 = new Klant(id, naam);
		klantenlijst.add(k2);
	}
	
	@Gegeven("^\"(.*?)\" heeft een tweede aanvraag ingediend met naam=\"(.*?)\"$")
	public void heeft_een_tweede_aanvraag_ingediend_met_naam(String naam, String naamAanvraag) throws Throwable {
		for (Klant k : klantenlijst){
	    	if (k.getVoornaam() == naam){
	    		a2 = new Aanvraag(2, k, naamAanvraag);
	    		aanvraagLijst.add(a2);
	    	}
	    }
	}

	@Gegeven("^\"(.*?)\" is een derde klant met id=(\\d+)$")
	public void is_een_derde_klant_met_id(String naam, int id) throws Throwable {
		k3 = new Klant(id, naam);
		klantenlijst.add(k3);
	}
	
	@Gegeven("^\"(.*?)\" heeft een derde aanvraag ingediend met naam=\"(.*?)\"$")
	public void heeft_een_derde_aanvraag_ingediend_met_naam(String naam, String naamAanvraag) throws Throwable {
		for (Klant k : klantenlijst){
	    	if (k.getVoornaam() == naam){
	    		a3 = new Aanvraag(3, k, naamAanvraag);
	    		aanvraagLijst.add(a3);
	    	}
	    }
	}

	@Gegeven("^er is een project opgestart met de naam \"(.*?)\"$")
	public void er_is_een_project_opgestart_met_de_naam(String naam) throws Throwable {
	    p3 = new Project(naam);
	    projectenLijst.add(p3);
	}

	@Als("^De accountverantwoordelijke de aanvraag van \"(.*?)\" heeft bekeken en deze aanvaard$")
	public void de_accountverantwoordelijke_de_aanvraag_van_heeft_bekeken_en_deze_aanvaard(String naam) throws Throwable {
		Klant x = k1;
		String s = x.getVoornaam()+x.getId();
		p1 = new Project(s);
	}

	@Dan("^Moet er een project worden gestart waarvan de naam=\"(.*?)\" is en de status=\"(.*?)\"$")
	public boolean moet_er_een_project_worden_gestart_waarvan_de_naam_is_en_de_status(String naam, String status) throws Throwable {
		for (Project p : projectenLijst){
	    	if ((p.getNaam() == naam) && (p.getStatus() == status)){
	    		return true;
	    	}
	    }
		return false;
	}

	@Als("^De accountverantwoordelijke de aanvraag van \"(.*?)\" heeft bekeken en deze afwijst$")
	public void de_accountverantwoordelijke_de_aanvraag_van_heeft_bekeken_en_deze_afwijst(String naam) throws Throwable {
	}

	@Dan("^mag er geen project worden gestart waarvan de naam=\"(.*?)\" is en de status=\"(.*?)\"$")
	public boolean mag_er_geen_project_worden_gestart_waarvan_de_naam_is_en_de_status(String naam, String status) throws Throwable {
		for (Project p : projectenLijst){
	    	if ((p.getNaam() == naam) && (p.getStatus() == status)){
	    		return false;
	    	}
	    }
		return true;
	}

	@Dan("^Mag er geen tweede project worden gestart met naam=\"(.*?)\" en de status=\"(.*?)\"$")
	public boolean mag_er_geen_tweede_project_worden_gestart_met_naam_en_de_status(String naam, String status) throws Throwable {
		byte x = 0;
		for (Project p : projectenLijst){
	    	if ((p.getNaam() == naam) && (p.getStatus() == status)){
	    		x++;
	    	}
	    }
		if (x>=2){
			return false;
		} else{
			return true;
		}
	}
}
