package be.odisee.oxyplast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.oxyplast.dao.FeedbackDao;
import be.odisee.oxyplast.domain.Feedback;

@Service("FeedbackBeheerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class FeedbackBeheerImplementatie implements FeedbackBeheerService {

	private FeedbackDao feedbackDao;
	
	@Autowired
    public void setFeedbackDao(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }
	
	@Override
	// geeft lijst van alle feedback terug 
	public List<Feedback> geefAlleFeedbackTerug() {
		List<Feedback> f = feedbackDao.getAllFeedback();
		if (f.isEmpty()){
			System.out.println("lijst is leeg");
		} else {
			System.out.println(f.get(0).getId());
		}
		return f;
	}

	@Override
	// geeft lijst van feedback terug gefilterd op prototypeID
	public List<Feedback> geefAlleFeedbackVoorProjectTerug(int prototypeID) {
		System.out.println(prototypeID);
		List<Feedback> f = feedbackDao.getAllFeedbackByPrototype(prototypeID);
		if (f.isEmpty()){
			System.out.println("lijst is leeg");
		} else {
			System.out.println(f.get(0).getId());
		}
		return f;
	}

	@Override
	public Feedback CreateFeedback(int id, String feedback, int prototypeid, int partnerid) {
		return this.feedbackDao.saveFeedback(id, feedback, prototypeid, partnerid);
	}

	@Override
	public Feedback getFeedbackById(int id) {
		System.out.println("DEBUG FBS (zoek): "+ this.feedbackDao.getFeedbackById(id));
		return this.feedbackDao.getFeedbackById(id);
	}

	@Override
	public void updateFeedback(Feedback f) {
		System.out.println("DEBUG FBS (update): " + f.getFeedback());
		this.feedbackDao.updateFeedback(f);
	}

	@Override
	public void deleteFeedback(Feedback f) {
		System.out.println("DEBUG FBS (delete): " + f.getFeedback());
		this.feedbackDao.deleteFeedback(f);
	}
}
