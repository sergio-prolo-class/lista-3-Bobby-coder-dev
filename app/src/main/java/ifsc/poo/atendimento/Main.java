package ifsc.poo.atendimento;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem-vindo a Fila de atendimento!");
        System.out.println("Escolha uma opção: \n1 - Registrar Solicitação \n2 - Todos os telefones \n" +
                "3 - Proximo Cliente \n4 - Atender Cliente \n5 - Clientes Atendidos \n6 - Telefones em espera \n7 - Relátorio \n8 - Sair");
        int opcao = sc.nextInt();
        sc.nextLine();
        while (true){
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do Cliente: ");
                    String nome = sc.nextLine();

                    System.out.println("Digite o numero de telefone: ");
                    String numeroTelefone = sc.nextLine();

                    System.out.println("Digite a descrição:");
                    String descricao = sc.nextLine();

                    System.out.println("Escolha a categoria do Cliente: \n1 - Suporte Técnico \n2 - Informação \n3 - Atendimento Financeiro");
                    int cat = sc.nextInt();

                    String categoria = "";
                    switch (cat) {
                        case 1:
                            categoria = "Suporte Técnico";
                            break;
                        case 2:
                            categoria = "Informação";
                            break;
                        case 3:
                            categoria = "Atendimento Financeiro";
                            break;
                        default:
                            System.out.println("Categoria inválida.");
                            continue;
                    }

                    fila.registrarSolicitacao(nome, numeroTelefone, descricao, categoria);
                    System.out.println("Cliente registrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Telefones cadastrados:");
                    for (String tel : fila.ListarTodosTelefones()) {
                        System.out.println(tel);
                    }
                    break;

                case 3:
                    System.out.println("Próximo cliente: " + fila.ProximoCliente());
                    break;

                case 4:
                    fila.AtenderSolicitacao();
                    System.out.println("Cliente atendido!");
                    break;

                case 5:
                    System.out.println("Clientes atendidos:");
                    for (String nomeAtendido : fila.ListarAtendidos()) {
                        System.out.println(nomeAtendido);
                    }
                    break;

                case 6:
                    System.out.println("Telefones em espera:");
                    for (String tel : fila.ListarTelefonesEspera()) {
                        System.out.println(tel);
                    }
                    break;

                case 7:
                    fila.GerarRelatorio();
                    break;

                case 8:
                    System.out.println("Encerrando...");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("Escolha uma opção: \n1 - Registrar Solicitação \n2 - Todos os telefones \n" +
                    "3 - Proximo Cliente \n4 - Atender Cliente \n5 - Clientes Atendidos \n6 - Telefones em espera \n7 - Relátorio \n8 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
        }
    }
}