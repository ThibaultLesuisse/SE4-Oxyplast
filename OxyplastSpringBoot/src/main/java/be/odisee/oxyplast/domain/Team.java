package be.odisee.oxyplast.domain;
import java.lang.reflect.Array;
import javax.persistence.*;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:43:51
 */
@Entity
@Table(name="team")
public class Team {
	
	@Column(name="teamid")
	public int teamid;
	
	@OneToOne
    @PrimaryKeyJoinColumn
	@Column(name="projectid")
	public int projectid;

	@Column(name="omschrijving")
	public String omschrijving;
	
	@Column(name="actief")
	public Boolean actief;
	
	public Boolean getActief() {
		return actief;
	}

	public void setActief(Boolean actief) {
		this.actief = actief;
	}
	public int getTeamid() {
		return teamid;
	}
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public Team(){
	}
	
	public Team(int teamid, int projectid, String omschrijving, Boolean actief){
		this.teamid = teamid;
		this.projectid = projectid;
		this.omschrijving = omschrijving;
		this.actief = actief;
	}
}