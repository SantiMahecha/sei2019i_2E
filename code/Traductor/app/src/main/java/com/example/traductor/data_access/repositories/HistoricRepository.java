package com.example.traductor.data_access.repositories;

import com.example.traductor.data_access.database.Database;
import com.example.traductor.data_access.models.Historic;
import com.example.traductor.data_access.models.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;
import java.util.List;

public class HistoricRepository {
    private Dao<Historic, Long> historicDao;

    public HistoricRepository(Database database){
        try{
            historicDao = DaoManager.createDao(database.getConnection(), Historic.class);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void create(Historic historic){

        try{
            historicDao.create(historic);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void update(Historic historic){
        try{
            historicDao.update(historic);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public List<Historic> grtByUser(User user){
        try{
            PreparedQuery<Historic> query = historicDao.queryBuilder().where().eq(Historic.USER_FIELD_NAME, user.getNickname()).prepare();
            return historicDao.query(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public void delete(Historic historic){
        try{
            historicDao.delete(historic);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
