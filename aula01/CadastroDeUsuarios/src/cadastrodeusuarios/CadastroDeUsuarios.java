package cadastrodeusuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroDeUsuarios {

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
                int opcao = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (opcao) {
                    case 1: {

                        Usuario u = new Usuario();

                        System.out.print("Digite o e-mail: ");
                        u.setEmail(sc.nextLine());
                        System.out.print("Digite a senha: ");
                        u.setSenha(sc.nextLine());

                        usuarios.add(u);
                        System.out.println("Usuário cadastrado!");
                        break;
                    }
                    case 2: {

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
                    case 3: {

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
                    case 4: {

                        System.out.print("Digite o email do usuário: ");
                        String uEmail = sc.nextLine();
                        boolean removido = false;

                        for (int i = 0; i < usuarios.size(); i++) {
                            Usuario u = usuarios.get(i);

                            if (u.getEmail().equals(uEmail)) {
                                usuarios.remove(u);
                                removido = true;
                                System.out.println("Usuário removido!");
                                break;
                            }

                        }
                        if (!removido) {
                            System.out.println("Usuário não cadastrado.");
                        }
                        break;
                    }
                    case 5: {
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

}
