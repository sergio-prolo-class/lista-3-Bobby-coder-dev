package ifsc.poo.biblioteca;

import java.util.List;
import java.util.ArrayList;

public class Leitor {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Livro> LivrosEmprestados = new ArrayList<>();
    private int id;

    public Leitor(String nome, String endereco, String telefone, int id){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.id = id;
    }

    public void aquisitarLivro(Livro livro){
        LivrosEmprestados.add(livro);
    }

    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }
    public int getId() { return id; }
    public int getQuantidadeLivros() { return LivrosEmprestados.size(); }
    public boolean temLivro(Livro livro){
        return LivrosEmprestados.contains(livro);
    }
}
