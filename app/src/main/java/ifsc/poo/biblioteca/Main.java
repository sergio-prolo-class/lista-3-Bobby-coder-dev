package ifsc.poo.biblioteca;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Cadastrar Autor \n2. Cadastrar Leitor \n3. Cadastrar Livro \n4. Registrar Empréstimo \n5. Listar Autores \n6. Listar Leitores por Nome " +
                    "\n7. Listar Leitores por ID \n8. Listar Livros por Título \n9. Listar Livros por ISBN \n10. Listar Todos os Empréstimos \n11. Listar Empréstimos por Leitor \n0. Sair");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do autor: ");
                    String nome = sc.nextLine();
                    System.out.print("Idioma do autor: ");
                    String idioma = sc.nextLine();
                    biblioteca.cadastraAutor(nome, idioma);
                }
                case 2 -> {
                    System.out.print("Nome do leitor: ");
                    String nome = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    biblioteca.cadastraLeitor(nome, endereco, telefone);
                }
                case 3 -> {
                    System.out.print("Título do livro: ");
                    String titulo = sc.nextLine();
                    System.out.print("Código ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Quantidade de cópias: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();
                    List<Autor> autoresLivro = new ArrayList<>();
                    System.out.println("Informe os nomes dos autores (digite vazio para encerrar):");
                    while (true) {
                        System.out.print("Autor: ");
                        String nomeAutor = sc.nextLine();
                        if (nomeAutor.isBlank()) break;
                        for (Autor a : biblioteca.getAutores()) {
                            if (a.getNome().equalsIgnoreCase(nomeAutor)) {
                                autoresLivro.add(a);
                                break;
                            }
                        }
                    }
                    biblioteca.cadastraLivro(titulo, isbn, autoresLivro, quantidade);
                }
                case 4 -> {
                    System.out.print("Nome do leitor: ");
                    String nomeLeitor = sc.nextLine();
                    System.out.print("Nome do livro: ");
                    String nomeLivro = sc.nextLine();
                    System.out.print("Data (aaaa-mm-dd): ");
                    String data = sc.nextLine();
                    biblioteca.registrarEmprestimo(nomeLeitor, nomeLivro, data);
                }
                case 5 -> biblioteca.listarAutores();
                case 6 -> biblioteca.listarLeitoresNome();
                case 7 -> biblioteca.listarLeitoresId();
                case 8 -> biblioteca.listarLivrosTitulo();
                case 9 -> biblioteca.listarLivrosIsbn();
                case 10 -> biblioteca.listarEmprestimosData();
                case 11 -> {
                    System.out.print("Nome do leitor: ");
                    String nome = sc.nextLine();
                    biblioteca.listarEmprestimosEspecifico(nome);
                }
                case 0 -> {
                    System.out.println("Encerrando...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
