package be.odisee.oxyplast.service;

import java.util.ArrayList;
import java.util.List;
import be.odisee.oxyplast.dao.PrototypeDao;
import be.odisee.oxyplast.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("PrototypeBeheerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class PrototypeBeheerImplementatie implements PrototypeBeheerService {

	
	private PrototypeDao prototypeDao;
	
	@Autowired
    public void setPrototypeDao(PrototypeDao prototypeDao) {
        this.prototypeDao = prototypeDao;
    }
	
	
	public List<Prototype> geefAllePrototypesTerug(int projectId) {
		System.out.println(projectId);
		List<Prototype> p = prototypeDao.getAllPrototypes(projectId);
		if (p.isEmpty()){
			System.out.println("lijst is leeg");
		} else {
			System.out.println(p.get(0).getId());
		}
		return p;
	}
	public List<Prototype> geefAllePrototypesTerugZonderId() {

		List<Prototype> p = prototypeDao.getAllPrototypesWithoutId();
		if (p.isEmpty()){
			System.out.println("lijst is leeg");
		} else {
			System.out.println(p.get(0).getId());
		}
		return p;
	}
	
	

}
