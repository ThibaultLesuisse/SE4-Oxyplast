package be.odisee.oxyplast.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.oxyplast.domain.Feedback;

@Repository("feedbackDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class FeedbackHibernateDao extends HibernateDao implements FeedbackDao {

	@Override
	public Feedback saveFeedback(int id, String feedback, int prototypeid, int partnerid) {
		Feedback f = new Feedback(id, feedback, prototypeid, partnerid);
		sessionSaveObject(f);
		return f;
	}

	@Override
	public Feedback getFeedbackById(int id) {
		return (Feedback) sessionGetObjectById("Feedback", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getAllFeedback() {
		return (List<Feedback>) sessionGetAllObjects("Feedback");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getAllFeedbackByPrototype(int prototypeid) {
		return (List<Feedback>) sessionGetAllObjectsById("Feedback", "prototypeid", prototypeid);
	}

	@Override
	public void updateFeedback(Feedback f) {
		sessionUpdateObject(f);
		System.out.println("DEBUG DAO update + feedback:" + f.getFeedback());
	}

	@Override
	public void deleteFeedback(Feedback f) {
		sessionDeleteObject(f);
	}

}
