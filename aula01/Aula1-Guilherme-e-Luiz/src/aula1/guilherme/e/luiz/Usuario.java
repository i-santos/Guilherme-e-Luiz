package aula1.guilherme.e.luiz;

import java.util.Scanner;

public class Usuario {
    
    private String email;
    private String senha;
    
    public void atribuirEmail(String email) {
        this.email = email;
    }
    
    public void atribuirSenha(String senha) {
        this.senha = senha;
    }
    
    public String pegarEmail() {
        return email;
    }
    
    public String pegarSenha() {
        return senha;
    }

}
