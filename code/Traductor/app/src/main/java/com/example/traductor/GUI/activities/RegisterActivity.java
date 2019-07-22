package com.example.traductor.GUI.activities;


import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.traductor.R;
import com.example.traductor.business_logic.controllers.RegisterController;

public class RegisterActivity extends AppCompatActivity {
    private EditText mUserEditText;
    private EditText mPassEditText;
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //For network connections in main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        mUserEditText = (EditText) findViewById(R.id.ed_user);
        mPassEditText = (EditText) findViewById(R.id.ed_pass);
        messageTextView = (TextView) findViewById(R.id.message);



    }

    public void buttonFunction(View w){

        RegisterController.RegisterResult result = new RegisterController().register(mUserEditText.getText().toString(), mPassEditText.getText().toString());


        switch(result.result){
            case USER_EXISTS: messageTextView.setText("Usuario ya existe");break;
            case CORRECT: messageTextView.setText("Creado exitosamente ");break;
        }

    }


}
