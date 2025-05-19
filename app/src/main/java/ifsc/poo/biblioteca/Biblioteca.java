package ifsc.poo.biblioteca;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class Biblioteca {
    private final List<Emprestimo> emprestimos = new ArrayList<>();
    private final List<Autor> autores = new ArrayList<>();
    private final List<Leitor> leitores = new ArrayList<>();
    private final Map<Livro, Integer> livros = new HashMap<>(); //livro e quantidade
    private static int id = 0;

    public void cadastraAutor(String nome, String idioma){
        Autor autor = new Autor(nome, idioma);
        if(!autores.contains(autor)) { autores.add(autor); }
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void cadastraLeitor(String nome, String endereco, String telefone){
        Leitor leitor = new Leitor(nome, endereco, telefone, id);
        if(!leitores.contains(leitor)) {
            leitores.add(leitor);
            id++;
        }
    }

    public void cadastraLivro(String titulo, String codISBN,  List<Autor> autores, int quantidade){
        Livro livro = new Livro(titulo, codISBN, autores);
        if (!livros.containsKey(livro)) {
            livros.put(livro, quantidade);
        }

    }

    public void registrarEmprestimo(String nomeLeitor, String nomeLivro, String data){
        Leitor leitorEncontrado = null;
        Livro livroEncontrado = null;

        for (Leitor leitor : leitores) {
            if (leitor.getNome().equals(nomeLeitor)) {
                leitorEncontrado = leitor;
                break;
            }
        }

        for (Livro livro : livros.keySet()) {
            if (livro.getTitulo().equals(nomeLivro)) {
                livroEncontrado = livro;
                break;
            }
        }

        if (leitorEncontrado.temLivro(livroEncontrado)) {
            System.out.println("Leitor já possui esse livro.");
            return;
        }

        if (livros.get(livroEncontrado) <= 0) {
            System.out.println("Livro indisponível.");
            return;
        }

        if (leitorEncontrado.getQuantidadeLivros() >= 5) {
            System.out.println("Leitor já possui o máximo de livros.");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(leitorEncontrado,livroEncontrado , data);
        emprestimos.add(emprestimo);
        leitorEncontrado.aquisitarLivro(livroEncontrado);
        livros.put(livroEncontrado, livros.get(livroEncontrado) - 1);
    }

    public void listarAutores() {
        List<Autor> autoresOrdenados = new ArrayList<>(autores);
        autoresOrdenados.sort(Comparator.comparing(Autor::getNome));
        for (Autor autor : autoresOrdenados) {
            System.out.println(autor.getNome() + " (" + autor.getIdioma() + ")");
        }
    }

    public void listarLeitoresNome() {
        List<Leitor> leitoresOrdenados = new ArrayList<>(leitores);
        leitoresOrdenados.sort(Comparator.comparing(Leitor::getNome));
        for (Leitor leitor : leitoresOrdenados) {
            System.out.println("ID: " + leitor.getId() + " - " + leitor.getNome());
        }
    }

    public void listarLeitoresId() {
        List<Leitor> leitoresOrdenados = new ArrayList<>(leitores);
        leitoresOrdenados.sort(Comparator.comparing(Leitor::getId));
        for (Leitor leitor : leitoresOrdenados) {
            System.out.printf("ID: %04d | Nome: %s\n", leitor.getId(), leitor.getNome());
        }
    }

    public void listarLivrosTitulo() {
        List<Livro> livrosOrdenados = new ArrayList<>(livros.keySet());
        livrosOrdenados.sort(Comparator.comparing(Livro::getTitulo));
        for (Livro livro : livrosOrdenados) {
            System.out.println("Título: " + livro.getTitulo() + " | ISBN: " + livro.getCodISBN());
        }
    }
    public void listarLivrosIsbn() {
        List<Livro> livrosOrdenados = new ArrayList<>(livros.keySet());
        livrosOrdenados.sort(Comparator.comparing(Livro::getCodISBN));
        for (Livro livro : livrosOrdenados) {
            System.out.println("Título: " + livro.getTitulo() + " | ISBN: " + livro.getCodISBN());
        }
    }

    public void listarEmprestimosData() {
        List<Emprestimo> emprestimosOrdenados = new ArrayList<>(emprestimos);
        emprestimosOrdenados.sort(Comparator.comparing(Emprestimo::getData));
        for (Emprestimo e : emprestimosOrdenados) {
            System.out.println("Leitor: " + e.getLeitor().getNome() + " | Data: " + e.getData() + " | Livro: " + e.getLivro().getTitulo());
        }
    }

    public void listarEmprestimosEspecifico(String nome) {
        List<Emprestimo> emprestimosDoLeitor = new ArrayList<>();

        for (Emprestimo e : emprestimos) {
            if (e.getLeitor().getNome().equals(nome)) {
                emprestimosDoLeitor.add(e);
            }
        }



        emprestimosDoLeitor.sort(Comparator.comparing(Emprestimo::getData));

        System.out.println("Leitor: " + nome);
        for (Emprestimo e : emprestimosDoLeitor) {
            System.out.println("Data: " + e.getData() + " | Livro: " + e.getLivro().getTitulo());
        }
    }

}
