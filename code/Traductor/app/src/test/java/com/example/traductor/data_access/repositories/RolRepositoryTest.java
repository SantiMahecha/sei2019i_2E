package com.example.traductor.data_access.repositories;

import com.example.traductor.data_access.database.Database;
import com.example.traductor.data_access.models.Rol;
import com.example.traductor.data_access.models.User;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RolRepositoryTest {

    @Test
    public void create() {
        Rol testRol = new Rol();
        testRol.setName("testRol");
        new RolRepository(new Database()).create(testRol);
    }

    @Test
    public void update() {
        RolRepository rolRepo = new RolRepository(new Database());

        Rol testRol = rolRepo.getById(11);
        testRol.setName("testRolUpdated");
        rolRepo.update(testRol);
    }

    @Test
    public void getById() {
        Rol testRol = new RolRepository(new Database()).getById(11);
        System.out.println(testRol);
    }

    @Test
    public void delete() {
        RolRepository rolRepo = new RolRepository(new Database());
        Rol testRol = rolRepo.getById(11);
        rolRepo.delete(testRol);
    }

    @Test
    public void getAll() {
        List<Rol> roles = new RolRepository(new Database()).getAll();

        for (Rol rol: roles) {
            System.out.println(rol);
        }
    }

    @Test
    public void refreshUserRol() {
        Database base = new Database();

        User testUser = new UserRepository(base).getByNickname("admin");
        new RolRepository(base).refreshUserRol(testUser);

        System.out.println(testUser.getRol());
    }
}