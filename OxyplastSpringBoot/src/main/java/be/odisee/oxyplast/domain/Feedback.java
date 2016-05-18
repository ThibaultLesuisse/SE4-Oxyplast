package be.odisee.oxyplast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:42:37
 */

@Entity
@Table(name="feedback")
@XmlRootElement(name="feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column
	private String feedback;
	
	@Column
	private int prototypeid;
	
	@Column
	private int partnerid;

	public Feedback(){

	}

	public Feedback(int id, String feedback, int prototypeid, int partnerid) {
		this.id = id;
		this.feedback = feedback;
		this.prototypeid = prototypeid;
		this.partnerid = partnerid;
	}

	@XmlElement(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name="feedack")
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@XmlElement(name="prototypeId")
	public int getPrototypeid() {
		return prototypeid;
	}

	public void setPrototypeid(int prototypeid) {
		this.prototypeid = prototypeid;
	}

	@XmlElement(name="partnerId")
	public int getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(int partnerid) {
		this.partnerid = partnerid;
	}
	
	
	

	/*public void finalize() throws Throwable {

	}*/

	/**
	 * 
	 * @param Feedback
	 * @param KlantID
	 * @param PrototypeID
	 */
	/*public int FeedbackID(String Feedback, int KlantID, int PrototypeID){
		return 0;
	}*/

}