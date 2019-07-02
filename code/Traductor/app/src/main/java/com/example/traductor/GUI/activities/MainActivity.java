package com.example.traductor.GUI.activities;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.traductor.R;
import com.example.traductor.business_logic.Globals;
import com.example.traductor.business_logic.controllers.LogInController;

public class MainActivity extends AppCompatActivity {

    private EditText mUserEditText;
    private EditText mPassEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For network connections in main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        LogInController logInController = new LogInController(Globals.userRepo);
        LogInController.LogInResult logInResult = logInController.logIn("TestNickname3", "0000");

        Log.i("AAAAAAAAAAAAAAAAA", logInResult.result.toString());

        if(logInResult.result.equals(LogInController.LogInResultEnum.CORRECT)) Globals.loggedUser = logInResult.user;




    }

    // TODO poner decente esta vaina XD
    public static void buttonFunction(){
        new TranslatorActivity();
    }
}
