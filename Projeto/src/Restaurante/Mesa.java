public class Mesa {
    private int numeroMesa;  // Número da mesa
    private boolean ocupada;  // Indica se a mesa está ocupada
    private Pedido pedido;  // Pedido associado à mesa

    // Construtor para inicializar a mesa
    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.ocupada = false;
        this.pedido = new Pedido();  // Pedido inicial vazio
    }

    // Método para ocupar a mesa
    public void ocuparMesa() {
        this.ocupada = true;
    }

    // Método para desocupar a mesa
    public void desocuparMesa() {
        this.ocupada = false;
        this.pedido = new Pedido();  // Novo pedido para a próxima ocupação
    }

    // Verifica se a mesa está ocupada
    public boolean isOcupada() {
        return ocupada;
    }

    // Retorna o número da mesa
    public int getNumeroMesa() {
        return numeroMesa;
    }

    // Adiciona um item ao pedido da mesa
    public void adicionarItemAoPedido(ItemPedido item) {
        pedido.adicionarItem(item);
    }

    // Fecha o pedido da mesa
    public void fecharPedido() {
        pedido.fecharPedido();
    }

    // Exibe os detalhes do pedido da mesa
    public String exibirPedido() {
        return pedido.toString();
    }
}
