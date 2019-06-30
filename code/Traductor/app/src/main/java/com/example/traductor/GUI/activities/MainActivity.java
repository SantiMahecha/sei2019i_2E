package com.example.traductor.GUI.activities;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.traductor.R;
import com.example.traductor.data_access.database.Database;
import com.example.traductor.data_access.models.Rol;
import com.example.traductor.data_access.models.User;
import com.example.traductor.data_access.repositories.RolRepository;
import com.example.traductor.data_access.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For network connections in main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Database database = new Database();

        UserRepository userRepo = new UserRepository(database);
        RolRepository rolRepo = new RolRepository(database);


        Rol rol = rolRepo.getById(1); // new Rol();
        //rol.setName("Rol#1");

        //rolRepo.create(rol);
        //Log.i("AAAAAAAAAAAAAA", rol.getId() + "");

        User tmpUser = new User();
        tmpUser.setNickname("TestNickname3");
        tmpUser.setPassword("0000");
        tmpUser.setRol(rol);

        userRepo.create(tmpUser);
        Log.i("AAAAAAAAAAAAAA", userRepo.getByNickname("TestNickname3").getPassword());

    }
}
