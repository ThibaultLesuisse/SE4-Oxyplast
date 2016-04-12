package be.odisee.oxyplast.dao;

import be.odisee.oxyplast.domain.Persoon;
import java.util.List;

public interface PersoonDao {

    public Persoon savePersoon(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord);

    public Persoon savePersoon(String string, String voornaam, String familienaam, String emailadres, String paswoord);

    public Persoon getPersoonById(int persoonId);

    public Persoon getPersoonByEmailadres(String emailadres);

    public List<Persoon> getAllPersons();

    public void updatePersoon(Persoon persoon);

}
