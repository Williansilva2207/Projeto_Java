import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

// Classe para Pedido
class Pedido {
    private String cliente;
    private String comanda;

    public Pedido(String cliente, String comanda) {
        this.cliente = cliente;
        this.comanda = comanda;
    }

    public String getCliente() {
        return cliente;
    }

    public String getComanda() {
        return comanda;
    }
}

// Classe para ItemPedido
class ItemPedido {
    private String prato;
    private String nacionalidade;
    private double preco;

    public ItemPedido(String prato, String nacionalidade, double preco) {
        this.prato = prato;
        this.nacionalidade = nacionalidade;
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

    public Mesa(Pedido pedido, int numeroMesa, boolean disponibilidade) {
        this.pedido = pedido;
        this.numeroMesa = numeroMesa;
        this.disponibilidade = disponibilidade;
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

    public void liberarMesa() {
        this.disponibilidade = true;
        this.pedido = null;
    }

    @Override
    public String toString() {
        return "Mesa " + numeroMesa + " - Pedido: " + (pedido != null ? pedido.getComanda() : "Nenhum");
    }
}

// Classe para Cardapio
class Cardapio {
    private String comida;
    private String descricao;
    private String nacionalidade;
    private double preco;

    public Cardapio(String comida, String descricao, String nacionalidade, double preco) {
        this.comida = comida;
        this.descricao = descricao;
        this.nacionalidade = nacionalidade;
        this.preco = preco;
    }

    public String getComida() {
        return comida;
    }

    public String getDescricao() {
        return descricao;
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
        cardapio.add(new Cardapio("Tacacá", "Uma sopa típica feita com tucupi, goma de mandioca, camarão e jambu.", "Região Norte", 22.50));
        cardapio.add(new Cardapio("Acarajé", "Um bolinho de feijão-fradinho frito no azeite de dendê.", "Região Nordeste", 11.50));
        cardapio.add(new Cardapio("Arroz com Pequi", "Arroz cozido com o pequi, um fruto típico do Cerrado.", "Região Centro-Oeste", 15.00));
        cardapio.add(new Cardapio("Feijão Tropeiro", "Feijão, farinha de mandioca, linguiça e ovos.", "Região Sudeste", 16.50));
        cardapio.add(new Cardapio("Barreado", "Carne bovina cozida lentamente.", "Região Sul", 17.50));

        // Adicionando mesas ao restaurante
        for (int i = 1; i <= 7; i++) {
            mesas.add(new Mesa(null, i, true));
        }
    }

    public List<Cardapio> getCardapio() {
        return cardapio;
    }

    public void fazerPedido(String nome, String prato) {
        for (Mesa mesa : mesas) {
            if (mesa.isDisponivel()) {
                Pedido novoPedido = new Pedido(nome, prato);
                mesa.getPedido();
                mesa.liberarMesa();
                pedidos.add(novoPedido);
                return;
            }
        }
        System.out.println("Não há mesas disponíveis.");
    }

    public String buscarPedido(int numeroMesa) {
        if (numeroMesa > 0 && numeroMesa <= mesas.size()) {
            Mesa mesa = mesas.get(numeroMesa - 1);
            return mesa.toString();
        }
        return "Mesa não encontrada.";
    }

    public void liberarMesa(int numeroMesa) {
        if (numeroMesa > 0 && numeroMesa <= mesas.size()) {
            mesas.get(numeroMesa - 1).liberarMesa();
        }
    }
}

// Classe principal para a GUI do Restaurante
public class SistemaRestauranteApp extends JFrame {
    private RestauranteManager restauranteManager;
    private JTextArea textArea;
    private JTextField nomeField;
    private JComboBox<String> pratoComboBox;

    public SistemaRestauranteApp() {
        restauranteManager = new RestauranteManager();
        setTitle("Sistema de Restaurante");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        nomeField = new JTextField();
        pratoComboBox = new JComboBox<>();

        // Adicionando pratos ao JComboBox
        for (Cardapio cardapio : restauranteManager.getCardapio()) {
            pratoComboBox.addItem(cardapio.getComida());
        }

        inputPanel.add(new JLabel("Nome do Cliente:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Escolha um Prato:"));
        inputPanel.add(pratoComboBox);

        JButton fazerPedidoButton = new JButton("Fazer Pedido");
        JButton buscarPedidoButton = new JButton("Buscar Pedido");
        JButton liberarMesaButton = new JButton("Liberar Mesa");

        fazerPedidoButton.addActionListener(e -> fazerPedido());
        buscarPedidoButton.addActionListener(e -> buscarPedido());
        liberarMesaButton.addActionListener(e -> liberarMesa());

        inputPanel.add(fazerPedidoButton);
        inputPanel.add(buscarPedidoButton);
        inputPanel.add(liberarMesaButton);

        add(inputPanel, BorderLayout.SOUTH);
    }

    private void fazerPedido() {
        String nome = nomeField.getText();
        String prato = (String) pratoComboBox.getSelectedItem();
        restauranteManager.fazerPedido(nome, prato);
        textArea.setText("Pedido feito com sucesso para " + nome + " com o prato " + prato);
    }

    private void buscarPedido() {
        String mesaStr = JOptionPane.showInputDialog("Digite o número da mesa:");
        if (mesaStr != null) {
            int mesa = Integer.parseInt(mesaStr);
            String resultado = restauranteManager.buscarPedido(mesa);
            textArea.setText(resultado);
        }
    }

    private void liberarMesa() {
        String mesaStr = JOptionPane.showInputDialog("Digite o número da mesa:");
        if (mesaStr != null) {
            int mesa = Integer.parseInt(mesaStr);
            restauranteManager.liberarMesa(mesa);
            textArea.setText("Mesa " + mesa + " liberada.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaRestauranteApp app = new SistemaRestauranteApp();
            app.setVisible(true);
        });
    }
}
