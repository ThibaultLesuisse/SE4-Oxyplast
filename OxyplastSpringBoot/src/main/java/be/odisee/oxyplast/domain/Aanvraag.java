package be.odisee.oxyplast.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.Index;
/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:35:23
 */
@Entity
@Table(name="aanvraag")
public class Aanvraag {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	public void setKlant(Klant klant) {
		this.klant = klant;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="klantid")
	private Klant klant;
	
	@Column
	private String aanvraag;
	public Aanvraag(){

	}

	public Aanvraag(int id, Klant klant , String aanvraag){
		this.id = id;
		this.klant = klant;
		this.aanvraag = aanvraag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public Klant getKlant() {
		return klant;
	}
	public void setKlantid(Klant klant) {
		this.klant = klant;
	}
	public String getAanvraag() {
		return aanvraag;
	}
	public void setAanvraag(String aanvraag) {
		this.aanvraag = aanvraag;
	}

}