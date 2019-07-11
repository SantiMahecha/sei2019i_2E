package com.example.traductor.business_logic.controllers;

import com.google.cloud.translate.*;

public class Translate_controller {

    public String Result;
    public Translate_controller() {
        Result = new String();

    }

    public void translate(String textToTranslate, String targetLanguage) {
        try {

            TranslateOptions options = TranslateOptions.newBuilder()
                    .setApiKey( "AIzaSyCx2ZmmyniRQkOvJeFWMFAxguLTkauTrMU" )
						.build();
            Translate trService = options.getService();
            Translation translation = trService.translate(textToTranslate, Translate.TranslateOption.targetLanguage(targetLanguage));
            Result =translation.getTranslatedText();
        }
        catch(Exception e) {
            System.out.println("crack esto falllooooooooooooo");
        }
    }
}
