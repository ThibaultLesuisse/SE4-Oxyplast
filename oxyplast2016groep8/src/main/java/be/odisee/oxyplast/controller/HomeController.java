package be.odisee.oxyplast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

@RequestMapping(method = RequestMethod.GET)
  public String home(Model model) {
	String boodschap="Welkom Oxyplast!";
	model.addAttribute("boodschap",boodschap);
    return "home";
  }

}