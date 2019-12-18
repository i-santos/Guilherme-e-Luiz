package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Tarefa;
import modelo.Usuario;

public class TarefaDAO {

    public static ArrayList<Tarefa> buscarTarefasDoUsuario(Usuario u) {
        ArrayList<Tarefa> tarefas = new ArrayList();

        try (Connection connection = Conexao.abrirConexao()) {

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM lista_tarefas.tarefa WHERE id_usuario = ?");
            stmt.setInt(1, u.getId());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                boolean finalizada = rs.getBoolean("finalizada");
                String imagem = rs.getString("nome_imagem");

                Tarefa t = new Tarefa();
                t.setTitulo(titulo);
                t.setFinalizada(finalizada);
                t.setId(id);
                t.setIdUsuario(u.getId());
                t.setImagem(imagem);

                tarefas.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarefas;
    }

    public static boolean inserirTarefa(Tarefa t) {
        boolean sucesso = false;

        try (Connection connection = Conexao.abrirConexao()) {

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO lista_tarefas.tarefa (titulo, finalizada, id_usuario, nome_imagem) VALUES (?, ?, ?, ?)");

            stmt.setString(1, t.getTitulo());
            stmt.setBoolean(2, t.isFinalizada());
            stmt.setInt(3, t.getIdUsuario());
            stmt.setString(4, t.getImagem());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public static boolean atualizarTarefa(Tarefa t) {
        boolean sucesso = false;

        try (Connection connection = Conexao.abrirConexao()) {

            PreparedStatement stmt = connection.prepareStatement("UPDATE lista_tarefas.tarefa SET titulo = ?, finalizada = ?, imagem = ? WHERE id = ? and id_usuario = ?");

            stmt.setString(1, t.getTitulo());
            stmt.setBoolean(2, t.isFinalizada());
            stmt.setString(3, t.getImagem());
            stmt.setInt(4, t.getId());
            stmt.setInt(5, t.getIdUsuario());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public static boolean removerTarefa(Tarefa t) {
        boolean sucesso = false;

        try (Connection connection = Conexao.abrirConexao()) {

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM lista_tarefas.tarefa WHERE id = ? and id_usuario = ?");
            stmt.setInt(1, t.getId());
            stmt.setInt(2, t.getIdUsuario());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public static boolean finalizarTarefa(Tarefa t) {
        boolean sucesso = false;

        try (Connection connection = Conexao.abrirConexao()) {

            PreparedStatement stmt = connection.prepareStatement("UPDATE lista_tarefas.tarefa SET finalizada = ? WHERE id = ? and id_usuario = ?");

            stmt.setBoolean(1, true);
            stmt.setInt(2, t.getId());
            stmt.setInt(3, t.getIdUsuario());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }
}
