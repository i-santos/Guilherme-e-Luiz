/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Tarefa;

/**
 *
 * @author 04285763117
 */
public class TarefaDAO {
    
    public static boolean inserirTarefa(Tarefa t) {
        boolean inserida = false;
        
        try (Connection conn = Conexao.getConexao()) {
            
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO lista_tarefas.tarefa (titulo, finalizada, usuario_id) VALUES (?, ?, ?)");
            
            stmt.setString(1, t.getTitulo());
            stmt.setBoolean(2, false);
            stmt.setInt(3, t.getUsuarioId());
            
            int linhasAlteradas = stmt.executeUpdate();
            
            if (linhasAlteradas > 0) {
                inserida = true;
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return inserida;
    }
    
    public static ArrayList<Tarefa> pegarTarefasDoUsuario(int usuarioId) {
        ArrayList<Tarefa> tarefas = new ArrayList();
        
        try(Connection conn = Conexao.getConexao()) {
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM lista_tarefas.tarefa WHERE usuario_id = ?");
            
            stmt.setInt(1, usuarioId);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                boolean finalizada = rs.getBoolean("finalizada");
                
                Tarefa t = new Tarefa();
                t.setId(id);
                t.setTitulo(titulo);
                t.setFinalizada(finalizada);
                t.setUsuarioId(usuarioId);
                
                tarefas.add(t);
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return tarefas;
    }
    
}
