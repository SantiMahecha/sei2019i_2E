package com.example.traductor.data_access.database;

import com.example.traductor.data_access.models.User;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Database {

    private static final String HOST = "jdbc:mysql://192.168.0.3:3306/";
    private static final String DB_NAME = "traductordb";
    private static final String CONNECTION = HOST + DB_NAME;
    private static final String USER = "app";
    private static final String PASS = "0000";

    private ConnectionSource connection;

    public Database(){
        try {
            connection = new JdbcConnectionSource(CONNECTION, USER, PASS);
            TableUtils.createTableIfNotExists(connection, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ConnectionSource getConnection(){
        return connection;
    }
}
