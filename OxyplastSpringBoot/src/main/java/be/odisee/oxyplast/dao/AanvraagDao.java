package be.odisee.oxyplast.dao;
import be.odisee.oxyplast.domain.Aanvraag;
import java.util.List;
public interface AanvraagDao {



	    public Aanvraag saveAanvraag(int id ,int klantid, String aanvraag);
	    public Aanvraag getAanvraagById(int projectId);
	    public List<Aanvraag> getAllAanvragen();
	    public void updateAanvraag(Aanvraag Aanvraag);    
	    public void deleteAanvraag(Aanvraag Aanvraag);

	    
	    

	

}
