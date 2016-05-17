package be.odisee.oxyplast.domain;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:43:51
 */
@Entity
@Table(name="team")
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public int id;
	
	//@OneToOne
    //@PrimaryKeyJoinColumn

	@Column(name="naam")
	public String naam;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="team")
    private Set<Onderzoeker> m_Onderzoekers= new HashSet<Onderzoeker>();
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Team(){
	}
	
	public Team(int id, String naam){
		this.id = id;
		this.naam = naam;
	}
}