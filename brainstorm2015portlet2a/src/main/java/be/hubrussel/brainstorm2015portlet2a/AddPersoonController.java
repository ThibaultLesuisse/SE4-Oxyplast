package be.hubrussel.brainstorm2015portlet2a;

import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import be.hubrussel.brainstorm.domain.Persoon;
import be.hubrussel.brainstorm.service.BrainstormSessieService;


@Controller(value = "addPersoonController")
@RequestMapping(value = "VIEW")
@SessionAttributes("persoon")
public class AddPersoonController {

    @Autowired
    protected BrainstormSessieService brainstormSessieService=null; // ready for dependency injection

	@ModelAttribute("persoon")
	public Persoon getCommandObject() {
		return new Persoon();
	}

	@RenderMapping(params = "myaction=addPersoonForm")
	public String persoonFormulier(RenderResponse response){
        return "/nieuwePersoon";
    }
    // je zal naar nieuwePersoon.jsp gaan

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}

	@ActionMapping(params = "myaction=addPersoon")
    public void persoonToevoegen(@ModelAttribute(value="persoon") Persoon persoon, BindingResult result,
        SessionStatus status, ActionResponse response ){
        Persoon toegevoegdPersoon = brainstormSessieService.voegPersoonToe(persoon.getVoornaam(),
                                                                            persoon.getFamilienaam(),
                                                                            persoon.getEmailadres(),
                                                                            persoon.getPaswoord());
        response.setRenderParameter("myaction", "persoonDetail");
        response.setRenderParameter("id", Integer.toString(toegevoegdPersoon.getId()));
        status.setComplete();
    }
    // je zal naar de detailpagina van de toegevoegde persoon gaan

}