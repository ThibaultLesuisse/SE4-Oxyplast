package be.odisee.oxyplast.controller;

import be.odisee.oxyplast.domain.Project;
import be.odisee.oxyplast.service.ProjectToevoegenService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")


public class ProjectController {

    @Autowired
    protected ProjectToevoegenService pjs =null; // ready for dependency injection

    @RequestMapping(value={"/home.html","/index.html","lijst.html"},method=RequestMethod.GET)
    public String index(ModelMap model){
        List<Project> deLijst = pjs.geefAlleProjectenTerug();
        model.addAttribute("project", deLijst);
        return "/index";
    }
    // je zal naar index.jsp gaan

    @RequestMapping(value={"/project.html"},method=RequestMethod.GET)
    public String projectDetail(@RequestParam("id") Integer id, ModelMap model){
        Project project = pjs.zoekProject(id);
        model.addAttribute("project", project);
        return "/project";
    }
    // je zal naar persoon.jsp gaan
    
    @RequestMapping(value={"/nieuwProject.html"},method=RequestMethod.GET)
    public String projectFormulier(ModelMap model){
        Project project = new Project();
        model.addAttribute("hetproject", project);
        return "/nieuwProject";
    }
    // je zal naar nieuwePersoon.jsp gaan

    @RequestMapping(value={"/nieuwProject.html"},method=RequestMethod.POST)
    public String projectToevoegen(@ModelAttribute("hetproject") Project project, ModelMap model){
        Project nieuwProject = pjs.StartProject(project.getId(), project.getTeamId(), project.getStatus(), project.getNaam());
        System.out.println("DEBUG Projectgegevens naam: "+project.getNaam());
        return "redirect:project.html?id="+nieuwProject.getId();
    }
    
    
    @RequestMapping(value = { "/delete-project" }, method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Integer id) {
    	Project p = pjs.zoekProject(id);
        pjs.verwijderProject(p);
        return "/index";
    }
    @RequestMapping(value={"/editProject.html"},method=RequestMethod.GET)
    public String projectDetailEdit(@RequestParam("id") Integer id, ModelMap model){
        Project project = pjs.zoekProject(id);
        model.addAttribute("project", project);
        return "/project";
    }
    @RequestMapping(value={"/editProject.html"},method=RequestMethod.POST)
    public String projectAanpassen(@ModelAttribute("hetproject") Project project, ModelMap model){
    	pjs.aanpassenProject(project);
        System.out.println("DEBUG Projectgegevens naam: "+project.getNaam());
        return "redirect:project.html?id="+project.getId();
    }
    
    // je zal naar de detailpagina van de toegevoegde persoon gaan

}
