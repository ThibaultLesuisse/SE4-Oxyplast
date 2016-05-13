package be.odisee.oxyplast.service;
import java.util.List;

import be.odisee.oxyplast.domain.*;
import utilities.*;
import be.odisee.oxyplast.controller.ProjectController;



public interface PrototypeBeheerService {
	
	public List<Prototype> geefAllePrototypesTerug(int ProjectId);
	public List<Prototype> geefAllePrototypesTerugZonderId();
	public Prototype geefPrototypeById(int prototypeId);
	public Prototype voegPrototypeToe(int id, Project project , String Formule);
	public void updatePrototype(Prototype p);
	public void deletePrototype(Prototype p);

}
