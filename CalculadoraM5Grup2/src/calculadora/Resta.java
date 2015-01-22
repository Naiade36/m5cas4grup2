package calculadora;

import java.util.Scanner;

public class Resta {
    private int num1;
    private int num2;
    
    public Resta(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    public String operacio() {
        if (num2 > 0 ? num1 < Integer.MIN_VALUE + num2
                : num1 > Integer.MAX_VALUE + num2) {
            return "Error";
        }
        
        return (num1 - num2) + ".";
    }
    
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            while (entrada.hasNextLine()) {
                // la entrada ha de ser del estil "numero1 signe numero2" tot el
                String cadena = entrada.nextLine();
                
                try {
                    if(cadena.charAt(0) == '|') continue; // comentaris
                    
                    // partim la entrada en 3 parts, numero 1, signe i numero 2
                    String [] parts = cadena.split(" ");
                    
                    // mirem que la entrada sigue valida
                    if (parts.length > 3) System.out.println("Error"); 
                    else if (parts.length < 3) System.out.println("Error");
                    else if (parts[1].length() > 1) System.out.println("Error");
                    // operem
                    else {
                        int num1 = Integer.parseInt(parts[0]);
                        int num2 = Integer.parseInt(parts[2]);
                        
                        Resta resta = new Resta(num1, num2);
                        System.out.println(resta.operacio());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error"); 
                }
            }
        }
    }
}
