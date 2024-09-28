import java.util.List;
import java.util.ArrayList; 
public class ItemDoPedido {
    private List<String> descricao;
    private List<Integer> quantidade;
    private double preco;

    public Item(double preco) {
        this.descricao = new ArrayList<>();
        this.quantidade = new ArrayList<>();
        this.preco = preco;
    }

    public List<String> getDescricao() {
        return descricao;
    }

    public List<Integer> getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }
}