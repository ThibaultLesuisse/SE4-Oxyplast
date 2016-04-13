package be.odisee.oxyplast.dao;

import be.odisee.oxyplast.domain.Rol;

public interface RolDao {

    public Rol saveRol(Rol rol);

    public Rol getRolById(int id);

    public Rol getRolByUserid(String userid);

}
