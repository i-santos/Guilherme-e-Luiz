package aula1.guilherme.e.luiz.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Aula1GuilhermeELuizArrayList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayInt = new ArrayList();
        
        boolean executando = true;
        
        while(executando) {
            
            System.out.println("[1] Adicionar um novo número");
            System.out.println("[2] Listar todos os valores cadastrados");
            System.out.println("[3] Encerrar o programa");
            System.out.print("Digite a opção: ");
            int opcao = sc.nextInt();
            
            switch(opcao) {
                case 1: {
                    System.out.print("Digite o novo número: ");
                    int i = sc.nextInt();
                    
                    arrayInt.add(i);
                    
                    break;
                }
                
                case 2: {
                    
                    // size = 2 (10, 20)
                    // c = 0 / 1 / 2
                    // 1º laço -> OK
                    // 2º laço -> OK
                    for(int c = 0; c < arrayInt.size(); c++) {
                        Integer elemento = arrayInt.get(c);
                        System.out.println("Valor do elemento [" + c + "]: " + elemento);
                    }
                    break;
                }
                
                case 3: {
                    executando = false;
                    break;
                }
                
            }
            
        }
    }
    
}
