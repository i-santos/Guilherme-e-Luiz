package listadetarefas;

import java.util.ArrayList;

public class Usuario {
    
    private String email;
    private String senha;
    private ArrayList<Tarefa> tarefas;
    
    public Usuario() {
        this.tarefas = new ArrayList();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    
    public void addTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }    
    
}
