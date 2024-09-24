import java.util.List;

public class Pedido {
    private String idPedido;
    private String cliente;
    private List<Item> itens;
    private double total;
    private String status;
    private String metodoPagamento;

    
    public Pedido(String idPedido, String cliente, String metodoPagamento) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0.0;
        this.status = "Pendente";l
        this.metodoPagamento = metodoPagamento;
    }

    // Getters e Setters
    public String getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }
}

