package be.odisee.oxyplast.controller;


import be.odisee.oxyplast.domain.*;
import be.odisee.oxyplast.service.*;
import groovy.transform.ToString;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.tools.JavaFileObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ProjectController {

    @Autowired
    protected ProjectToevoegenService pjs =null;
    
    @Autowired// ready for dependency injection
    protected PrototypeBeheerService phs = null;
    
    @Autowired// ready for dependency injection
    protected OnderzoekerBeheerService obs = null;
    
    @Autowired// ready for dependency injection
    protected BestellingBeheerService bhs = null;
    
    
    
    @RequestMapping(value={"/index", "/"},method=RequestMethod.GET)
    public String index(ModelMap model){
        List<Project> deLijst = pjs.geefAlleProjectenTerug();
        List<Prototype> dePrototypeLijst = phs.geefAllePrototypesTerugZonderId();
        List<Aanvraag> deAanvragenLijst = pjs.geefAlleAanvragenTerug();
        List<Bestelling> deBestellingenLijst = bhs.geefAlleBestllingenTerug();
        
        model.addAttribute("aantalProjecten", deLijst.size());
        model.addAttribute("aantalPrototypes", dePrototypeLijst.size());
        model.addAttribute("aantalAanvragen", deAanvragenLijst.size());
        model.addAttribute("aantalBestellingen", deBestellingenLijst.size());
        
        
        model.addAttribute("project", deLijst);
        return "/index";
    }
    // je zal naar index.jsp gaan

    @RequestMapping(value={"project/project.html"},method=RequestMethod.GET)
    public String projectDetail(@RequestParam("id") Integer id, ModelMap model){
        Project project = pjs.zoekProject(id);
        List<Prototype> dePrototypes = phs.geefAllePrototypesTerug(id);
        model.addAttribute("project", project);
        model.addAttribute("prototype", dePrototypes);
        return "project/project";
    }
    // je zal naar persoon.jsp gaan
    
    @RequestMapping(value={"project/nieuwProject.html"},method=RequestMethod.GET)
    public String projectFormulier(ModelMap model){
        Project project = new Project();
        model.addAttribute("hetproject", project);
        return "project/nieuwProject";
    }
    // je zal naar nieuwePersoon.jsp gaan

    @RequestMapping(value={"/nieuwProject.html"},method=RequestMethod.POST)
    public String projectToevoegen(@ModelAttribute("hetproject") Project project, ModelMap model){
        Project nieuwProject = pjs.StartProject(project.getId(), project.getTeamId(), project.getStatus(), project.getNaam());
        System.out.println("DEBUG Projectgegevens naam: "+project.getNaam());
        return "redirect:project/project.html?id="+nieuwProject.getId();
    }
    
    
    @RequestMapping(value = { "project/deleteProject.html" }, method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Integer id, ModelMap m) {
    	Project p = pjs.zoekProject(id);
        //boolean deleted = pjs.verwijderProject(p);
    	pjs.verwijderProject(p);
        System.out.println("DEBUG Projectgegevens naam van verwijderd: "+p.getNaam());
        String boodschap= "Project Verwijderd";
        m.addAttribute("SuccesOrNot", boodschap);
        return "project/deleteProject";
    }
    @RequestMapping(value={"project/editProject.html"},method=RequestMethod.GET)
    public String projectDetailEdit(@RequestParam("id") Integer id, ModelMap model){
        Project project = pjs.zoekProject(id);
        model.addAttribute("project", project);
        model.addAttribute("projectAanpassen", project);
        System.out.println("DEBUG Opening Edit project naam: "+project.getNaam());
        return "project/editProject";
    }
    @RequestMapping(value={"/editProject.html"},method=RequestMethod.POST)
    public String projectAanpassen(@ModelAttribute("projectAanpassen") Project project, ModelMap model){
    	pjs.aanpassenProject(project);
        System.out.println("DEBUG Projectgegevens naam: "+project.getNaam()+ project.getId());
        return "redirect:project/project.html?id="+project.getId();
    }
    
	@RequestMapping(value={"/rest/projectenLijst"}, method = RequestMethod.GET)
	public @ResponseBody String[][] getFeedbacklijst(){
		List<Project> project = pjs.geefAlleProjectenTerug();
		String[][] terugTegevenProjecten = new String[project.size()][4];
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		for (int i=0;i<project.size();i++) {
			terugTegevenProjecten[i][0] = Integer.toString(project.get(i).getId());
			terugTegevenProjecten[i][1] = project.get(i).getNaam();
			terugTegevenProjecten[i][2] = df.format(project.get(i).getStartdatum());
			terugTegevenProjecten[i][3] = df.format(project.get(i).getEinddatum());		
			
			};
		
	
		return terugTegevenProjecten;
		
	}
	
	@RequestMapping(value={"/rest/projecten**"}, method = RequestMethod.GET)
	public @ResponseBody List<Project> getProctenLijstREST(@RequestBody(required=false) Date date, Date date2, String blamb) {
		List<Project> project = pjs.geefAlleProjectenTerug();
		System.out.println("DEBUG Projectgegevens REST ");
		return project;
		
	}
    

}
