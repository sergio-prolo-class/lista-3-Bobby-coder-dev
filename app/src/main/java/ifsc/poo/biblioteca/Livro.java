package ifsc.poo.biblioteca;

import java.util.List;
import java.util.ArrayList;

public class Livro {
    private String titulo;
    private String codISBN;
    private List<Autor> autores = new ArrayList<>();

    public Livro(String titulo, String codISBN, List<Autor> autores){
        this.titulo = titulo;
        this.codISBN = codISBN;
        this.autores = autores;
    }

    public String getTitulo() { return titulo; }
    public String getCodISBN() { return codISBN; }
}
