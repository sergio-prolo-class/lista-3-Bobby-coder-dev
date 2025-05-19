package ifsc.poo.biblioteca;

public class Emprestimo {
    private Leitor leitor;
    private Livro livro;
    private String data;

    public Emprestimo(Leitor leitor, Livro livro, String data) {
        this.leitor = leitor;
        this.livro = livro;
        this.data = data;
    }

    public Leitor getLeitor() { return leitor; }
    public Livro getLivro() { return livro; }
    public String getData() { return data; }
}
