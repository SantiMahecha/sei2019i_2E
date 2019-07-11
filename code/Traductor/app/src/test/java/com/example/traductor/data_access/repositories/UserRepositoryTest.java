package com.example.traductor.data_access.repositories;

import android.util.Log;

import com.example.traductor.data_access.database.Database;
import com.example.traductor.data_access.models.Rol;
import com.example.traductor.data_access.models.User;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    @Test
    public void create() {
        User testUser = new User();
        Database base = new Database();
        Rol testRol = new RolRepository(base).getById(1);

        testUser.setRol(testRol);
        testUser.setPassword("0000");
        testUser.setNickname("testUser");
        testUser.setAdmin(false);

       new UserRepository(base).create(testUser);

    }

    @Test
    public void update() {

        UserRepository userRepo = new UserRepository(new Database());
        User testUser = userRepo.getByNickname("testUser");
        testUser.setPassword("0011");
        userRepo.update(testUser);
    }

    @Test
    public void getByNickname() {
        User testUser = new UserRepository(new Database()).getByNickname("testUser");
        System.out.println(testUser);
    }

    @Test
    public void delete() {
        UserRepository userRepo = new UserRepository(new Database());
        User testUser = userRepo.getByNickname("testUser");
        userRepo.delete(testUser);
    }

    @Test
    public void getAll() {
        List<User> users = new UserRepository(new Database()).getAll();
        for (User user: users) {
            System.out.println(user);
        }
    }
}