package listadetarefaspersistente;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefasPersistente {

    static Usuario usuarioLogado = null;
    static Scanner scanner = new Scanner(System.in);
    static Driver driver = null;

    public static void main(String[] args) {

        // Inicializar o array
        ArrayList<Usuario> usuarios = new ArrayList();

        // Variáveis de controle
        String email = "";
        String senha = "";
        int nTentativas = 0;
        boolean running = true;

        while (running) {

            System.out.println("");
            System.out.println("===============");
            System.out.println("||  Index   ||");
            System.out.println("==============");
            System.out.println("[1] Fazer cadastro");
            System.out.println("[2] Fazer login");
            System.out.println("[3] Encerrar programa");
            System.out.print("Digite a opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": {

                    System.out.println("");
                    System.out.println("===========================");
                    System.out.println("||  Página de cadastro   ||");
                    System.out.println("===========================");
                    nTentativas = 0;
                    do {

                        if (nTentativas > 0) {
                            System.out.println("Email incorreto. Tente novamente");
                        }

                        System.out.print("Digite o email: ");
                        email = scanner.nextLine();
                        nTentativas++;

                    } while (!email.contains("@"));

                    nTentativas = 0;

                    do {

                        if (nTentativas > 0) {
                            System.out.println("Senha incorreta: mínimo 6 e máximo 15 caracteres. Tente novamente");
                        }
                        System.out.print("Digite a senha: ");
                        senha = scanner.nextLine();
                        nTentativas++;
                    } while (senha.length() < 6 || senha.length() > 15);

                    Usuario u = new Usuario();
                    u.setEmail(email);
                    u.setSenha(senha);

                    boolean cadastrado = inserirUsuario(email, senha);
                    if (cadastrado) {
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar usuário. Tente novamente");
                    }

                    break;
                }
                case "2": {

                    System.out.println("");
                    System.out.println("=======================");
                    System.out.println("||  Página de login  ||");
                    System.out.println("=======================");

                    // Pegar email e senha
                    // Email
                    nTentativas = 0;
                    do {

                        if (nTentativas > 0) {
                            System.out.println("Email incorreto. Tente novamente");
                        }

                        System.out.print("Digite o email: ");
                        email = scanner.nextLine();
                        nTentativas++;

                    } while (!email.contains("@"));

                    // Senha
                    nTentativas = 0;
                    do {

                        if (nTentativas > 0) {
                            System.out.println("Senha incorreta: mínimo 6 e máximo 15 caracteres. Tente novamente");
                        }
                        System.out.print("Digite a senha: ");
                        senha = scanner.nextLine();
                        nTentativas++;
                    } while (senha.length() < 6 || senha.length() > 15);

                    // Procurar se tem algum usuário com esse email e senha
                    Usuario u = procurarUsuarioPorEmail(email);

                    if (u.getSenha().equals(senha)) {
                        usuarioLogado = u;
                        System.out.println("Login feito com sucesso!");
                        rodarMenuSecundario();
                    } else {
                        System.out.println("Email/senha incorretos. Redirecionando para Index...");
                    }

                    break;
                }
                case "3": {
                    running = false;
                    System.out.println("Encerrando programa...");
                    break;
                }
            }

            if (running) {
                System.out.println("Pressione enter para continuar");
                scanner.nextLine();
            }

        }

        scanner.close();
        System.out.println("Programa finalizado.");

    }

    static void rodarMenuSecundario() {

        while (usuarioLogado != null) {

            System.out.println("");
            System.out.println("==================");
            System.out.println("||  Home Page   ||");
            System.out.println("==================");
            System.out.println("[1] Listar tarefas");
            System.out.println("[2] Listar tarefas finalizadas");
            System.out.println("[3] Listar tarefas não finalizadas");
            System.out.println("[4] Adicionar nova tarefa");
            System.out.println("[5] Finalizar tarefa");
            System.out.println("[6] Remover tarefa");
            System.out.println("[7] Logout");
            System.out.print("Digite a opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": {
                    System.out.println("");
                    System.out.println("==========================");
                    System.out.println("||  Lista de Tarefas    ||");
                    System.out.println("==========================");

                    // Pegar tarefas do banco de dados
                    ArrayList<Tarefa> tarefas = procurarTarefasPorUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);

                    int nTarefas = usuarioLogado.getTarefas().size();

                    if (nTarefas == 0) {
                        System.out.println("Lista de tarefas VAZIA. Redirecionando para Home Page...");
                        break;
                    }

                    for (int i = 0; i < nTarefas; i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

                        System.out.println("Tarefa " + (i + 1) + ":");
                        System.out.println("\tTitulo:\t\t" + t.getTitulo());
                        System.out.println("\tFinalizada:\t" + t.isFinalizada());
                    }
                    break;
                }
                case "2": {
                    System.out.println("");
                    System.out.println("==========================");
                    System.out.println("||  Tarefas Finalizadas  ||");
                    System.out.println("==========================");

                    // Pegar tarefas do banco de dados
                    ArrayList<Tarefa> tarefas = procurarTarefasPorUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);

                    // Criar um novo array para armazenar apenas as tarefas finalizadas
                    int nTarefas = 0;
                    ArrayList<Tarefa> finalizadas = new ArrayList();

                    // Percorrer as tarefas do usuário, procurando as finalizadas
                    for (int i = 0; i < usuarioLogado.getTarefas().size(); i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

                        // Se essa tarefa foi finalizada, adicionar ao array
                        if (t.isFinalizada()) {
                            finalizadas.add(t);
                            nTarefas++;
                        }
                    }

                    if (nTarefas == 0) {
                        System.out.println("Nenhuma tarefa para mostrar. Redirecionando para Home Page");
                        break;
                    }

                    for (int i = 0; i < nTarefas; i++) {
                        Tarefa t = finalizadas.get(i);

                        System.out.println("Tarefa " + (i + 1) + ":");
                        System.out.println("\t\tTitulo:\t\t" + t.getTitulo());
                        System.out.println("\t\tFinalizada:\t" + t.isFinalizada());
                    }
                    break;
                }
                case "3": {
                    System.out.println("");
                    System.out.println("==========================");
                    System.out.println("||  Tarefas Em Aberto   ||");
                    System.out.println("==========================");

                    // Pegar tarefas no banco de dados
                    ArrayList<Tarefa> tarefas = procurarTarefasPorUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);

                    // Criar um novo array para armazenar apenas as tarefas em aberto
                    int nTarefas = 0;
                    ArrayList<Tarefa> emAberto = new ArrayList();

                    // Percorrer as tarefas do usuário procurando as em aberto
                    for (int i = 0; i < usuarioLogado.getTarefas().size(); i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

                        // Se a tarefa estiver em aberto, adicionar ao array
                        if (!t.isFinalizada()) {
                            emAberto.add(t);
                            nTarefas++;
                        }
                    }

                    if (nTarefas == 0) {
                        System.out.println("Nenhuma tarefa para mostrar. Redirecionando para Home Page...");
                        break;
                    }

                    for (int i = 0; i < nTarefas; i++) {
                        Tarefa t = emAberto.get(i);

                        System.out.println("Tarefa " + (i + 1) + ":");
                        System.out.println("\tTitulo:\t\t" + t.getTitulo());
                        System.out.println("\tFinalizada:\t" + t.isFinalizada());
                    }
                    break;
                }
                case "4": {
                    System.out.println("");
                    System.out.println("====================");
                    System.out.println("||  Nova Tarefa   ||");
                    System.out.println("====================");
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();

                    Tarefa t = new Tarefa();
                    t.setTitulo(titulo);
                    t.setFinalizada(false);

                    boolean inserida = inserirTarefa(titulo, usuarioLogado.getId());

                    if (inserida) {
                        System.out.println("Tarefa adicionada com sucesso!");
                    } else {
                        System.out.println("Aconteceu algum erro ao adicionar a tarefa. Tente novamente.");
                    }

                    break;
                }
                case "5": {
                    System.out.println("");
                    System.out.println("=========================");
                    System.out.println("||  Finalizar Tarefa   ||");
                    System.out.println("=========================");

                    // Pegar a lista de tarefas atualizada no banco de dados
                    ArrayList<Tarefa> tarefas = procurarTarefasPorUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);

                    // Novo array para armazenar apenas tarefas em aberto
                    int nTarefas = 0;
                    ArrayList<Tarefa> emAberto = new ArrayList();

                    // Percorrer as tarefas do usuário procurando apenas as em aberto
                    for (int i = 0; i < usuarioLogado.getTarefas().size(); i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

                        // Se a tarefa estiver em aberto, adicionar ao array
                        if (!t.isFinalizada()) {
                            emAberto.add(t);
                            nTarefas++;
                        }
                    }

                    if (nTarefas == 0) {
                        System.out.println("Nenhuma tarefa que possa ser finalizada. Redirecionando para Home Page...");
                        break;
                    }

                    int numTarefa = 0;
                    int nTentativas = 0;
                    do {

                        if (nTentativas > 0) {
                            System.out.println("Número de referência inválido.");
                        }

                        for (int i = 0; i < nTarefas; i++) {
                            Tarefa t = usuarioLogado.getTarefas().get(i);

                            System.out.println("[" + (i + 1) + "] " + t.getTitulo());
                        }
                        System.out.print("Digite a tarefa que deseja finalizar: ");
                        numTarefa = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer
                        nTentativas++;

                    } while (numTarefa < 1 || numTarefa > nTarefas);

                    Tarefa t = emAberto.get(numTarefa - 1);
                    t.setFinalizada(true);

                    boolean atualizada = alterarTarefa(t);

                    if (atualizada) {
                        System.out.println("Tarefa finalizada com sucesso!");
                    } else {
                        System.out.println("Aconteceu algum erro ao finalizar tarefa. Tente novamente");
                    }

                    break;
                }
                case "6": {
                    System.out.println("");
                    System.out.println("=========================");
                    System.out.println("||  Remover Tarefa     ||");
                    System.out.println("=========================");

                    // Pegar a lista de tarefas atualizada no banco de dados
                    ArrayList<Tarefa> tarefas = procurarTarefasPorUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);

                    int nTarefas = usuarioLogado.getTarefas().size();

                    if (nTarefas == 0) {
                        System.out.println("Nenhuma tarefa para mostrar. Redirecionando para Home Page...");
                        break;
                    }

                    int numTarefa = 0;
                    int nTentativas = 0;
                    do {

                        if (nTentativas > 0) {
                            System.out.println("Número de refêrncia inválido.");
                        }

                        for (int i = 0; i < nTarefas; i++) {
                            Tarefa t = usuarioLogado.getTarefas().get(i);

                            System.out.println("[" + (i + 1) + "] " + t.getTitulo());
                        }
                        System.out.print("Digite a tarefa que deseja remover: ");
                        numTarefa = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer
                        nTentativas++;

                    } while (numTarefa < 1 || numTarefa > nTarefas);

                    Tarefa t = usuarioLogado.getTarefas().remove(numTarefa - 1);
                    boolean removida = removerTarefa(t);

                    if (removida) {
                        System.out.println("Tarefa removida com sucesso!");
                    } else {
                        System.out.println("Aconteceu algum erro ao remover a tarefa. Tente novamente");
                    }

                    break;
                }
                case "7": {
                    usuarioLogado = null;
                    System.out.println("Fazendo logout...");
                    break;
                }
            }

            if (usuarioLogado != null) {
                System.out.println("Pressione enter para voltar para Home Page");
                scanner.nextLine();
            }

        }

        System.out.println("Logout feito com sucesso. Redirecionando para Index...");

    }

    /**
     * Métodos para estabelecer conexão com Banco de Dados
     */
    public static void registrarDriver() {

        if (driver == null) {

            try {

                driver = new Driver();
                DriverManager.registerDriver(driver);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static Connection abrirConexao() {

        Connection conn = null;

        if (driver != null) {

            try {

                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return conn;
    }

    /**
     * Métodos para realizar Consultas no banco de dados
     */
    
    static boolean inserirUsuario(String email, String senha) {
        boolean cadastrado = false;

        registrarDriver();

        try (Connection conn = abrirConexao()) {

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO lista_tarefas.usuario (email, senha) VALUES (?, ?)");

            stmt.setString(1, email);
            stmt.setString(2, senha);

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {
                cadastrado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cadastrado;

    }

    static Usuario procurarUsuarioPorEmail(String email) {
        Usuario u = null;
        registrarDriver();

        try (Connection conn = abrirConexao()) {

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM lista_tarefas.usuario WHERE email = ?");

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

    static boolean removerUsuario(Usuario u) {

        boolean removido = false;
        registrarDriver();
        try (Connection conn = abrirConexao()) {

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM lista_tarefas.usuario WHERE id = ?");
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

    static boolean alterarUsuario(Usuario u) {
        boolean alterado = false;
        registrarDriver();
        try (Connection conn = abrirConexao()) {

            PreparedStatement stmt = conn.prepareCall("UPDATE lista_tarefas.usuario SET email = ?, senha = ? WHERE id = ?");

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

    static boolean inserirTarefa(String titulo, int usuarioId) {
        boolean inserido = false;
        registrarDriver();
        try (Connection conn = abrirConexao()) {

            PreparedStatement stmt = conn.prepareCall("INSERT INTO lista_tarefas.tarefa (titulo, finalizada, usuario_id) VALUES (?, ?, ?)");

            stmt.setString(1, titulo);
            stmt.setBoolean(2, false);
            stmt.setInt(3, usuarioId);

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {
                inserido = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inserido;
    }

    static ArrayList<Tarefa> procurarTarefasPorUsuario(int usuarioId) {
        ArrayList<Tarefa> tarefas = new ArrayList();
        registrarDriver();
        try (Connection conn = abrirConexao()) {

            PreparedStatement stmt = conn.prepareCall("SELECT * FROM lista_tarefas.tarefa WHERE usuario_id = ?");

            stmt.setInt(1, usuarioId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarefas;
    }

    static boolean removerTarefa(Tarefa t) {
        boolean removida = false;
        registrarDriver();
        try (Connection conn = abrirConexao()) {

            PreparedStatement stmt = conn.prepareCall("DELETE FROM lista_tarefas.tarefa WHERE id = ? and usuario_id = ?");

            stmt.setInt(1, t.getId());
            stmt.setInt(2, t.getUsuarioId());

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {
                removida = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return removida;
    }

    static boolean alterarTarefa(Tarefa t) {
        boolean alterada = false;
        registrarDriver();
        try (Connection conn = abrirConexao()) {

            PreparedStatement stmt = conn.prepareCall("UPDATE lista_tarefas.tarefa SET titulo = ?, finalizada = ? WHERE id = ? and usuario_id = ?");

            stmt.setString(1, t.getTitulo());
            stmt.setBoolean(2, t.isFinalizada());
            stmt.setInt(3, t.getId());
            stmt.setInt(4, t.getUsuarioId());

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {
                alterada = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alterada;
    }
}
