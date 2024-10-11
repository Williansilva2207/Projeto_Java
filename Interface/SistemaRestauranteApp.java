package Interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

// Classe para Pedido
class Pedido {
    private String cliente;
    private List<ItemPedido> itens;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public String getCliente() {
        return cliente;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }
        return total;
    }
}

// Classe para ItemPedido
class ItemPedido {
    private String prato;
    private double preco;

    public ItemPedido(String prato, double preco) {
        this.prato = prato;
        this.preco = preco;
    }

    public String getPrato() {
        return prato;
    }

    public double getPreco() {
        return preco;
    }
}

// Classe para Mesa
class Mesa {
    private Pedido pedido;
    private int numeroMesa;
    private boolean disponibilidade;

    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.disponibilidade = true;
        this.pedido = null;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void fazerPedido(Pedido pedido) {
        this.pedido = pedido;
        this.disponibilidade = false;
    }

    public void liberarMesa() {
        this.disponibilidade = true;
        this.pedido = null;
    }

    @Override
    public String toString() {
        return "Mesa " + numeroMesa + " - Pedido: " + (pedido != null ? "R$" + String.format("%.2f", pedido.getTotal()) : "Nenhum");
    }
}

// Classe para Cardapio
class Cardapio {
    private String comida;
    private double preco;

    public Cardapio(String comida, double preco) {
        this.comida = comida;
        this.preco = preco;
    }

    public String getComida() {
        return comida;
    }

    public double getPreco() {
        return preco;
    }
}

// Classe para gerenciar o restaurante
class RestauranteManager {
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Mesa> mesas = new ArrayList<>();
    private List<Cardapio> cardapio = new ArrayList<>();

    public RestauranteManager() {
        // Adicionando pratos ao cardápio
        cardapio.add(new Cardapio("Tacacá", 22.50));
        cardapio.add(new Cardapio("Acarajé", 11.50));
        cardapio.add(new Cardapio("Arroz com Pequi", 15.00));
        cardapio.add(new Cardapio("Feijão Tropeiro", 16.50));
        cardapio.add(new Cardapio("Barreado", 17.50));

        // Adicionando mesas ao restaurante
        for (int i = 1; i <= 7; i++) {
            mesas.add(new Mesa(i));
        }
    }

    public List<Cardapio> getCardapio() {
        return cardapio;
    }

    public void fazerPedido(String nome, List<ItemPedido> itens) {
        for (Mesa mesa : mesas) {
            if (mesa.isDisponivel()) {
                Pedido novoPedido = new Pedido(nome);
                for (ItemPedido item : itens) {
                    novoPedido.adicionarItem(item);
                }
                mesa.fazerPedido(novoPedido);
                pedidos.add(novoPedido);
                JOptionPane.showMessageDialog(null, "Pedido feito com sucesso para " + nome + "!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Não há mesas disponíveis.");
    }

    public String buscarPedido(int numeroMesa) {
        if (numeroMesa > 0 && numeroMesa <= mesas.size()) {
            Mesa mesa = mesas.get(numeroMesa - 1);
            return mesa.toString();
        }
        return "Mesa não encontrada.";
    }

    public double liberarMesa(int numeroMesa) {
        if (numeroMesa > 0 && numeroMesa <= mesas.size()) {
            Mesa mesa = mesas.get(numeroMesa - 1);
            double total = mesa.getPedido().getTotal();
            mesa.liberarMesa();
            JOptionPane.showMessageDialog(null, "Mesa " + numeroMesa + " liberada. Total do pedido: R$" + String.format("%.2f", total));
            return total;
        }
        return 0;
    }
}

// Classe principal para a GUI do Restaurante
public class SistemaRestauranteApp extends JFrame {
    private RestauranteManager restauranteManager;
    private JTextField nomeField;
    private JList<ItemPedido> itemPedidoList;
    private DefaultListModel<ItemPedido> listModel;

    public SistemaRestauranteApp() {
        restauranteManager = new RestauranteManager();
        setTitle("Sistema de Restaurante");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Adicionando um botão de voltar
        JButton voltarButton = new JButton("<- Voltar");
        voltarButton.addActionListener(e -> voltarAoMenuPrincipal());

        // Painel de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        nomeField = new JTextField();

        // Lista de pedidos
        listModel = new DefaultListModel<>();
        itemPedidoList = new JList<>(listModel);
        itemPedidoList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Adicionando pratos ao JList com preços
        for (Cardapio cardapio : restauranteManager.getCardapio()) {
            listModel.addElement(new ItemPedido(cardapio.getComida(), cardapio.getPreco()));
        }

        inputPanel.add(new JLabel("Nome do Cliente:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Escolha os Pratos:"));
        inputPanel.add(new JScrollPane(itemPedidoList));

        JButton fazerPedidoButton = new JButton("Fazer Pedido");
        JButton buscarPedidoButton = new JButton("Buscar Pedido");
        JButton liberarMesaButton = new JButton("Liberar Mesa");

        fazerPedidoButton.addActionListener(e -> fazerPedido());
        buscarPedidoButton.addActionListener(e -> buscarPedido());
        liberarMesaButton.addActionListener(e -> liberarMesa());

        inputPanel.add(fazerPedidoButton);
        inputPanel.add(buscarPedidoButton);
        inputPanel.add(liberarMesaButton);

        // Adicionando os componentes à janela
        add(voltarButton, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.SOUTH);
    }

    private void fazerPedido() {
        String nome = nomeField.getText();
        List<ItemPedido> itensSelecionados = itemPedidoList.getSelectedValuesList();
        if (itensSelecionados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione pelo menos um prato.");
            return;
        }
        restauranteManager.fazerPedido(nome, itensSelecionados);
    }

    private void buscarPedido() {
        String mesaStr = JOptionPane.showInputDialog("Digite o número da mesa:");
        if (mesaStr != null) {
            int mesa = Integer.parseInt(mesaStr);
            String resultado = restauranteManager.buscarPedido(mesa);
            JOptionPane.showMessageDialog(null, resultado);
        }
    }

    private void liberarMesa() {
        String mesaStr = JOptionPane.showInputDialog("Digite o número da mesa:");
        if (mesaStr != null) {
            int mesa = Integer.parseInt(mesaStr);
            restauranteManager.liberarMesa(mesa);
        }
    }

    private void voltarAoMenuPrincipal() {
        this.dispose(); // Fecha a janela atual do restaurante
        new InterfacePrincipal().setVisible(true); // Retorna ao menu principal
    }
}
