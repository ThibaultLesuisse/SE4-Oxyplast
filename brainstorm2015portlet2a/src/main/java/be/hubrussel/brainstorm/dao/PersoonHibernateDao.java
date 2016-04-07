package be.hubrussel.brainstorm.dao;

import java.util.List;
import org.hibernate.*;

import be.hubrussel.brainstorm.domain.Persoon;


public class PersoonHibernateDao extends HibernateDao implements PersoonDao {

    public Persoon savePersoon(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        Persoon persoon = new Persoon(id, status, voornaam, familienaam, emailadres, paswoord);
        sessionSaveObject(persoon);
        return persoon;
    }

    public Persoon savePersoon(String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        Persoon persoon = new Persoon(status, voornaam, familienaam, emailadres, paswoord);
        sessionSaveObject(persoon);
        return persoon;
    }

    public Persoon getPersoonById(int persoonId) {
        return (Persoon) sessionGetObjectById("Persoon", persoonId);
    }

    public List<Persoon> getAllPersons() {
        return (List<Persoon>) sessionGetAllObjects("Persoon");
    }

    public void updatePersoon(Persoon persoon) {
        sessionUpdateObject(persoon);
    }

}
