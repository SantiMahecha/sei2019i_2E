package com.example.traductor.GUI.activities;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traductor.R;
import com.example.traductor.business_logic.controllers.SetRoleController;

public class SetRoleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText mUserEditText;
    private Spinner roles;
    private int selectedRol = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setrole);
        roles = (Spinner) findViewById(R.id.role_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opc_roles, R.layout.support_simple_spinner_dropdown_item);
        roles.setAdapter(adapter);
        roles.setOnItemSelectedListener(this);

        mUserEditText = (EditText) findViewById(R.id.ed_user);

    }

   public void buttonFunction(View w) {
        String nickname = mUserEditText.getText().toString();

        SetRoleController.SetRoleResult result = new SetRoleController().setRole(nickname, selectedRol);
        switch(result.result){
            case UNKNOWN_USER:
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_LONG).show(); break;
            case UNKNOWN_ROL:
                Toast.makeText(this, "Rol no encontrado", Toast.LENGTH_LONG).show(); break;
            case CORRECT:
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show(); break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedRol = position+1;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

