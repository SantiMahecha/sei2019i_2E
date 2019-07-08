package com.example.traductor.GUI.activities;


import android.os.Bundle;
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

import java.util.Arrays;

public class TranslatorActivity extends AppCompatActivity {
    private EditText translateEditText;
    private TextView translatedTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        Log.i("AAAAAAAAAAAAAAAAAAAAAAAA", "BBBBBBBBBBBBBBBBB");

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
            Text texto1 = new Text(translateEditText.getText().toString());


            translatedTextView.setText(Arrays.toString(texto1.separar()).replace(",", "\n\n\n")  //remove the commas
                    .replace("[", "")  //remove the right bracket
                    .replace("]", "")  //remove the left bracket
            );
        }

        return super.onOptionsItemSelected(item);
    }

}
