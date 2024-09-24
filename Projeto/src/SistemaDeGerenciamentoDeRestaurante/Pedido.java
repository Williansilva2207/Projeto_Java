import java.util.ArrayList; 
import java.util.List;

public class Pedido {
    private String idPedido;
    private String cliente;
    private List<ItemDoPedido> itens;
    private double total;
    private String status;
    private String metodoPagamento;

    public Pedido(String idPedido, String cliente, String metodoPagamento) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0.0;
        this.status = "Pendente";
        this.metodoPagamento = metodoPagamento;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public List<ItemDoPedido> getItens() {
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

    public void setTotal(double total){
        this.total = total;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setIdPedidos(String idPedido){
        this.idPedido = idPedido;
    }

    public void setCliente(String cliente){
        this.cliente = cliente;
    }

    public void setMetodoPagamento(String metodoPagamento){
        if(metodoPagamento != "Cartão" && metodoPagamento != "Dinheiro"){
            System.out.println("Forma de pagamento não válido.");
        }else{
            this.metodoPagamento = metodoPagamento;
            System.out.println("Confirmado");
        }
    }
}
