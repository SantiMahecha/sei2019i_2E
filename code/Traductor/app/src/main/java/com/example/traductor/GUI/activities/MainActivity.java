package com.example.traductor.GUI.activities;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        //Para trabajar sin base de datos COMENTAR desde aqui
        ///*
        LogInController.LogInResult result = new LogInController().logIn(mUserEditText.getText().toString(), mPassEditText.getText().toString());

        switch(result.result){
            case BAD_PASSWORD:
                Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show(); break;
            case UNKNOWN_USER:
                Toast.makeText(this, "Usuario desconocido", Toast.LENGTH_SHORT).show(); break;
            case CORRECT:
                Toast.makeText(this, "Iniciando sesións", Toast.LENGTH_SHORT).show();
                Globals.loggedUser = result.user;
                Globals.rolRepo.refreshUserRol(Globals.loggedUser);
                startActivity(new Intent(this, TranslatorActivity.class));
                break;
        }
        //*/
        //Para trabajar sin base de datos COMENTAR hasta aqui

        //Descomentar esto para trabajar sin base de datos
        //startActivity(new Intent(this, TranslatorActivity.class));


    }
}
