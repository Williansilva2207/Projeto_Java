import java.util.ArrayList;
import java.util.List;

class Pedido{
    private String cliente;
    private String comanda;

    public Pedido(String cliente, String comanda) {
        this.cliente = cliente;
        this.comanda = comanda;
    }

    // Getter para cliente
    public String getCliente() {
        return cliente;
    }

    // Setter para cliente
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    // Getter para comanda
    public String getComanda() {
        return comanda;
    }

    // Setter para comanda
    public void setComanda(String comanda) {
        this.comanda = comanda;
    }
}


class ItemPedido {
    private String prato;
    private String nacionalidade;
    private int vezesPedidos;
    private double preco;
    private List<Integer> avaliacoes;

    public ItemPedido(String prato, String nacionalidade, double preco) {
        this.prato = prato;
        this.nacionalidade = nacionalidade;
        this.vezesPedidos = 0;
        this.avaliacoes = new ArrayList<>();
        this.preco = preco;
    }

    // Getter para prato
    public String getPrato() {
        return prato;
    }

    // Setter para prato
    public void setPrato(String prato) {
        this.prato = prato;
    }

    // Getter para nacionalidade
    public String getNacionalidade() {
        return nacionalidade;
    }

    // Setter para nacionalidade
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    // Getter para vezesPedidos
    public int getVezesPedidos() {
        return vezesPedidos;
    }

    // Setter para vezesPedidos
    public void setVezesPedidos(int vezesPedidos) {
        this.vezesPedidos = vezesPedidos;
    }

    // Getter para avaliacoes
    public List<Integer> getAvaliacoes() {
        return avaliacoes;
    }

    // Setter para avaliacoes
    public void setAvaliacoes(List<Integer> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    // Método para incrementar vezesPedidos
    public void incrementarVezesPedidos() {
        this.vezesPedidos++;
    }

    // Método para adicionar avaliação
    public void adicionarAvaliacao(int estrelas) {
        avaliacoes.add(estrelas);
    }

    // Método para calcular média das avaliações
    public double calcularMediaAvaliacoes() {
        if (avaliacoes.isEmpty()) {
            return 0;
        }
        int soma = 0;
        for (int nota : avaliacoes) {
            soma += nota;
        }
        return (double) soma / avaliacoes.size();
    }
    public double getPreco(){
        return preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
}

class Mesa {
    private Pedido pedido;
    private ItemPedido itemPedido;
    private boolean disponibilidade;
    private int numeroMesa;

    public Mesa(Pedido pedido, ItemPedido itemPedido, int numeroMesa, boolean disponibilidade) {
        this.pedido = pedido;
        this.itemPedido = itemPedido;
        this.numeroMesa = numeroMesa;
        this.disponibilidade = disponibilidade;
        itemPedido.incrementarVezesPedidos();
    }

    // Getter e setter para pedido
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    // Getter e setter para itemPedido
    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    // Getter e setter para disponibilidade
    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        if(numeroMesa > 7){
            this.disponibilidade = false;
        }
        this.disponibilidade = disponibilidade;
    }

    // Getter e setter para numeroMesa
    public int getNumeroMesa() {
        
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        if(numeroMesa > 7){
            return;
        }
        this.numeroMesa = numeroMesa;
    }

    @Override
    public String toString() {
        return "Prato " + itemPedido.getPrato() + " para o cliente " + pedido.getCliente() + " com a comanda " + pedido.getComanda() + " na mesa " + numeroMesa + " Preço R$" + itemPedido.getPreco();
    }
}


class Cardapio {
    private String comida;
    private String descricao;
    private String nacionalidade;
    private double preco1;

    public Cardapio(String comida, String descricao, String nacionalidade, double preco1) {
        this.comida = comida;
        this.descricao = descricao;
        this.nacionalidade = nacionalidade;
        this.preco1 = preco1;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public double getPreco1(){
        return preco1;
    }
    public void setPreco1(double preco1){
        this.preco1 = preco1;
    }
}