package ifsc.poo.login;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opção: \n1 - Cadastrar \n2 - Remover \n3 - Listar \n4 - Autenticar \n5 - Sair");
        int opcao = sc.nextInt();
        sc.nextLine();
        while (opcao != 5) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o login:");
                    String loginCadastro = sc.nextLine();
                    System.out.println("Digite a senha:");
                    String senhaCadastro = sc.nextLine();
                    if (GerenciadorLogin.cadastrar(loginCadastro, senhaCadastro)) {
                        System.out.println("Usuário cadastrado com sucesso");
                    } else {
                        System.out.println("Usuário já existe");
                    }
                    break;
                case 2:
                    System.out.println("Digite o login a ser removido:");
                    String loginRemover = sc.nextLine();
                    if (GerenciadorLogin.remover(loginRemover)) {
                        System.out.println("Usuário removido com sucesso");
                    } else {
                        System.out.println("Usuário não encontrado");
                    }
                    break;
                case 3:
                    System.out.println("Lista de usuários:");
                    for (String usuario : GerenciadorLogin.listar()) {
                        System.out.println(usuario);
                    }
                    break;
                case 4:
                    System.out.println("Digite o login:");
                    String loginAutenticar = sc.nextLine();
                    System.out.println("Digite a senha:");
                    String senhaAutenticar = sc.nextLine();
                    if (GerenciadorLogin.autenticar(loginAutenticar, senhaAutenticar)) {
                        System.out.println("Usuário autenticado com sucesso");
                    } else {
                        System.out.println("Falha na autenticação");
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            System.out.println("Escolha uma opção: 1 - Cadastrar \n2 - Remover \n3 - Listar \n4 - Autenticar \n5 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Encerrando");
        sc.close();
    }
}
