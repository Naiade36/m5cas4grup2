package calculadoram5grup2;

import calculadora.Divisio;
import calculadora.Resta;
import calculadora.Residu;
import calculadora.Suma;
import calculadora.Multiplicacio;
import java.util.Scanner;

public class CalculadoraM5Grup2 {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            while (entrada.hasNextLine()) {
                // la entrada ha de ser del estil "numero1 signe numero2" tot el
                String cadena = entrada.nextLine();
                
                try {
                    if(cadena.charAt(0) == '|') {
                        continue; // comentaris
                    }
                    
                    // partim la entrada en 3 parts, numero 1, signe i numero 2
                    String [] parts = cadena.split(" ");
                    
                    // mirem que la entrada sigue valida
                    if (parts.length > 3) {
                        System.out.println("Error");
                    } else if (parts.length < 3) {
                        System.out.println("Error");
                    } else if (parts[1].length() > 1) {
                        System.out.println("Error");
                    } // operem
                    else {
                        int num1 = Integer.parseInt(parts[0]);
                        int num2 = Integer.parseInt(parts[2]);
                        
                        switch (parts[1].charAt(0)){
                            case '+':
                                Suma suma = new Suma(num1, num2);
                                System.out.println(suma.operacio());
                                break;
                            case '-':
                                Resta resta = new Resta(num1, num2);
                                System.out.println(resta.operacio());
                                break;
                            case '*':
                                Multiplicacio multiplicacio = new Multiplicacio(num1, num2);
                                System.out.println(multiplicacio.operacio());
                                break;
                            case '/':
                                Divisio divisio = new Divisio(num1, num2);
                                System.out.println(divisio.operacio());
                                break;
                            case '%':
                                Residu residu = new Residu(num1, num2);
                                System.out.println(residu.operacio());
                                break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error"); 
                }
            }
        }
    }
}