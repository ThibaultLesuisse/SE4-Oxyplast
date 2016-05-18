package be.odisee.oxyplast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import be.odisee.oxyplast.domain.Feedback;
import be.odisee.oxyplast.service.FeedbackBeheerService;

@Controller
@RequestMapping("/")
public class FeedbackController {
	
	@Autowired
	protected FeedbackBeheerService fbs = null;
	
	// lijst van feedback
	@RequestMapping(value={"feedback/feedbackLijst.html"}, method = RequestMethod.GET)
	public String feedbackLijst(ModelMap model){
		List<Feedback> fbLijst = fbs.geefAlleFeedbackTerug();
		model.addAttribute("feedbackItems", fbLijst);
		return "feedback/feedbackLijst";
	}
	
	// details van feedback
	@RequestMapping(value={"feedback/feedback.html"},method=RequestMethod.GET)
    public String feedbackDetail(@RequestParam("id") Integer id, ModelMap model){
		Feedback feedback = fbs.getFeedbackById(id);
		model.addAttribute("feedback", feedback);
		return "feedback/feedback";
    }
	
	// nieuwe feedback maken(form maken)
	@RequestMapping(value={"feedback/nieuwFeedback.html"},method=RequestMethod.GET)
	public String feedbackFormulier(ModelMap model){
		Feedback feedback = new Feedback();
		model.addAttribute("defeedback", feedback);
		return "feedback/nieuwFeedback";
	}
	
	// nieuwe feedback maken(submit)
	@RequestMapping(value={"/nieuwFeedback.html"},method=RequestMethod.POST)
    public String feedbackToevoegen(@ModelAttribute("defeedback") Feedback feedback, ModelMap model){
        Feedback nieuweFeedback = fbs.CreateFeedback(feedback.getId(), feedback.getFeedback(), feedback.getPrototypeid(), feedback.getPartnerid());
        System.out.println("DEBUG Feedbackgegevens feedback: " + feedback.getFeedback());
        return "redirect:feedback/feedback.html?id="+nieuweFeedback.getId();
    }
	
	// feedback verwijderen
	@RequestMapping(value ={"feedback/deleteFeedback.html"},method=RequestMethod.GET)
    public String deleteFeedback(@RequestParam("id") Integer id, ModelMap model) {
		Feedback feedbackItem = fbs.getFeedbackById(id);
		fbs.deleteFeedback(feedbackItem);
		System.out.println("DEBUG Feedbackgegevens verwijderd: "+feedbackItem.getFeedback());
		String boodschap= "Feedback verwijderd!";
		model.addAttribute("SuccesOrNot", boodschap);
		return "feedback/deleteFeedback";
    }
	
	// feedback updaten(form maken)
	@RequestMapping(value={"feedback/editFeedback.html"},method=RequestMethod.GET)
    public String feedbackDetailEdit(@RequestParam("id") Integer id, ModelMap model){
        Feedback feedback = fbs.getFeedbackById(id);
        model.addAttribute("feedback", feedback);
        model.addAttribute("feedbackAanpassen", feedback);
        System.out.println("DEBUG Opening Edit Feedback: " + feedback.getFeedback());
        return "feedback/editFeedback";
    }
	
	// feedback updaten(submit)
	@RequestMapping(value={"/editFeedback.html"},method=RequestMethod.POST)
    public String feedbackAanpassen(@ModelAttribute("feedbackAanpassen") Feedback feedback, ModelMap model){
    	fbs.updateFeedback(feedback);
        System.out.println("DEBUG Feedbackgegevens updated: " + feedback.getFeedback());
        return "redirect:feedback/feedback.html?id=" + feedback.getId();
    }	
}
