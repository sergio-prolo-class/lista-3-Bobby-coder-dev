package ifsc.poo.atendimento;

public class Cliente {
    private String nome;
    private String numeroTelefone;

    public Cliente(String nome, String numeroTelefone) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }

    public String getNome() { return nome; }
    public String getNumeroTelefone() { return numeroTelefone; }
}
