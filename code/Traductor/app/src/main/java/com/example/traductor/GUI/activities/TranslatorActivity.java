package com.example.traductor.GUI.activities;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;



import com.example.traductor.R;
import com.example.traductor.business_logic.controllers.Text;
import com.example.traductor.business_logic.controllers.Translate_controller;


import java.util.Arrays;

public class TranslatorActivity extends AppCompatActivity {
    private EditText translateEditText;
    private TextView translatedTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        Log.i("AAAAAAAAAAAAAAAAAAAAAAA", "BBBBBBBBBBBBBBBBB");

        translateEditText = (EditText) findViewById(R.id.ed_translate_input);
        translatedTextView = (TextView) findViewById(R.id.tv_translated_output);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Use AppCompatActivity's method getMenuInflater to get a handle on the menu inflater */
        MenuInflater inflater = getMenuInflater();
        /* Use the inflater's inflate method to inflate our menu layout to this menu */
        inflater.inflate(R.menu.menu, menu);
        /* Return true so that the menu is displayed in the Toolbar */
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.translate_action) {


            if(!translateEditText.getText().equals(null)){
                Text texto = new Text(translateEditText.getText().toString());
                Translate_controller traductor = new Translate_controller(this);

                traductor.getTranslateService();
                String salida=traductor.translate_final(Arrays.toString(texto.separar()).replace(',','\n').replace('[',' ').replace(']',' '),"en");
                translatedTextView.setText(salida);

            }
            else{

            }
        }

        return super.onOptionsItemSelected(item);
    }

}
