package be.odisee.oxyplast.controller;

import be.odisee.oxyplast.domain.Project;
import be.odisee.oxyplast.domain.Onderzoeker;
import be.odisee.oxyplast.domain.Team;
import be.odisee.oxyplast.service.OnderzoekerBeheerService;
import be.odisee.oxyplast.service.TeamBeheerService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/") // teamOverzicht??
public class TeamController {
	
	@Autowired
    protected TeamBeheerService tbs =null;
	
	@Autowired// ready for dependency injection
    protected OnderzoekerBeheerService ohs = null;
	
	   @RequestMapping(value={"/team/teamOverzicht", "/team/teamOverzicht.html", "/team/teamoverzicht", "/team/teamoverzicht.html", "/teamOverzicht", "/teamOverzicht.html", "/teamoverzicht", "/teamoverzicht.html"},method=RequestMethod.GET)
	    public String index(ModelMap model){
	        List<Team> lijst = tbs.geefAlleTeamsTerug();
	        model.addAttribute("team", lijst);
	        return "team/teamOverzicht";
	    }
	   
	   @RequestMapping(value={"team/team.html"},method=RequestMethod.GET)
	    public String teamDetail(@RequestParam("id") Integer id, ModelMap model){
	        Team team = tbs.zoekTeam(id);
	        List<Onderzoeker> deOnderzoekers = ohs.geefAlleOnderzoekersTerug(id);
	        model.addAttribute("team", team);
	        model.addAttribute("onderzoeker", deOnderzoekers);
	        return "team/team";
	    }
	    // je zal naar persoon.jsp gaan
	    
	    @RequestMapping(value={"team/nieuwTeam.html"},method=RequestMethod.GET)
	    public String teamFormulier(ModelMap model){
	        Team team = new Team();
	        model.addAttribute("hetTeam", team);
	        return "team/nieuwTeam";
	    }
	    // je zal naar nieuwePersoon.jsp gaan

	    @RequestMapping(value={"/nieuwTeam.html"},method=RequestMethod.POST)
	    public String teamToevoegen(@ModelAttribute("hetTeam") Team team, ModelMap model){
	        Team nieuwTeam = tbs.StartTeam(team.getId(), team.getNaam());
	        System.out.println("DEBUG Teamgegevens naam: "+team.getNaam());
	        return "redirect:team/team.html?id="+nieuwTeam.getId();
	    }
	    
	    
	    @RequestMapping(value = { "team/deleteTeam.html" }, method = RequestMethod.GET)
	    public String deleteUser(@RequestParam("id") Integer id, ModelMap m) {
	    	Team t = tbs.zoekTeam(id);
	        //boolean deleted = tbs.verwijderTeam(p);
	    	tbs.verwijderTeam(t);
	        System.out.println("DEBUG Teamgegevens naam van verwijderd: "+t.getNaam());
	        String boodschap= "Team Verwijderd";
	        m.addAttribute("SuccesOrNot", boodschap);
	        return "team/deleteTeam";
	    }
	    @RequestMapping(value={"team/editTeam.html"},method=RequestMethod.GET)
	    public String teamDetailEdit(@RequestParam("id") Integer id, ModelMap model){
	        Team team = tbs.zoekTeam(id);
	        model.addAttribute("team", team);
	        model.addAttribute("teamAanpassen", team);
	        System.out.println("DEBUG Opening Edit team naam: "+team.getNaam());
	        return "team/editTeam";
	    }
	    @RequestMapping(value={"/editTeam.html"},method=RequestMethod.POST)
	    public String teamAanpassen(@ModelAttribute("teamAanpassen") Team team, ModelMap model){
	    	tbs.aanpassenTeam(team);
	        System.out.println("DEBUG Teamgegevens naam: "+team.getNaam()+ team.getId());
	        return "redirect:team/team.html?id="+team.getId();
	    }

}
