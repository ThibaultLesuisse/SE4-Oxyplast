package be.odisee.oxyplast.dao;

import org.springframework.stereotype.Repository;

import be.odisee.oxyplast.domain.Rol;

@Repository("rolDao")
public class RolHibernateDao extends HibernateDao implements RolDao {

    public Rol saveRol(Rol rol) {
        sessionSaveObject(rol);
        return rol;
    }

    public Rol getRolById(int id) {
        return (Rol) sessionGetObjectById("Rol", id);
    }

    public Rol getRolByUserid(String userid) {

        String qstr = "from Rol where usernaam = :userid";
        String parameter = "userid";
        String value = userid;

        return (Rol) sessionGetObjectBy1StringParameterNamedQuery(qstr,parameter,value);
    }


}
