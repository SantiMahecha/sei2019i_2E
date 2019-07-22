package com.example.traductor.business_logic.controllers;

import android.content.Context;
import android.os.StrictMode;

import com.example.traductor.R;
import com.example.traductor.business_logic.Globals;
import com.example.traductor.data_access.models.User;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.*;


import java.io.IOException;
import java.io.InputStream;

public class Translate_controller {

    public String Result;
    Context context;
    Translate translate;
    public Translate_controller(Context context1) {
        this.context=context1;
        translate = TranslateOptions.getDefaultInstance().getService();
    }

    public void getTranslateService() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try (InputStream is = context.getResources().openRawResource(R.raw.ingesoft)) {

            //Get credentials:
            final GoogleCredentials myCredentials = GoogleCredentials.fromStream(is);

            //Set credentials and get translate service:
            TranslateOptions translateOptions = TranslateOptions.newBuilder().setCredentials(myCredentials).build();
            translate = translateOptions.getService();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
    }

    public String translate_final(String texto,String originLenguaje,String targetLanguage) {

        //Get input text to be translated:
        if(originLenguaje.equals(targetLanguage)){
            return "son el mismo lenguaje no tiene logica";
        } else {
            Translation translation = translate.translate(texto, Translate.TranslateOption.sourceLanguage(originLenguaje), Translate.TranslateOption.targetLanguage(targetLanguage));
            return translation.getTranslatedText();
        }

    }

    public String Detector(String texto){

      return  translate.detect(texto).getLanguage();

    }


}


