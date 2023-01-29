package tech.ada.testes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeitorTeclado {

    public int getNumero(String frase) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(frase);
        try {
            return entrada.nextInt();
        } catch (InputMismatchException e) {
            return getNumero(frase);
        }
    }
}
