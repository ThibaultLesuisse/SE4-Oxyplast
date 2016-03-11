package be.odisee.oxyplast.service;

import java.util.ArrayList;
import java.util.List;

import be.odisee.oxyplast.dao.ProjectDao;
import be.odisee.oxyplast.dao.ProjectHibernateDao;
import be.odisee.oxyplast.domain.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("ProjectToevoegenService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)

/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:34:39
 */
public class ProjectBeheerImplementatieService implements ProjectToevoegenService {
	public Klant klant;
	public Aanvraag aanvraag;
	public Project project;
	public Accountverantwoordelijke accountverantwoordelijke;
	public Feedback feedback;
	public Grondstof grondstof;
	public Kost kost;
	public Leverancier leverancier;
	public Onderzoeker onderzoeker;
	public Opbrengst opbrengst;
	public Team team;
	public Prototype prototype;
	public Werknemer werknemer;
	
	private ProjectDao projectDao;
	
	public ArrayList<Klant> klanten = new ArrayList<Klant>();
	public ArrayList<Project> projecten = new ArrayList<Project>();
	public ProjectBeheerImplementatieService(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param Aanvraag
	 */
	public Aanvraag AanvraagIndienen(String Aanvraag){
			aanvraag = new Aanvraag(Aanvraag, 1);	
			return aanvraag;
	}

	/**
	 * 
	 * @param Formule
	 */
	public void BepaalFormule(String Formule){

	}

	/**
	 * 
	 * @param feedback
	 */
	public void FeedbackToevoegen(String feedback){

	}

	/**
	 * 
	 * @param Achternaam
	 * @param Bedrijfsnaam
	 * @param Email
	 * @param Voornaam
	 */
	public Klant KlantToevoegen(String Achternaam, String Bedrijfsnaam, String Email, String Voornaam){
			klant = new Klant(Achternaam, Bedrijfsnaam, Email, Voornaam);
			klanten.add(klant);
			return klant;
	}

	/**
	 * 
	 * @param Formule
	 * @param ProjectID
	 */
	public void PrototypeToevoegen(String Formule, int ProjectID){

	}

	/**
	 * 
	 * @param Kosten
	 * @param Opbrengsten
	 */
	public void RendementBerekenen(double Kosten, double Opbrengsten){

	}

	/**
	 * 
	 * @param Team
	 * @param Status
	 * @param Naam
	 */
	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Project StartProject(int id, int teamId, String status, String naam){
		project = new Project(id, teamId , status, naam);
		projecten.add(project);
		return project;
	}

	public int getAantalKlanten() {
		// TODO Auto-generated method stub
		return klanten.size();
	}
	
	public Klant zoekKlant(String naam){
		for (Klant k : this.klanten) {
			if(k.getKlantNaam().equals(naam))return k;
				
			}
		return null;

		

	}

	public Boolean getAanvraagAanvaard() {
		// TODO Auto-generated method stub
		// We gaan wat vals spelen
		aanvraag.setAanvaard();
		return aanvraag.getAanvaard();
	}

	public int getAantalProjecten() {
		// TODO Auto-generated method stub
		return projecten.size();
	}
	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Project zoekProject(int id) {
		// TODO Auto-generated method stub
		for (Project p : projecten) {
			if(p.getId() == id) return p;
			
		}
		return null;
	}
	@Autowired
    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
	@Override
	public List<Project> geefAlleProjectenTerug() {
		// TODO Auto-generated method stub
		return projectDao.getAllProjects();
	}
	

	}
	




