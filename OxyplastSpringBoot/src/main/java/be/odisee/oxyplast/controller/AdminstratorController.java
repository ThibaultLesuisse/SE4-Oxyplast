package be.odisee.oxyplast.controller;

import be.odisee.oxyplast.domain.Persoon;
import be.odisee.oxyplast.service.ProjectBeheerImplementatieService;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminstratorController {

    @Autowired
    protected ProjectBeheerImplementatieService PJS=null; // ready for dependency injection

    @RequestMapping(value={"/admin/index.html", "/admin/home.html"},method=RequestMethod.GET)
    public String index(ModelMap model){
        List<Persoon> deLijst = PJS.geefAllePersonen();
        model.addAttribute("personen", deLijst);
        return "/admin/lijstPersonen";
    }
    // je zal naar index.jsp gaan

    @RequestMapping(value={"/admin/persoon.html"},method=RequestMethod.GET)
    public String persoonDetail(@RequestParam("id") Integer id, ModelMap model){
        Persoon persoon = PJS.zoekPersoonMetId(id);
        model.addAttribute("persoon", persoon);
        return "/admin/persoon";
    }
    // je zal naar persoon.jsp gaan
    
    @RequestMapping(value={"/admin/nieuwePersoon.html"},method=RequestMethod.GET)
    public String persoonFormulier(ModelMap model){
        Persoon persoon = new Persoon();
        model.addAttribute("depersoon", persoon);
        return "/admin/nieuwePersoon";
    }
    // je zal naar nieuwePersoon.jsp gaan

    @RequestMapping(value={"/admin/nieuwePersoon.html"},method=RequestMethod.POST)
    public String persoonToevoegen(@ModelAttribute("depersoon") @Valid Persoon persoon,
                                                        BindingResult result, ModelMap model){

        if (result.hasErrors()) return "/admin/nieuwePersoon";  // fouten op de form => form opnieuw tonen

        Persoon toegevoegdPersoon = PJS.voegPersoonToe(persoon.getVoornaam(),
                                                                            persoon.getFamilienaam(),
                                                                            persoon.getEmailadres(),
                                                                            persoon.getPaswoord());

        return "redirect:/admin/persoon.html?id="+toegevoegdPersoon.getId();
    }
    // je zal naar de detailpagina van de toegevoegde persoon gaan

}
