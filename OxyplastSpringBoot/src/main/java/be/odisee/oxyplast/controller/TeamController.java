package be.odisee.oxyplast.controller;

import be.odisee.oxyplast.domain.Team;
import be.odisee.oxyplast.service.TeamBeheerService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TeamController {
	
	@Autowired
    protected TeamBeheerService tbs =null;
	
	   @RequestMapping(value={"/team/teamOverzicht.html"},method=RequestMethod.GET)
	    public String index(ModelMap model){
	        List<Team> lijst = tbs.geefAlleTeamsTerug();
	        model.addAttribute("team", lijst);
	        return "team/teamOverzicht";
	    }

}
