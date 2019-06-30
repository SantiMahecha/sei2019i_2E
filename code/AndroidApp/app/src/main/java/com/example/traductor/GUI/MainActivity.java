package com.example.traductor.GUI;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.traductor.R;
import com.example.traductor.data_access.database.Database;
import com.example.traductor.data_access.models.User;
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

        User tmpUser = new User();
        tmpUser.setNickname("Test Nickname2");
        tmpUser.setPassword("0000");

        userRepo.create(tmpUser);

    }
}
