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

import com.example.traductor.business_logic.controllers.Translate_controller;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import com.example.traductor.R;
import com.example.traductor.business_logic.controllers.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class TranslatorActivity extends AppCompatActivity {
    private EditText translateEditText;
    private TextView translatedTextView;
    Translate translate = TranslateOptions.getDefaultInstance().getService();
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
                //String txt="t e   q u i e r o";


                getTranslateService();

                System.out.println("pedro: "+Arrays.toString(texto.separar()).replace(',','\n').replace('[',' ').replace(']',' '));
            translatedTextView.setText(translate_final(Arrays.toString(texto.separar()).replace(',',' ').replace('[',' ').replace(']',' '),"en"));
                //translatedTextView.setText(translate_final(txt,"en"));
                //translatedTextView.setText(Arrays.toString(texto.separar()).replace(',','\n').replace('[',' ').replace(']',' '));


            }
            else{

            }
        }

        return super.onOptionsItemSelected(item);
    }
    public void getTranslateService() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try (InputStream is = getResources().openRawResource(R.raw.ingesoft)) {

            //Get credentials:
            final GoogleCredentials myCredentials = GoogleCredentials.fromStream(is);

            //Set credentials and get translate service:
            TranslateOptions translateOptions = TranslateOptions.newBuilder().setCredentials(myCredentials).build();
            translate = translateOptions.getService();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
    }

    public String translate_final(String texto,String targetLanguage) {

        //Get input text to be translated:

        Translation translation = translate.translate(texto,Translate.TranslateOption.sourceLanguage("es"), Translate.TranslateOption.targetLanguage(targetLanguage));
        return translation.getTranslatedText();

        //Translated text and original text are set to TextViews:


    }
}
