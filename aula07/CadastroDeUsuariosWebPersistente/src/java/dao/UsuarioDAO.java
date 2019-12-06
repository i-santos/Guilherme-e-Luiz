package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

public class UsuarioDAO {

    public static boolean inserirUsuario(Usuario u) {
        boolean sucesso = false;

        try (Connection connection = Conexao.abrirConexao()) {

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO cadastro_usuarios.usuario (email, senha) VALUES (?, ?)");

            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public static ArrayList<Usuario> pegarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList();

        try (Connection connection = Conexao.abrirConexao()) {

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cadastro_usuarios.usuario");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                
                Usuario u = new Usuario();
                u.setId(id);
                u.setEmail(email);
                u.setSenha(senha);
                
                usuarios.add(u);
            }

        } catch (SQLException e) {

        }

        return usuarios;
    }
    
    public static Usuario procurarUsuarioPorEmail(String email) {
        Usuario usuario = null;
        
        try (Connection connection = Conexao.abrirConexao()) {
            
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cadastro_usuarios.usuario WHERE email = ?");
            
            stmt.setString(1, email);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                
                int id = rs.getInt("id");
                String senha = rs.getString("senha");
                
                usuario = new Usuario();
                usuario.setId(id);
                usuario.setEmail(email);
                usuario.setSenha(senha);
                
            }
            
            
        } catch(SQLException e) {
            
        }
        
        return usuario;        
    }
    
    public static boolean atualizarUsuario(Usuario u) {
        boolean sucesso = false;
        
        try (Connection connection = Conexao.abrirConexao()) {
            
            PreparedStatement stmt = connection.prepareStatement("UPDATE cadastro_usuarios.usuario SET email = ?, senha = ? WHERE id = ?");
            
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, u.getId());
            
            int linhasAlteradas = stmt.executeUpdate();
            
            if (linhasAlteradas > 0) {
                sucesso = true;
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return sucesso;
    }
}
