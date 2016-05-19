package be.odisee.oxyplast.controller;


import be.odisee.oxyplast.domain.*;
import be.odisee.oxyplast.service.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        List<Aanvraag> deAanvragenLijst = pjs.geefAlleAanvragenTerugNietAanvaard();
        List<Bestelling> deBestellingenLijst = bhs.geefAlleBestllingenTerug();
        
        model.addAttribute("aantalProjecten", deLijst.size());
        model.addAttribute("aantalPrototypes", dePrototypeLijst.size());
        model.addAttribute("aantalAanvragen", deAanvragenLijst.size());
        model.addAttribute("aantalBestellingen", deBestellingenLijst.size());
        
        
        model.addAttribute("project", deLijst);
        return "/index";
    }
    @RequestMapping(value={"/project/projectenLijst.html"},method=RequestMethod.GET)
    public String geefAlleProjectenWeer(ModelMap model){
        List<Project> deLijst = pjs.geefAlleProjectenTerug();     
        model.addAttribute("project", deLijst);
        return "project/projectenLijst";
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
        Project nieuwProject = pjs.StartProject(project.getId(), project.getTeamId(), project.getStatus(), project.getNaam(), project.getStartdate(), project.getEnddate());
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
        return "redirect:/project.html?id="+project.getId();
    }
    
    
    @RequestMapping(value={"/aanvraag/aanvraagLijst.html"},method=RequestMethod.GET)
    public String geefLijstVanAanvragen(ModelMap model){
        List<Aanvraag> deLijst = pjs.geefAlleAanvragenTerug();
        model.addAttribute("aanvraagItems", deLijst);
        return "aanvraag/aanvraagLijst";
    }
    
    @RequestMapping(value={"aanvraag/aanvraag.html"},method=RequestMethod.GET)
    public String aanvraagDetail(@RequestParam("id") Integer id, ModelMap model){
       Aanvraag aanvraag = new Aanvraag();
       	aanvraag = pjs.zoekAanvraagMetId(id);
        model.addAttribute("aanvraag", aanvraag);

        return "/aanvraag";
    }
    @RequestMapping(value = { "aanvraag/deleteAanvraag.html" }, method = RequestMethod.GET)
    public String deleteAanvraag(@RequestParam("id") Integer id, ModelMap m) {
    	Aanvraag aanvraag = pjs.zoekAanvraagMetId(id);
    	pjs.verwijderAanvraag(aanvraag);
        System.out.println("DEBUG Aanvraag naam van verwijderd: "+aanvraag.getId());
        String boodschap= "Project Verwijderd";
        m.addAttribute("SuccesOrNot", boodschap);
        return "/deleteAanvraag";
    }
    @RequestMapping(value={"aanvraag/editAanvraag.html"},method=RequestMethod.GET)
    public String aanvraagDetailEdit(@RequestParam("id") Integer id, ModelMap model){
        Aanvraag aanvraag = pjs.zoekAanvraagMetId(id);
        model.addAttribute("aanvraag", aanvraag);
        model.addAttribute("projectAanvraag", aanvraag);
        return "aanvraag/editAanvraag";
    }
    @RequestMapping(value={"/editAanvraag.html"},method=RequestMethod.POST)
    public String aanvraagAanpassen(@ModelAttribute("projectAanpassen") Aanvraag aanvraag, ModelMap model){
    	pjs.updateAanvraag(aanvraag);
     
        return "redirect:aanvraag/aanvraag.html?id="+aanvraag.getId();
    }
    
    // ------------------------- Aanvaarden 
    
    @RequestMapping(value={"aanvraag/aanvaardAanvraag.html"},method=RequestMethod.GET)
    public String aanvaardAanvraag(@RequestParam("id") Integer id, ModelMap model){
    	 Project project = new Project();
    	 pjs.aanvaardAanvraag(id);
         model.addAttribute("hetproject", project);
         return "project/nieuwProject";
    }
    

    @CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value={"/rest/projectenLijst"}, method = RequestMethod.GET)
	public @ResponseBody String[][] getFeedbacklijst(){
		List<Project> project = pjs.geefAlleProjectenTerug();
		String[][] terugTegevenProjecten = new String[project.size()][4];
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		for (int i=0;i<project.size();i++) {
			terugTegevenProjecten[i][0] = Integer.toString(project.get(i).getId());
			terugTegevenProjecten[i][1] = project.get(i).getNaam();
			terugTegevenProjecten[i][2] = df.format(project.get(i).getStartdate());
			terugTegevenProjecten[i][3] = df.format(project.get(i).getEnddate());					
			};
		return terugTegevenProjecten;	
	}
    @CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value={"/rest/projecten"}, method = RequestMethod.GET)
	public @ResponseBody List<Project> getProctenLijstREST(@RequestBody(required=false) Date date, Date date2, String blamb) {
		List<Project> project = pjs.geefAlleProjectenTerug();
		System.out.println("DEBUG Projectgegevens REST ");
		return project;
		
	}
    

}
