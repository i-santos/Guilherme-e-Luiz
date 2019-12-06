package listadetarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefas {

    static Usuario usuarioLogado = null;
    static Scanner scanner = new Scanner(System.in);

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

                    usuarios.add(u);
                    System.out.println("Usuário cadastrado com sucesso!");

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
                    for (int i = 0; i < usuarios.size(); i++) {
                        Usuario u = usuarios.get(i);

                        if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                            usuarioLogado = u;
                            break;
                        }
                    }

                    if (usuarioLogado == null) {
                        System.out.println("Email/senha incorretos. Redirecionando para Index...");
                    } else {
                        System.out.println("Login feito com sucesso!");
                        rodarMenuSecundario();
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

                    int nTarefas = 0;
                    ArrayList<Tarefa> finalizadas = new ArrayList();

                    for (int i = 0; i < usuarioLogado.getTarefas().size(); i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

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

                    int nTarefas = 0;
                    ArrayList<Tarefa> emAberto = new ArrayList();

                    for (int i = 0; i < usuarioLogado.getTarefas().size(); i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

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
                    usuarioLogado.getTarefas().add(t);
                    System.out.println("Tarefa adicionada com sucesso!");

                    break;
                }
                case "5": {
                    System.out.println("");
                    System.out.println("=========================");
                    System.out.println("||  Finalizar Tarefa   ||");
                    System.out.println("=========================");

                    int nTarefas = 0;
                    ArrayList<Tarefa> emAberto = new ArrayList();

                    for (int i = 0; i < usuarioLogado.getTarefas().size(); i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

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

                    emAberto.get(numTarefa - 1).setFinalizada(true);
                    System.out.println("Tarefa finalizada com sucesso!");

                    break;
                }
                case "6": {
                    System.out.println("");
                    System.out.println("=========================");
                    System.out.println("||  Remover Tarefa     ||");
                    System.out.println("=========================");

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

                    usuarioLogado.getTarefas().remove(numTarefa - 1);
                    System.out.println("Tarefa removida com sucesso!");

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
}
