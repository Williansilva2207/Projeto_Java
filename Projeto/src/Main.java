import java.util.ArrayList;
import java.util.List;
  
public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
 
        // Testando Consultas
        Paciente paciente1 = new Paciente("João", 30);
        Medico medico1 = new Medico("Dr. Ana", "Cardiologista");
        Consulta consulta1 = new Consulta("Consulta 1", paciente1, medico1);
        sistema.agendarConsulta(consulta1);
 
        // Testando Eventos
        Evento evento1 = new Evento("Evento 1", "10/10/2024", "Auditório A");
        sistema.cadastrarEvento(evento1);
 
        // Testando Pedidos no Restaurante
        Pedido pedido1 = new Pedido("Mesa 1");
        ItemDoPedido item1 = new ItemDoPedido("Pizza", 35.00);
        ItemDoPedido item2 = new ItemDoPedido("Suco", 10.00);
        pedido1.adicionarItem(item1);
        pedido1.adicionarItem(item2);
        sistema.registrarPedido(pedido1);
 
        // Listar tudo
        System.out.println("\n--- Listando Consultas ---");
        sistema.listarConsultas();
        System.out.println("\n--- Listando Eventos ---");
        sistema.listarEventos();
        System.out.println("\n--- Listando Pedidos ---");
        sistema.listarPedidos();
    }
}