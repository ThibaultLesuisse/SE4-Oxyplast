package be.odisee.oxyplast.service;
import java.util.List;

import be.odisee.oxyplast.domain.*;
import utilities.*;
import be.odisee.oxyplast.controller.ProjectController;



public interface PrototypeBeheerService {
	
	public List<Prototype> geefAllePrototypesTerug(int ProjectId);
	public List<Prototype> geefAllePrototypesTerugZonderId();

}
