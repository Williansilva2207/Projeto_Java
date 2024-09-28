import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
package Entidades;

class RestauranteManager {
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Mesa> mesas = new ArrayList<>();
    private List<ItemPedido> itens = new ArrayList<>();

    public RestauranteManager() {
        // Médicos pré-definidos
        mesas.add(new Mesa(1));
        mesas.add(new Mesa(2));
        mesas.add(new Mesa(3));
        mesas.add(new Mesa(4));
        mesas.add(new Mesa(5));
        
        
    }