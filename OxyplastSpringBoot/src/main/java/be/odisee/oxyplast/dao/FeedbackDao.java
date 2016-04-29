package be.odisee.oxyplast.dao;

import java.util.List;

import be.odisee.oxyplast.domain.Feedback;

public interface FeedbackDao {
	
	public Feedback saveFeedback(int id, String feedback, int prototypeid, int partnerid);
	public Feedback getFeedbackById(int id);
	public List<Feedback> getAllFeedback();
	public List<Feedback> getAllFeedbackByPrototype(int prototypeid);
	public void updateFeedback(Feedback f);
	public void deleteFeedback(Feedback f);
}
