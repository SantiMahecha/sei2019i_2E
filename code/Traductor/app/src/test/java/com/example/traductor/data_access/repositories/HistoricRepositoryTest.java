package com.example.traductor.data_access.repositories;

import com.example.traductor.data_access.database.Database;
import com.example.traductor.data_access.models.Historic;
import com.example.traductor.data_access.models.User;
import com.google.cloud.Identity;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HistoricRepositoryTest {

    @Test
    public void create() {
        Database db = new Database();
        HistoricRepository repo = new HistoricRepository(db);
        UserRepository userRepo = new UserRepository(db);
        User user = userRepo.getByNickname("admin");
        Historic newHistoric = new Historic();
        newHistoric.setUser(user);
        newHistoric.setOriginLanguaje("en");
        newHistoric.setDestinyLanguaje("es");
        newHistoric.setToTraduce("Hello3");
        newHistoric.setTraduction("Holá3");

        repo.create(newHistoric);
    }

    @Test
    public void update() {

    }

    @Test
    public void getByUser() {
        Database db = new Database();
        HistoricRepository repo = new HistoricRepository(db);
        UserRepository userRepo = new UserRepository(db);
        User user = userRepo.getByNickname("admin");
        List<Historic> newHistoric = repo.getByUser(user);
        for (Historic historic: newHistoric ) {
            System.out.println(historic.getTraduction() + ">>" + historic.getToTraduce());
        }
    }

    @Test
    public void delete() {
    }
}