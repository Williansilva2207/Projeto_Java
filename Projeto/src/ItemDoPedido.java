class ItemDoPedido extends Entidade {
    private double preco;
 
    public ItemDoPedido(String nome, double preco) {
        super(nome);
        this.preco = preco;
    }
 
    public double getPreco() {
        return preco;
    }
 
    @Override
    public void mostrarDetalhes() {
        System.out.println("Item: " + getNome() + " - Preço: " + preco);
    }
}
