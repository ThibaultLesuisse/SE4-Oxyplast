package be.odisee.oxyplast.service;

import java.util.List;

import be.odisee.oxyplast.domain.Feedback;

public interface FeedbackBeheerService {
	
	public Feedback CreateFeedback(int id, String feedback, int prototypeid, int partnerid);
	public Feedback getFeedbackById(int id);
	public List<Feedback> geefAlleFeedbackTerug();
	public List<Feedback> geefAlleFeedbackVoorProjectTerug(int prototypeID);
	public void updateFeedback(Feedback f);
	public void deleteFeedback(Feedback f);
}
