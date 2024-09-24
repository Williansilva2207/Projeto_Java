import java.util.List;

public class ItemDoPedido {
    private List<String> descricao;
    private List<Int> quantidade;
    private double preco;

    public Item(double preco) {
        this.descricao = new ArrayList<>();
        this.quantidade = new ArrayList<>();
        this.preco = preco;
    }

    public List<String> getDescricao() {
        return descricao;
    }

    public List<Int> getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }
}