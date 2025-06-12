package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    public static void juego(String[] args) {
        ArrayList<String> frases = new ArrayList<>(Arrays.asList(
                "el perro corre",
                "ella canta bien",
                "el sol brilla",
                "la luna llena",
                "el niño ríe",
                "la flor crece",
                "mi amigo llega",
                "canta una canción",
                "baila con ritmo",
                "come pan caliente",
                "toma agua fría",
                "lee un libro",
                "abre la puerta",
                "mira el cielo",
                "juega con pelota",
                "corre muy rápido",
                "duerme en cama",
                "sube la escalera",
                "bebe jugo natural",
                "busca su sombrero",
                "lava los platos",
                "rompe una taza",
                "veo una película",
                "enciende la lámpara",
                "toca la guitarra",
                "ama su familia",
                "visita la playa",
                "compra una camisa",
                "prepara el desayuno",
                "lava el auto",
                "enciende la radio",
                "escribe una carta",
                "siente mucha alegría",
                "grita muy fuerte",
                "salta la cuerda",
                "cierra la ventana",
                "mueve la silla",
                "cruza la calle",
                "rompe el silencio",
                "pinta una pared",
                "repara la bicicleta",
                "camina al trabajo",
                "llega muy tarde",
                "vuelve a casa",
                "viaja en tren",
                "sueña con aventuras",
                "pesca en río",
                "sube a barco",
                "duerme profundamente hoy",
                "huele a flores",
                "cae la lluvia",
                "siente el viento",
                "recibe un regalo",
                "abre el paquete",
                "usa sombrero nuevo",
                "guarda sus cosas",
                "enciende el fuego",
                "enciende la estufa",
                "corta una manzana",
                "cambia la bombilla"
        ));


        Random r = new Random();
        String fraseSecreta = frases.get(r.nextInt(0, frases.size())).toLowerCase();

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
        ArrayList<Character> letrasincorrectas = new ArrayList<>();

        while (intentos > 0 && fraseOculta.toString().contains("_")) {
            System.out.println("Intentos restantes: " + intentos);
            System.out.println(fraseOculta);
            System.out.println("Letras probadas que no estaban: " + letrasincorrectas);

            System.out.println("Introduce una letra: ");
            char letra = teclado.nextLine().toLowerCase().charAt(0);

            if (letrasincorrectas.contains(letra) || fraseOculta.toString().contains(String.valueOf(letra))) {
                System.out.println("Ya has probado esa letra.");
                continue;
            }

            boolean acierto = false;
            for (int i = 0; i < fraseOculta.length(); i++) {
                if (fraseSecreta.charAt(i) == letra && fraseOculta.charAt(i) == '_') {
                    fraseOculta.setCharAt(i, letra);
                    acierto = true;
                }
            }

            if (acierto == false) {
                intentos--;
                letrasincorrectas.add(letra);
                System.out.println("Esa letra no está!");
            } else {
                System.out.println("Acierto!");
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

