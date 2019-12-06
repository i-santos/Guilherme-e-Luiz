package aula1.guilherme.e.luiz;

import java.util.Scanner;

public class Aula1GuilhermeELuiz {
    
    public static void main(String[] args) {
        
        Usuario u = new Usuario();
        Usuario u2 = new Usuario();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o email: ");
        String email = sc.nextLine();
        
        System.out.print("Digite a senha: ");
        String senha = sc.nextLine();
        
        u.atribuirEmail(email);
        u.atribuirSenha(senha);
        
        System.out.print("Digite o email do u2: ");
        email = sc.nextLine();
        System.out.print("Digite a senha do u2: ");
        senha = sc.nextLine();
        
        u2.atribuirEmail(email);
        u2.atribuirSenha(senha);
        
        System.out.println("Email: " + u.pegarEmail());
        System.out.println("Senha: " + u.pegarSenha());
        System.out.println("Email: " + u2.pegarEmail());
        System.out.println("Senha: " + u2.pegarSenha());
        
    }
    
}
