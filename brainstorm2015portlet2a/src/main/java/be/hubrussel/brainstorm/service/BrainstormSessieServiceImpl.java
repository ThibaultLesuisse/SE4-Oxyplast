package be.hubrussel.brainstorm.service;

import be.hubrussel.brainstorm.domain.*;
import be.hubrussel.brainstorm.dao.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.*;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class BrainstormSessieServiceImpl implements BrainstormSessieService {

    private PersoonDao persoonDao;

    public BrainstormSessieServiceImpl(){}

    @Autowired
    public void setPersoonDao(PersoonDao persoonDao) {
        this.persoonDao = persoonDao;
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Persoon voegPersoonToe(String voornaam, String familienaam, String emailadres, String paswoord) {
        return persoonDao.savePersoon("aktief",voornaam,familienaam,emailadres,paswoord);
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Persoon zoekPersoonMetId(int id){
        return persoonDao.getPersoonById(id);
    }

    @Override
    public List<Persoon> geefAllePersonen() {
        return persoonDao.getAllPersons();
    }

}