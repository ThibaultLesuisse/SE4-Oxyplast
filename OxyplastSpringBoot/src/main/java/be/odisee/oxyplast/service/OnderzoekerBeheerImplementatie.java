package be.odisee.oxyplast.service;

import java.util.ArrayList;
import java.util.List;
import be.odisee.oxyplast.dao.OnderzoekerDao;
import be.odisee.oxyplast.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("OnderzoekerBeheerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class OnderzoekerBeheerImplementatie implements OnderzoekerBeheerService {

	
	private OnderzoekerDao onderzoekerDao;
	
	@Autowired
    public void setPrototypeDao(OnderzoekerDao onderzoekerDao) {
        this.onderzoekerDao = onderzoekerDao;
    }
	
	
	public List<Onderzoeker> geefAlleOnderzoekersTerug(int teamid) {
		System.out.println(teamid);
		List<Onderzoeker> o = onderzoekerDao.getAllOnderzoekers(teamid);
		if (o.isEmpty()){
			System.out.println("lijst is leeg");
		} else {
			System.out.println(o.get(0).getId());
		}
		return o;
	}
	
	

}
