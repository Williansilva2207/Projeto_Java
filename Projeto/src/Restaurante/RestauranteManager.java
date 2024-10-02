import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RestauranteManager {
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Mesa> mesas = new ArrayList<>();
    private List<ItemPedido> itens = new ArrayList<>();
    private List<Cardapio> cardapio = new ArrayList<>();

    public RestauranteManager() {
        this.pedidos = new ArrayList<>();
        this.mesas = new ArrayList<>();
        this.itens = new ArrayList<>();
        this.cardapio = new ArrayList<>();

        mesas.add(new Mesa(1));
        mesas.add(new Mesa(2));
        mesas.add(new Mesa(3));
        mesas.add(new Mesa(4));
        mesas.add(new Mesa(5));
        
        
    }

    public void mostrarDisponibilidadeMesa(){
        for(Mesa i : mesas){
            if(i.isDisponibilidade()){
                System.out.println("Mesa " + i.getNumeroMesa() + "Disponível");
            }
        }
    }

    public void fazerPedido(){

    }

}
