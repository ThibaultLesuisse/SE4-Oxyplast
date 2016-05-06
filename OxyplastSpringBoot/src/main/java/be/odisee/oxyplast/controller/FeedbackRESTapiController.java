package be.odisee.oxyplast.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import be.odisee.oxyplast.domain.Feedback;
import be.odisee.oxyplast.service.FeedbackBeheerService;

@Controller
public class FeedbackRESTapiController {
	
	@Autowired
	protected FeedbackBeheerService Fserv = null;
	
	@RequestMapping("/rest/getfeedback.html")
	public String getfeedbackhtml(){
		return "getfeedback";
	}
	
	
	// REST GET - lijst van alle feedback in database
	@RequestMapping(value={"/rest/feedbacklijst"}, method = RequestMethod.GET)
	public @ResponseBody List<Feedback> getFeedbacklijst(){
		List<Feedback> f = Fserv.geefAlleFeedbackTerug();
		return f;
	}
	
	// REST GET - feedback dat bij gegeven id hoort
	@RequestMapping(value={"/rest/feedback/{id}"}, method = RequestMethod.GET)
	public @ResponseBody Feedback getFeedback(@PathVariable("id") Integer id) {
		Feedback f = Fserv.getFeedbackById(id);
		return f;
	}
	
	// REST PUT - update bestaande feedback volgens input client
	@RequestMapping(value={"/rest/feedback/{id}"}, method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void putFeedback(@PathVariable("id") Integer id, @RequestBody Feedback feedback){
		feedback.setId(id);
		Fserv.updateFeedback(feedback);
	}
	
	// REST DELETE - delete feedback van client
	@RequestMapping(value={"/rest/feedback/{id}"}, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFeedback(@PathVariable("id") Integer id){
		Feedback f = Fserv.getFeedbackById(id);
		Fserv.deleteFeedback(f);
	}
	
	// REST POST - create feedback door client
	@RequestMapping(value={"/rest/feedback/{id}"}, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Feedback createFeedback(@RequestBody Feedback f, HttpServletResponse response) throws BindException {
		Fserv.CreateFeedback(f.getId(), f.getFeedback(), f.getPrototypeid(), f.getPartnerid());
		response.setHeader("Location", "/rest/feedback/"+f.getId());
		return f;
	}
}
