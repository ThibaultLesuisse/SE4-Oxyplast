package be.odisee.oxyplast.dao;
import be.odisee.oxyplast.domain.Prototype;
import java.util.List;
public interface PrototypeDao {



	    public Prototype savePrototype(int id ,int projectid, String formule);
	    public Prototype getPrototypeById(int id);
	    public List<Prototype> getAllPrototypes(int projectId);
	    public void updatePrototype(Prototype p);    
	    public void deletePrototype(Prototype p);

	    
	    

	

}
