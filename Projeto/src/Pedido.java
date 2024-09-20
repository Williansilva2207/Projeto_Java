class Pedido extends Entidade {
    private List<ItemDoPedido> itens = new ArrayList<>();
    private double total;
 
    public Pedido(String nome) {
        super(nome);
    }
 
    public void adicionarItem(ItemDoPedido item) {
        itens.add(item);
        total += item.getPreco();
    }
 
    @Override
    public void mostrarDetalhes() {
        System.out.println("Pedido: " + getNome() + " - Total: " + total);
        for (ItemDoPedido item : itens) {
            System.out.println("  Item: " + item.getNome() + " - Preço: " + item.getPreco());
        }
    }
}
