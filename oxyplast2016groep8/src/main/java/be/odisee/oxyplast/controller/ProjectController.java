package be.odisee.oxyplast.controller;

import be.odisee.oxyplast.domain.Project;
import be.odisee.oxyplast.service.*;

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
    public String persoonDetail(@RequestParam("naam") String naam, ModelMap model){
        Project project = pjs.zoekProject(naam);
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
        Project nieuwProject = pjs.StartProject(project.getProjectTeamId(), project.getProjectStatus(), project.getProjectNaam());
        System.out.println("DEBUG Projectgegevens naam: "+project.getProjectNaam());
        return "redirect:project.html?id="+nieuwProject.getProjectNaam();
    }
    // je zal naar de detailpagina van de toegevoegde persoon gaan

}
