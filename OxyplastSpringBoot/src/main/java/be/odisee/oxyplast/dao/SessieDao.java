package be.odisee.oxyplast.dao;

import be.odisee.oxyplast.domain.Sessie;

public interface SessieDao {

    public Sessie saveSessie(int id, String status, String onderwerp);
    
    public Sessie saveSessie(String status, String onderwerp);

    public Sessie getSessieById(int sessieId);

}
