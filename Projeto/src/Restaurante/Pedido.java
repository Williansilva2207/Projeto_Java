import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens;  // Lista de itens do pedido
    private boolean fechado;  // Indica se o pedido foi fechado

    // Construtor para inicializar o pedido
    public Pedido() {
        this.itens = new ArrayList<>();
        this.fechado = false;
    }

    // Método para adicionar um item ao pedido
    public void adicionarItem(ItemPedido item) {
        if (!fechado) {
            itens.add(item);
        } else {
            System.out.println("Não é possível adicionar itens a um pedido fechado.");
        }
    }

    // Método para remover um item do pedido
    public void removerItem(ItemPedido item) {
        if (!fechado) {
            itens.remove(item);
        } else {
            System.out.println("Não é possível remover itens de um pedido fechado.");
        }
    }

    // Método para calcular o total do pedido
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    // Método para fechar o pedido
    public void fecharPedido() {
        this.fechado = true;
    }

    // Verifica se o pedido está fechado
    public boolean isFechado() {
        return fechado;
    }

    // Exibe os itens do pedido
    @Override
    public String toString() {
        StringBuilder detalhes = new StringBuilder();
        for (ItemPedido item : itens) {
            detalhes.append(item.toString()).append("\n");
        }
        detalhes.append("Total: R$ ").append(calcularTotal());
        return detalhes.toString();
    }
}
