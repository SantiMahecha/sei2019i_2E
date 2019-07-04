package com.example.traductor.GUI.activities;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.traductor.R;
import com.example.traductor.business_logic.Globals;
import com.example.traductor.business_logic.controllers.LogInController;

public class MainActivity extends AppCompatActivity {

    private EditText mUserEditText;
    private EditText mPassEditText;
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For network connections in main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        mUserEditText = findViewById(R.id.ed_user);
        mPassEditText = findViewById(R.id.ed_pass);
        messageEditText = findViewById(R.id.message);
    }

    public void buttonFunction(View w){

        LogInController.LogInResult result = new LogInController(Globals.userRepo).logIn(mUserEditText.getText().toString(), mPassEditText.getText().toString());

        switch(result.result){
            case UNKNOWN_USER: messageEditText.setText("Usuario Desconocido");break;
            case BAD_PASSWORD: messageEditText.setText("Contraseña Incorrecta");break;
            case CORRECT: new TranslatorActivity();
        }
    }
}
