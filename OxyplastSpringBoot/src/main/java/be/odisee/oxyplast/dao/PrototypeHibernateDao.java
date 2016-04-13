package be.odisee.oxyplast.dao;

import java.util.List;

import be.odisee.oxyplast.domain.Aanvraag;
import be.odisee.oxyplast.domain.Project;
import be.odisee.oxyplast.domain.Prototype;

public class PrototypeHibernateDao extends HibernateDao implements PrototypeDao {
	@Override
	public Prototype savePrototype(int id, int projectid, String formule) {
		Prototype p = new Prototype(id,projectid, formule);
		sessionSaveObject(p);
		return p;
	}

	@Override
	public Prototype getPrototypeById(int id) {
		return (Prototype) sessionGetObjectById("Prototype", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prototype> getAllPrototypes() {
		return (List<Prototype>) sessionGetAllObjects("Prototype");
	}

	@Override
	public void updatePrototype(Prototype p) {
		sessionUpdateObject(p);
		System.out.println("DEBUG DAO update + naam: "+p.getFormule());
		
	}

	@Override
	public void deletePrototype(Prototype p) {
		sessionDeleteObject(p);
		
	}

}