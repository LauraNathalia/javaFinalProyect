/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.*;

/**
 *
 * @author Laura Nathalia
 */
public class PlateChecker {
    public static boolean validacionCarro(String placa) {
        // Validar que la placa sea en formato xxx111
        if (placa.length() != 6) {
            return false;
        }

        List<Character> lista = new ArrayList<>();
        for (char letra : placa.toCharArray()) {
            lista.add(letra);
        }

        String num = "0123456789";
        String letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int v = 0; // Contador de números
        for (int i = 3; i < 6; i++) {
            for (int g = 0; g < num.length(); g++) {
                if (lista.get(i) == num.charAt(g)) {
                    v++;
                }
            }
        }

        int y = 0; // Contador de letras
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < letra.length(); k++) {
                if (lista.get(j) == letra.charAt(k)) {
                    y++;
                }
            }
        }

        return (y == 3 && v == 3);
    }

    public static boolean validacionMoto(String placa) {
        // Validar que la placa sea en formato xxx11x
        if (placa.length() != 6) {
            return false;
        }

        List<Character> lista = new ArrayList<>();
        for (char letra : placa.toCharArray()) {
            lista.add(letra);
        }

        String num = "0123456789";
        String letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int v = 0; // Contador de números
        for (int i = 3; i < 5; i++) {
            for (int g = 0; g < num.length(); g++) {
                if (lista.get(i) == num.charAt(g)) {
                    v++;
                }
            }
        }

        int y = 0; // Contador de letras
        for (int j = 0; j < 4; j++) {
            if (j == 3) {
                j = 5; // Ajuste, ya que en la clase anterior 'j' no debe incrementar a 4
            }
            for (int k = 0; k < letra.length(); k++) {
                if (lista.get(j) == letra.charAt(k)) {
                    y++;
                }
            }
        }

        return (y == 4 && v == 2);
    }
}
