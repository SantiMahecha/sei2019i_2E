package com.example.traductor.data_access.database;

import com.example.traductor.data_access.models.Historic;
import com.example.traductor.data_access.models.Rol;
import com.example.traductor.data_access.models.User;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Database {



    private static final String HOST = "jdbc:mysql://10.203.146.28:3306/";


    private static final String DB_NAME = "traductordb";
    private static final String CONNECTION = HOST + DB_NAME;
    private static final String USER = "app";
    private static final String PASS = "0000";

    private boolean isConnected;
    private ConnectionSource connection;

    public Database(){
        try {
            connection = new JdbcConnectionSource(CONNECTION, USER, PASS);
            TableUtils.createTableIfNotExists(connection, User.class);
            TableUtils.createTableIfNotExists(connection, Rol.class);
            TableUtils.createTableIfNotExists(connection, Historic.class);
            isConnected = true;
        } catch (SQLException e) {
            e.printStackTrace();
            isConnected = false;
        }
    }

    public ConnectionSource getConnection(){
        return connection;
    }

    public boolean isConnected(){return isConnected;}
}
