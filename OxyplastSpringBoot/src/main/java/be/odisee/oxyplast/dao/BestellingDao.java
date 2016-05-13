package be.odisee.oxyplast.dao;
import be.odisee.oxyplast.domain.*;
import java.util.List;
public interface BestellingDao {

	   public Bestelling saveBestelling(int id ,int aantal, Leverancier l, Project p, Prototype pr);
	    public Bestelling getBestellingById(int projectId);
	    public List<Bestelling> getAllBestellingen();
	    public void updateBestelling(Bestelling bestelling);    
	    public void deleteBestelling(Bestelling bestelling);


}