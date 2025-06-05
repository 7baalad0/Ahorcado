package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Juego {
    public static void juego(String[] args) {
    ArrayList<String> frases = new ArrayList<>(Arrays.asList(
            "Buenos días",
            "Programacion",
            "Sistemas informaticos",
            "Periodo de recuperacion"
    ));
        Random r = new Random();
        String fraseSecreta = frases.get(r.nextInt(0, (frases.size()))).toLowerCase();

        StringBuilder fraseOculta = new StringBuilder();
        for (char c : fraseSecreta.toCharArray()) {
        if (c == ' ') {
            fraseOculta.append(' ');
        } else {
            fraseOculta.append('_');
        }
    }
}
}
