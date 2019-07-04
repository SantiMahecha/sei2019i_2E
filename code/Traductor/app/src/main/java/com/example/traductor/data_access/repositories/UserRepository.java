package com.example.traductor.data_access.repositories;

import android.util.Log;

import com.example.traductor.data_access.database.Database;
import com.example.traductor.data_access.models.User;
import com.j256.ormlite.dao.CloseableIterable;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;

public class UserRepository {

    private Dao<User, String> userDao;

    public UserRepository(Database database){
        try{
            userDao = DaoManager.createDao(database.getConnection(), User.class);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void create(User user){

        try{
            Log.i("Total", userDao.countOf() + "");
            userDao.create(user);
            Log.i("Total Final", userDao.countOf() + "");
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void update(User user){
        try{
            userDao.update(user);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public User getByNickname(String nickname){
        try{
            return userDao.queryForId(nickname);
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public void delete(User user){
        try{
            userDao.delete(user);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
