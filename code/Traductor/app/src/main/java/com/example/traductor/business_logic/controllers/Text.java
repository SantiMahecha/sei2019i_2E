package com.example.traductor.business_logic.controllers;

import java.util.Arrays;
import java.util.LinkedList;

public class Text {
    String texto;

    public Text(String aTraducir) {
        texto = aTraducir;
    }

    public String[] separar() {
        return texto.split("\n");
    }

}