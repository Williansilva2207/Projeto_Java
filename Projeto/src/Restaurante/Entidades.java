import java.util.ArrayList;
import java.util.List;

class Pedido {
    private String cliente;
    private String comanda;

    public Pedido(String cliente, String comanda) {
        this.cliente = cliente;
        this.comanda = comanda;
    }

    public String getCliente() {
        return cliente;
    }

    public String getComandas() {
        return comanda;
    }
}

class Itempedido {
    private String prato;
    private String naturalidade;
    private int vezespedidos;
    private List<Integer> avaliacoes;

    public Itempedido(String prato, String naturalidade, int vezespedidos, List<Integer> avaliacoes) {
        this.prato = prato;
        this.naturalidade = naturalidade;
        this.vezespedidos = vezespedidos;
        this.avaliacoes = avaliacoes;
    }

    public String getPrato() {
        return prato;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void incrementarvezespedidos() {
        this.vezespedidos++;
    }

    public int getVezesPedidos() {
        return vezespedidos;
    }

    public void adicionarAvaliacao(int estrelas) {
        avaliacoes.add(estrelas);
    }

    public double calcularMediaAvaliacoes() {
        if (avaliacoes.isEmpty()) return 0;
        int soma = 0;
        for (int nota : avaliacoes) {
            soma += nota;
        }
        return (double) soma / avaliacoes.size();
    }
}

class Mesa {
    private Pedido pedido;
    private Itempedido itempedido;
    private boolean disponibilidade = true;
    private int numeroMesa;

    public Mesa(Pedido pedido, Itempedido itempedido, int numeroMesa, boolean disponibilidade) {
        this.pedido = pedido;
        this.itempedido = itempedido;
        this.numeroMesa = numeroMesa;
        this.disponibilidade = disponibilidade;
        itempedido.incrementarvezespedidos();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Itempedido getitempedido() {
        return itempedido;
    }

    public boolean isDisponibilidade(){
        return disponibilidade;
    }
    public int getNumeroMesa(){
        return numeroMesa;
    }
    @Override
    public String toString() {
        return "Prato " + itempedido.getPrato() + " para o cliente " + pedido.getCliente() + " com a comanda "+ pedido.getComandas()+ " na mesa " + numeroMesa;
    }

    class Cardapio{
        private String comida;
        private String descrision;
        private String nationalite;

        public Cardapio(String comida, String descrision, String nationalite){
            this.comida = comida;
            this.descrision = descrision;
            this.nationalite = nationalite;
        }
        public String getComida(){
            return comida;
        }
        public String getDescrision(){
            return descrision;
        }
        public void setComida(String comida){
            this.comida = comida;
        }
        public String getNationalite(){
            return nationalite;
        }
    }
}

