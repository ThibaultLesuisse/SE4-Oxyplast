package be.hubrussel.brainstorm.service;

import be.hubrussel.brainstorm.domain.*;
import java.util.List;

public interface BrainstormSessieService {

    public Persoon voegPersoonToe(String voornaam, String familienaam, String emailadres, String paswoord);

    public Persoon zoekPersoonMetId(int id);

    public List<Persoon> geefAllePersonen();

}