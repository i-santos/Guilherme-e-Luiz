package cadastrodeusuariospersistente;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroDeUsuariosPersistente {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Usuario> usuarios = new ArrayList();

            boolean running = true;

            while (running) {

                System.out.println("");
                System.out.println("************************");
                System.out.println("* Cadastro de Usuários *");
                System.out.println("************************");
                System.out.println("[1] Adicionar Novo Usuário");
                System.out.println("[2] Listar Todos Usuários");
                System.out.println("[3] Procurar Usuário por E-mail");
                System.out.println("[4] Remover Usuário por E-mail");
                System.out.println("[5] Finalizar Programa");
                System.out.print("Digite a opção: ");
                String opcao = sc.nextLine();

                switch (opcao) {
                    case "1": {

                        Usuario u = new Usuario();

                        System.out.print("Digite o e-mail: ");
                        u.setEmail(sc.nextLine());
                        System.out.print("Digite a senha: ");
                        u.setSenha(sc.nextLine());

                        boolean inserido = inserirUsuario(u);
                        if (inserido) {
                            System.out.println("Usuário cadastrado!");
                        }
                        break;
                    }
                    case "2": {

                        usuarios = pegarUsuarios();

                        if (usuarios.isEmpty()) {
                            System.out.println("Nenhum usuário cadastrado.");
                            break;
                        }

                        for (int i = 0; i < usuarios.size(); i++) {
                            Usuario u = usuarios.get(i);
                            System.out.println("Usuario " + (i + 1) + ": ");
                            System.out.println("\tEmail: " + u.getEmail());
                            System.out.println("\tSenha: " + u.getSenha());
                        }

                        System.out.println("[Fim da lista de usuários]");
                        break;
                    }
                    case "3": {

                        // Pegar lista de usuários atualizada no banco de dados
                        usuarios = pegarUsuarios();
                        
                        System.out.print("Digite o email do usuário: ");
                        String uEmail = sc.nextLine();
                        boolean encontrado = false;

                        for (int i = 0; i < usuarios.size(); i++) {
                            Usuario u = usuarios.get(i);

                            if (u.getEmail().equals(uEmail)) {
                                encontrado = true;
                                System.out.println("Usuário encontrado:");
                                System.out.println("\tEmail: " + u.getEmail());
                                System.out.println("\tSenha: " + u.getSenha());
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Usuário não cadastrado.");
                        }

                        break;
                    }
                    case "4": {
                        
                        // Pegar lista de usuários atualizada no banco de dados
                        usuarios = pegarUsuarios();

                        System.out.print("Digite o email do usuário: ");
                        String uEmail = sc.nextLine();
                        boolean removido = false;

                        for (int i = 0; i < usuarios.size(); i++) {
                            Usuario u = usuarios.get(i);

                            if (u.getEmail().equals(uEmail)) {
                                removido = removerUsuario(u);
                                break;
                            }

                        }
                        if (!removido) {
                            System.out.println("Usuário não cadastrado.");
                        } else {
                            System.out.println("Usuário removido com sucesso!");
                        }
                        break;
                    }
                    case "5": {
                        System.out.println("Encerrando programa...");
                        running = false;
                        break;
                    }
                    default:
                        System.out.println("Opção inválida!");
                }

                if (running) {

                    System.out.println("Pressione enter para continuar");
                    sc.nextLine();
                }

            }

            usuarios.clear();
        }
        System.out.println("Programa encerrado.");

    }

    public static boolean inserirUsuario(Usuario u) {

        boolean inserido = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

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

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cadastro_usuarios.usuario");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
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

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

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

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

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

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

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
