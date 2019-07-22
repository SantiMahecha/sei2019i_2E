package com.example.traductor.business_logic.controllers;

import java.util.Arrays;
import java.util.LinkedList;

public class Text {

    private String toTranslate;

    public Text(String aTraducir) {
        toTranslate = aTraducir;
    }

    public String[] separar() {
        return toTranslate.split("\n");
    }

}