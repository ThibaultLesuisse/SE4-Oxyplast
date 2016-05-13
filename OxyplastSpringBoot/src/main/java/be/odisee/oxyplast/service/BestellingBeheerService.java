package be.odisee.oxyplast.service;

import java.util.List;

import be.odisee.oxyplast.domain.Bestelling;
import be.odisee.oxyplast.domain.Leverancier;



public interface BestellingBeheerService {
	public List<Bestelling> geefAlleBestllingenTerug();
	//public List<Prototype> geefAllePrototypesTerugZonderId();
}
