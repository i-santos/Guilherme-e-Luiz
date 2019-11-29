package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

public class UsuarioDAO {
    
    public static boolean inserirUsuario(Usuario u) {
        boolean sucesso = false;
        
        try (Connection connection = Conexao.abrirConexao()) {
            
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO lista_tarefas.usuario (email, senha) VALUES (?, ?)");
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                sucesso = true;
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return sucesso;
    }

    public static Usuario buscarUsuario(String email) {
        Usuario u = null;
        
        try (Connection connection = Conexao.abrirConexao()) {
            
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM lista_tarefas.usuario WHERE email = ?");
            stmt.setString(1, email);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt("id");
                String senha = rs.getString("senha");
                
                u = new Usuario();
                u.setId(id);
                u.setEmail(email);
                u.setSenha(senha);
                
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return u;
    }
    
}
