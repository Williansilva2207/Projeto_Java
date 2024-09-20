class GerenciadorPedidos extends Gerenciador<Pedido> {
    public void registrarPedido(Pedido pedido) {
        adicionar(pedido);
        System.out.println("Pedido registrado: " + pedido.getNome());
    }
}