package diversao03;

import java.util.Scanner;

/*
6-PROBLEMA: Entrar com dois números e na sequência uma operação aritmética. O resultado da operação sobre os dois números deve ser mostrado.
DADOS DE ENTRADA: OPERANDO1(real), OPERANDO2 (real) e OPERADOR (caracter)
DADOS DE SAÍDA: RESULTADO (real)
Atenção: para fins de simplificação não são mostradas mensagens para as entradas de dados
*/

public class Atv06 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
    
        double operando1;
        double operando2;
        String operador;
        double resultado;

        System.out.println("Informar o 1º número: ");
        operando1 = sc.nextDouble();
    
        System.out.println("Informar o 2º número: ");
        operando2 = sc.nextDouble();
        
        System.out.println("Informar operador: ");
        operador = sc.next();
    
        if (operador.equals("+")) {
            resultado = operando1 + operando2;
            System.out.println("Resultado: " + resultado);
        } else if (operador.equals("-")) {
            resultado = operando1 - operando2;
            System.out.println("Resultado: " + resultado);
        } else if (operador.equals("*")) {
            resultado = operando1 * operando2;
            System.out.println("Resultado: " + resultado);
        } else if (operador.equals("/")) {
            resultado = operando1 / operando2;
            System.out.println("Resultado: " + resultado);
        } else {
            System.out.println("Operação inválida!");
        }
        sc.close();
    }
}
