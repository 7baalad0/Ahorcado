package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    public static void juego(String[] args) {
        ArrayList<String> frases = new ArrayList<>(Arrays.asList(
                "Buenos dias"
        ));

        Random r = new Random();
        String fraseSecreta = frases
                .get(r.nextInt(0, frases.size()))
                .toLowerCase();

        StringBuilder fraseOculta = new StringBuilder();
        for (char c : fraseSecreta.toCharArray()) {
            if (c == ' ') {
                fraseOculta.append(' ');
            } else {
                fraseOculta.append('_');
            }
        }

        Scanner teclado = new Scanner(System.in);
        int intentos = 6;

        while (intentos > 0 && fraseOculta.toString().contains("_")) {
            System.out.println("Intentos restantes: " + intentos);
            System.out.println(fraseOculta);
            System.out.println("Introduce una letra: ");

            char letra = teclado.nextLine().toLowerCase().charAt(0);

            boolean acierto = false;
            for (int i = 0; i < fraseOculta.length(); i++) {
                if (fraseSecreta.charAt(i) == letra
                        && fraseOculta.charAt(i) == '_') {
                    acierto = true;
                } else {
                    acierto = false;
                }
            }

            if (acierto == false) {
                intentos--;
                System.out.println("Esa letra no está!");
            } else {
                System.out.println("Acierto!");
                for (int i = 0; i < fraseOculta.length(); i++) {
                    if (fraseSecreta.charAt(i) == letra
                            && fraseOculta.charAt(i) == '_') {
                        fraseOculta.append(letra);
                    }
                }
            }
        }

        if (fraseOculta.toString().contains("_")) {
            System.out.println("Has perdido. La frase era:");
        } else {
            System.out.println("Adivinaste la frase! Era: ");
        }
        System.out.println(fraseSecreta);
    }

}

