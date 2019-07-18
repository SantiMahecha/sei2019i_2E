package com.example.traductor.GUI.activities;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.traductor.R;
import com.example.traductor.business_logic.Globals;
import com.example.traductor.business_logic.controllers.LogInController;
import com.example.traductor.business_logic.controllers.SaveHistoricController;
import com.example.traductor.data_access.models.Historic;
import com.example.traductor.data_access.models.Rol;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static com.example.traductor.business_logic.controllers.LogInController.LogInResultEnum.BAD_PASSWORD;
import static com.example.traductor.business_logic.controllers.LogInController.LogInResultEnum.CORRECT;
import static com.example.traductor.business_logic.controllers.LogInController.LogInResultEnum.UNKNOWN_USER;

public class MainActivity extends AppCompatActivity {

    private EditText mUserEditText;
    private EditText mPassEditText;
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For network connections in main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        mUserEditText = (EditText) findViewById(R.id.ed_user);
        mPassEditText = (EditText) findViewById(R.id.ed_pass);
        messageTextView = (TextView) findViewById(R.id.message);

    }

    public void buttonFunction(View w){
/*
        LogInController.LogInResult result = new LogInController().logIn(mUserEditText.getText().toString(), mPassEditText.getText().toString());
       //LogInController.LogInResultEnum result = LogInController.LogInResultEnum.CORRECT;

       switch(result.result){
            case UNKNOWN_USER: messageTextView.setText("Usuario Desconocido");break;
            case BAD_PASSWORD: messageTextView.setText("Contraseña Incorrecta");break;
            case CORRECT:
                Globals.loggedUser = result.user;

                startActivity(new Intent(this, TranslatorActivity.class));
<<<<<<< HEAD
        }*/
        startActivity(new Intent(this, TranslatorActivity.class));


    }
}
