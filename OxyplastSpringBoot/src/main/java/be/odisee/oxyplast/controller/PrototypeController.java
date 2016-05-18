package be.odisee.oxyplast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import be.odisee.oxyplast.domain.Prototype;
import be.odisee.oxyplast.service.PrototypeBeheerService;
import be.odisee.oxyplast.service.ProjectToevoegenService;


@Controller
@RequestMapping("/")
public class PrototypeController {
	
	@Autowired
	protected PrototypeBeheerService pbs = null;
	
	@Autowired 
	protected ProjectToevoegenService pts = null;
	
	// lijst van partners
	@RequestMapping(value={"prototype/prototypeLijst.html"}, method = RequestMethod.GET)
	public String prototypeLijst(ModelMap model){
		List<Prototype> pLijst = pbs.geefAllePrototypesTerugZonderId();
		model.addAttribute("prototypeItems", pLijst);
		return "prototype/prototypeLijst";
	}
	
	// details van partner
	@RequestMapping(value={"prototype/prototype.html"},method=RequestMethod.GET)
    public String prototypeDetail(@RequestParam("id") Integer id, ModelMap model){
		Prototype prototype = pbs.geefPrototypeById(id);
		model.addAttribute("prototype", prototype);
		return "prototype/prototype";
    }
	
	// nieuwe partner maken(form maken)
	@RequestMapping(value={"prototype/nieuwPrototype.html"},method=RequestMethod.GET)
	public String prototypeFormulier(ModelMap model){
		Prototype prototype = new Prototype();
		model.addAttribute("hetprototype", prototype);
		return "prototype/nieuwPrototype";
	}
	
	@RequestMapping(value={"prototype/nieuwPrototype.html"},method=RequestMethod.POST)
    public String prototypeToevoegen(@ModelAttribute("hetprototype") Prototype prototype, ModelMap model){
		Prototype nieuwPrototype = pbs.voegPrototypeToe(prototype.getId(), prototype.getProject(), prototype.getFormule());
        return "redirect:prototype/prototype.html?id="+nieuwPrototype.getId();
    }	
	// partner verwijderen
	@RequestMapping(value ={"prototype/deletePrototype.html"},method=RequestMethod.GET)
    public String deletePrototype(@RequestParam("id") Integer id, ModelMap model) {
		Prototype prototype = pbs.geefPrototypeById(id);
		pbs.deletePrototype(prototype);
		String boodschap= "Partner verwijderd!";
		model.addAttribute("SuccesOrNot", boodschap);
		return "partners/deletePartner";
    }
	
	// partner updaten(form maken)
	@RequestMapping(value={"prototype/editPrototype.html"},method=RequestMethod.GET)
    public String prototypeDetailEdit(@RequestParam("id") Integer id, ModelMap model){
		Prototype prototype = pbs.geefPrototypeById(id);
        model.addAttribute("partner", prototype);
        model.addAttribute("partnerAanpassen", prototype);
        return "prototype/editPrototype";
    }
	
	@RequestMapping(value={"/editPrototype.html"},method=RequestMethod.POST)
    public String prototypeAanpassen(@ModelAttribute("partnerAanpassen") Prototype prototype, ModelMap model){
    	pbs.updatePrototype(prototype);
        return "redirect:prototype/prototype.html?id=" + prototype.getId();
    }
	
}
