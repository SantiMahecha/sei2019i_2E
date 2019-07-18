package com.example.traductor.business_logic.controllers;

import com.example.traductor.business_logic.Globals;
import com.example.traductor.data_access.models.Historic;

public class SaveHistoricController {

    public SaveHistoricController(){}

    public Historic save(String toTraduce, String traduction, String languaje){
        Historic historic = new Historic();
        historic.setIdioma(languaje);
        historic.setToTraduce(toTraduce);
        historic.setTraduction(traduction);
        historic.setUser(Globals.loggedUser);

        Globals.historicRepo.create(historic);

        return historic;

    }

}
