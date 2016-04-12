package be.odisee.oxyplast.service;

import be.odisee.oxyplast.domain.Persoon;

public interface UserContextService {

    public Persoon getAuthenticatedPersoon();
}
