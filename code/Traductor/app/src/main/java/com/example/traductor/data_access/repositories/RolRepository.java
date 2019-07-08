package com.example.traductor.data_access.repositories;

import android.util.Log;

import com.example.traductor.data_access.database.Database;
import com.example.traductor.data_access.models.Rol;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.List;

public class RolRepository {

    private Dao<Rol, Long> rolDao;

    public RolRepository(Database database){
        try{
            rolDao = DaoManager.createDao(database.getConnection(), Rol.class);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void create(Rol rol){

        try{
            rolDao.create(rol);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void update(Rol rol){
        try{
            rolDao.update(rol);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public Rol getById(long id){
        try{
            return rolDao.queryForId(id);
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public void delete(Rol rol){
        try{
            rolDao.delete(rol);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public List<Rol> getAll(){
        try{
            return rolDao.queryForAll();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

}
