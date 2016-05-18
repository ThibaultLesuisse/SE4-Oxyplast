package be.odisee.oxyplast.service;


import java.util.List;
import be.odisee.oxyplast.dao.BestellingDao;
import be.odisee.oxyplast.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("BestellingBeheerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class BestellingBeheerImplementatie implements BestellingBeheerService {

	public Bestelling bestelling;
	
	
	private BestellingDao bestellingDao;
	
	   @Autowired
	    public void setBestellingDao(BestellingDao bestellingDao) {
	        this.bestellingDao = bestellingDao;
	    }
	
	public List<Bestelling> geefAlleBestllingenTerug() {
		// TODO Auto-generated method stub
		return bestellingDao.getAllBestellingen();
	}

}
