package diversao03;

import java.util.Scanner;

/*
5-PROBLEMA: Controlar o acesso a uma porta usando uma senha pré-configurada no sistema.
DADO DE ENTRADA: SENHA (variável alfanumérica)
DADO DE SAÌDA: porta aberta (simulado com msg "PORTA ABERTA") ou mensagem de "SENHA NAO CONFERE"
VARIÁVEIS: SENHA (tipo alfanumérica)
*/

public class Atv05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informar a senha: ");
        String senha = sc.nextLine();

        if (senha.equals("1234") ) {
            System.out.println("PORTA ABERTA");
        }else{
            System.out.println("SENHA NÃO CONFERE");
        }

        sc.close();
    }
}
