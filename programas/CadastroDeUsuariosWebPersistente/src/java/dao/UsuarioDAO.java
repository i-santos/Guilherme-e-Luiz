package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {

    public static boolean inserirUsuario(Usuario u) {

        boolean inserido = false;

        try (Connection conn = Conexao.getConexao()) {

            PreparedStatement stmt = conn.prepareCall("INSERT INTO cadastro_usuarios.usuario (email, senha) VALUES (?, ?)");

            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {
                inserido = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inserido;
    }

    public static ArrayList<Usuario> pegarUsuarios() {
        ArrayList<Usuario> _usuarios = new ArrayList();

        try (Connection conn = Conexao.getConexao()) {

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cadastro_usuarios.usuario");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                u.setId(id);
                u.setEmail(email);
                u.setSenha(senha);

                _usuarios.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _usuarios;
    }

    public static Usuario procurarUsuarioPorEmail(String email) {

        Usuario u = null;

        try (Connection conn = Conexao.getConexao()){

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cadastro_usuarios.usuario WHERE email = ?");

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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    public static boolean alterarUsuario(Usuario u) {
        boolean alterado = false;

        try (Connection conn = Conexao.getConexao()) {

            PreparedStatement stmt = conn.prepareStatement("UPDATE cadastro_usuarios.usuario SET email = ?, senha = ? WHERE id = ?");

            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, u.getId());

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {
                alterado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alterado;
    }

    public static boolean removerUsuario(Usuario u) {
        boolean removido = false;

        try (Connection conn = Conexao.getConexao()) {

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM cadastro_usuarios.usuario WHERE id = ?");

            stmt.setInt(1, u.getId());

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {
                removido = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return removido;
    }
}
