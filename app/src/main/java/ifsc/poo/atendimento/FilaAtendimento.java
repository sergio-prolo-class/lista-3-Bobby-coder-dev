package ifsc.poo.atendimento;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FilaAtendimento {
    private final Queue<Solicitacao> solicitacoes = new LinkedList<>();
    private final Map<String, Cliente> clientes = new HashMap<>();
    private final List<Solicitacao> atendidas = new ArrayList<>();

    public void registrarSolicitacao(String nome, String numeroTelefone, String descricao, String categoria) {
        Cliente cliente = new Cliente(nome, numeroTelefone);
        if(!clientes.containsKey(nome)) {
            clientes.put(numeroTelefone, cliente);
        }
        Solicitacao solicitacao = new Solicitacao(cliente, descricao, categoria);
        solicitacoes.add(solicitacao);
    }

    public List<String> ListarTodosTelefones() {
        List<String> telefones = new LinkedList<>();
        for (String Telefone : clientes.keySet()) {
            telefones.add(Telefone);
        }
        return telefones;
    }

    public String ProximoCliente() {
        if(solicitacoes.isEmpty()) {
            return "Fila Vazia";
        }
        return solicitacoes.peek().getCliente().getNome();

    }

    public void AtenderSolicitacao() {
        Solicitacao solicitacao = solicitacoes.poll();
        if(solicitacao != null) {
            atendidas.add(solicitacao);
        }
        System.out.println("Nome:" + solicitacao.getCliente().getNome());
        System.out.println("Telefone:" + solicitacao.getCliente().getNumeroTelefone());
        System.out.println("Descrição:" + solicitacao.getDescricao());
        System.out.println("Categoria:" + solicitacao.getCategoria());
    }

    public List<String> ListarAtendidos() {
        List<String> atendidos = new LinkedList<>();
        for (Solicitacao s : atendidas) {
            atendidos.add(s.getCliente().getNome());
        }
        return atendidos;
    }

    public List<String> ListarTelefonesEspera() {
        List<String> telefones = new LinkedList<>();
        for (Solicitacao s : solicitacoes) {
            telefones.add(s.getCliente().getNumeroTelefone());
        }
        return telefones;
    }

    public void GerarRelatorio() {
        int total = solicitacoes.size() + atendidas.size();
        System.out.println("Solicitações totais: " + total);
        System.out.println("Solicitações atendidas: " + atendidas.size());
        System.out.println("Solicitações em espera" + solicitacoes.size());

        int ST = 0; //suporte tecnico
        int In = 0; //informacao
        int AF = 0; //atendimento financeiro

        for(Solicitacao s : solicitacoes) {
            switch(s.getCategoria()){
                case "Suporte Técnico": ST++; break;
                case "Informação": In++; break;
                case "Atendimento Financeiro": AF++; break;
            }
        }

        for(Solicitacao s : atendidas) {
            switch(s.getCategoria()){
                case "Suporte Técnico": ST++; break;
                case "Informação": In++; break;
                case "Atendimento Financeiro": AF++; break;
            }
        }

        System.out.println("Suporte Técnico: " + (100.0 * ST / total) + "%");
        System.out.println("Solicitações atendidas: " + (100.0 * In / total) + "%");
        System.out.println("Solicitações em espera: " + (100.0 * AF / total) + "%");
    }
}
