package com.example.traductor.GUI.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.traductor.R;
import com.example.traductor.business_logic.controllers.Text;
import com.j256.ormlite.stmt.query.In;

public class DetailedParagraphActivity extends AppCompatActivity {
    private TextView toTranslateTv;
    private TextView translatedTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_paragraph);

        toTranslateTv = (TextView) findViewById(R.id.tv_untranslated);
        translatedTv = (TextView) findViewById(R.id.tv_translated_output);

        Intent intentStartedThis = getIntent();

        if(intentStartedThis != null){
            if(intentStartedThis.hasExtra(Intent.EXTRA_TEXT)){
                String paragraph = intentStartedThis.getStringExtra(Intent.EXTRA_TEXT);
                toTranslateTv.setText(paragraph);
            }
        }
    }

    void buttonTranslate(View v){


    }
}
