package com.example.traductor.data_access.repositories;

import android.util.Log;

import com.example.traductor.data_access.database.Database;
import com.example.traductor.data_access.models.Admin;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;

public class AdminRepository {
    private Dao<Admin, String> adminDao;

    public AdminRepository(Database database){
        try{
            adminDao = DaoManager.createDao(database.getConnection(), Admin.class);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void create(Admin Admin){

        try{
            Log.i("Total", adminDao.countOf() + "");
            adminDao.create(Admin);
            Log.i("Total Final", adminDao.countOf() + "");
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void update(Admin Admin){
        try{
            adminDao.update(Admin);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public Admin getByNickname(String nickname){
        try{
            return adminDao.queryForId(nickname);
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public void delete(Admin Admin){
        try{
            adminDao.delete(Admin);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}


