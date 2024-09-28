public class ItemPedido {
    private String nome;
    private double preco;

    // Construtor para inicializar os atributos
    public ItemPedido(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getter para o nome do item
    public String getNome() {
        return nome;
    }

    // Setter para o nome do item
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o preço do item
    public double getPreco() {
        return preco;
    }

    // Setter para o preço do item
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método para exibir detalhes do item
    @Override
    public String toString() {
        return "Item: " + nome + " | Preço: R$ " + preco;
    }
}
