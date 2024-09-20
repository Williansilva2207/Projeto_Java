import java.util.ArrayList;
import java.util.List;
 
// Classe abstrata para entidades genéricas
 
// Classe Paciente que herda de Entidade
 
// Classe Médico que herda de Entidade
 
// Classe Consulta que herda de Entidade
 
// Classe Evento que herda de Entidade
 
// Classe Participante que herda de Entidade
 
// Classe Pedido que herda de Entidade
class Pedido extends Entidade {
    private List<ItemDoPedido> itens = new ArrayList<>();
    private double total;
 
    public Pedido(String nome) {
        super(nome);
    }
 
    public void adicionarItem(ItemDoPedido item) {
        itens.add(item);
        total += item.getPreco();
    }
 
    @Override
    public void mostrarDetalhes() {
        System.out.println("Pedido: " + getNome() + " - Total: " + total);
        for (ItemDoPedido item : itens) {
            System.out.println("  Item: " + item.getNome() + " - Preço: " + item.getPreco());
        }
    }
}
 
// Classe ItemDoPedido que herda de Entidade
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
 
// Classe abstrata de gerenciador genérico
abstract class Gerenciador<T extends Entidade> {
    protected List<T> entidades = new ArrayList<>();
 
    public void adicionar(T entidade) {
        entidades.add(entidade);
    }
 
    public void listar() {
        for (T entidade : entidades) {
            entidade.mostrarDetalhes();
        }
    }
}
 
// Gerenciador específico para Consultas
class GerenciadorConsultas extends Gerenciador<Consulta> {
    public void agendarConsulta(Consulta consulta) {
        adicionar(consulta);
        System.out.println("Consulta agendada: " + consulta.getNome());
    }
}
 
// Gerenciador específico para Eventos
class GerenciadorEventos extends Gerenciador<Evento> {
    public void cadastrarEvento(Evento evento) {
        adicionar(evento);
        System.out.println("Evento cadastrado: " + evento.getNome());
    }
}
 
// Gerenciador específico para Pedidos
class GerenciadorPedidos extends Gerenciador<Pedido> {
    public void registrarPedido(Pedido pedido) {
        adicionar(pedido);
        System.out.println("Pedido registrado: " + pedido.getNome());
    }
}
 
// Classe principal para integrar todos os gerenciadores
class Sistema {
    private GerenciadorConsultas gerenciadorConsultas = new GerenciadorConsultas();
    private GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();
    private GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos();
 
    // Métodos para agendamento, cadastro e registro
    public void agendarConsulta(Consulta consulta) {
        gerenciadorConsultas.agendarConsulta(consulta);
    }
 
    public void cadastrarEvento(Evento evento) {
        gerenciadorEventos.cadastrarEvento(evento);
    }
 
    public void registrarPedido(Pedido pedido) {
        gerenciadorPedidos.registrarPedido(pedido);
    }
 
    public void listarConsultas() {
        gerenciadorConsultas.listar();
    }
 
    public void listarEventos() {
        gerenciadorEventos.listar();
    }
 
    public void listarPedidos() {
        gerenciadorPedidos.listar();
    }
}
 
// Main para testes
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