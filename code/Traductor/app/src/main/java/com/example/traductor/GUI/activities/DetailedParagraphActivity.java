package com.example.traductor.GUI.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traductor.R;
import com.example.traductor.business_logic.Globals;
import com.example.traductor.business_logic.controllers.SaveHistoricController;
import com.example.traductor.business_logic.controllers.Text;
import com.example.traductor.business_logic.controllers.Translate_controller;
import com.j256.ormlite.stmt.query.In;

public class DetailedParagraphActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView toTranslateTv;
    private TextView translatedTv;
    private Spinner spChooseLanguage;
    private String languageSelected;
    private Translate_controller controller;
    private String paragraph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_paragraph);

        toTranslateTv = (TextView) findViewById(R.id.tv_untranslated);
        translatedTv = (TextView) findViewById(R.id.tv_translated_output);
        spChooseLanguage = (Spinner)findViewById(R.id.sp_lang_chooser);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spChooseLanguage.setAdapter(adapter);
        spChooseLanguage.setOnItemSelectedListener(this);

        controller = new Translate_controller(this);

        Intent intentStartedThis = getIntent();

        if(intentStartedThis != null){
            if(intentStartedThis.hasExtra(Intent.EXTRA_TEXT)){
                paragraph = intentStartedThis.getStringExtra(Intent.EXTRA_TEXT);
                toTranslateTv.setText(paragraph);
            }
        }
    }

    void buttonTranslate(View v){

        boolean canTraduceLanguaje = false;
        switch(languageSelected){
            case "en": canTraduceLanguaje = Globals.loggedUser.getRol().isEnglish(); break;
            case "es": canTraduceLanguaje = Globals.loggedUser.getRol().isSpanish(); break;
            case "fr": canTraduceLanguaje = Globals.loggedUser.getRol().isFrench(); break;
        }

        if(!canTraduceLanguaje){
            Toast.makeText(this, String.format("No puede traducir al lenguaje seleccionado"), Toast.LENGTH_LONG).show();
            return;
        }

        controller.getTranslateService();
        String lenEntrada = controller.Detector(paragraph);
        String salida = controller.translate_final(paragraph,lenEntrada,languageSelected);
        new SaveHistoricController().save(paragraph, salida, lenEntrada, languageSelected);
        translatedTv.setText(salida);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        languageSelected = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        languageSelected = "en";

    }
}
