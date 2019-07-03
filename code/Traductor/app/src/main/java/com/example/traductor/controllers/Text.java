package com.example.traductor.controllers;

import java.util.Arrays;

public class Text {

    char[] texto;
    String[] textos;


    public Text(String aTraducir) {


        texto = aTraducir.toCharArray();
        textos = new String[100];

    }

    public String[] separar() {

        int indexy = 0;
        int indexx = 0;
        int i = 0;
        char[] a = new char[texto.length];

        while (i < texto.length) {

            if (texto[i] == '\n') {
                a[indexx] = '.';
                System.out.println(Arrays.toString(Arrays.copyOf(a, indexx)));
                textos[indexy] = Arrays.toString(Arrays.copyOf(a, indexx)).replace(",", "");
                a = new char[texto.length];

                indexy++;
                indexx = 0;
                i++;

            } else {
                System.out.println(texto[i]);
                a[indexx] = texto[i];
                System.out.println(Arrays.toString(a));
                indexx++;
                i++;


                if (i == texto.length) {

                    System.out.println(Arrays.toString(Arrays.copyOf(a, indexx)));
                    textos[indexy] = Arrays.toString(Arrays.copyOf(a, indexx)).replace(",", "");
                    a = new char[texto.length];

                    indexy++;
                    indexx = 0;
                    i++;

                }
            }

        }

        return textos;
    }

}