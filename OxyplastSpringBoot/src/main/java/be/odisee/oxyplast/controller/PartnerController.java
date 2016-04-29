package be.odisee.oxyplast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import be.odisee.oxyplast.domain.Partner;
import be.odisee.oxyplast.service.PartnerBeheerService;

@Controller
@RequestMapping("/")
public class PartnerController {
	
	@Autowired
	protected PartnerBeheerService pts = null;
	
	// lijst van partners
	@RequestMapping(value={"partners/partnersLijst.html"}, method = RequestMethod.GET)
	public String partnerLijst(ModelMap model){
		List<Partner> pLijst = pts.geefAllePartnersTerug();
		model.addAttribute("partnerItems", pLijst);
		return "partners/partnersLijst";
	}
	
	// details van partner
	@RequestMapping(value={"partners/partner.html"},method=RequestMethod.GET)
    public String partnerDetail(@RequestParam("id") Integer id, ModelMap model){
		Partner partner = pts.getPartnerById(id);
		model.addAttribute("partner", partner);
		return "partners/partner";
    }
	
	// nieuwe partner maken(form maken)
	@RequestMapping(value={"partners/nieuwPartner.html"},method=RequestMethod.GET)
	public String partnerFormulier(ModelMap model){
		Partner partner = new Partner();
		model.addAttribute("departner", partner);
		return "partners/nieuwPartner";
	}
	
	// nieuwe partner maken(submit)
	@RequestMapping(value={"/nieuwPartner.html"},method=RequestMethod.POST)
    public String partnerToevoegen(@ModelAttribute("departner") Partner partner, ModelMap model){
		Partner nieuwePartner = pts.CreatePartner(partner.getId(), partner.getNaam(), partner.getVoornaam());
        System.out.println("DEBUG Partnergegevens partner: " + partner.getNaam() + partner.getVoornaam());
        return "redirect:partners/partner.html?id="+nieuwePartner.getId();
    }
	
	// partner verwijderen
	@RequestMapping(value ={"partners/deletePartner.html"},method=RequestMethod.GET)
    public String deletePartner(@RequestParam("id") Integer id, ModelMap model) {
		Partner PartnerItem = pts.getPartnerById(id);
		pts.deletePartner(PartnerItem);
		System.out.println("DEBUG Partnergegevens verwijderd: "+PartnerItem.getNaam() + PartnerItem.getVoornaam());
		String boodschap= "Partner verwijderd!";
		model.addAttribute("SuccesOrNot", boodschap);
		return "partners/deletePartner";
    }
	
	// partner updaten(form maken)
	@RequestMapping(value={"partners/editPartner.html"},method=RequestMethod.GET)
    public String partnerDetailEdit(@RequestParam("id") Integer id, ModelMap model){
		Partner partner = pts.getPartnerById(id);
        model.addAttribute("partner", partner);
        model.addAttribute("partnerAanpassen", partner);
        System.out.println("DEBUG Opening Edit Partner: " + partner.getNaam() + partner.getVoornaam());
        return "partners/editPartner";
    }
	
	// partner updaten(submit)
	@RequestMapping(value={"/editPartner.html"},method=RequestMethod.POST)
    public String partnerAanpassen(@ModelAttribute("partnerAanpassen") Partner partner, ModelMap model){
    	pts.updatePartner(partner);
        System.out.println("DEBUG Partnergegevens updated: " + partner.getNaam() + partner.getVoornaam());
        return "redirect:partners/partner.html?id=" + partner.getId();
    }
}
