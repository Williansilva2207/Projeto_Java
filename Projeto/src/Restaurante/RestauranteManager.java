import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RestauranteManager{
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Mesa> mesas = new ArrayList<>();
    private List<ItemPedido> itens = new ArrayList<>();
    private List<Cardapio> cardapio = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public RestauranteManager() {
        this.pedidos = new ArrayList<>();
        this.mesas = new ArrayList<>();
        this.itens = new ArrayList<>();
        this.cardapio = new ArrayList<>();

        // Adicionando mesas ao restaurante
        

        // Adicionando pratos ao cardápio
        cardapio.add(new Cardapio("Tacacá", "Uma sopa típica feita com tucupi, goma de mandioca, camarão e jambu.", "Região Norte"));
        cardapio.add(new Cardapio("Acarajé", "Um bolinho de feijão-fradinho frito no azeite de dendê, recheado com vatapá, camarão seco e caruru.", "Região Nordeste"));
        cardapio.add(new Cardapio("Arroz com Pequi", "Um prato de arroz cozido com o pequi, um fruto típico do Cerrado.", "Região Centro-Oeste"));
        cardapio.add(new Cardapio("Feijão Tropeiro", "Um prato feito com feijão, farinha de mandioca, linguiça, bacon e ovos.", "Região Sudeste"));
        cardapio.add(new Cardapio("Barreado", "Um prato tradicional do litoral do Paraná feito com carne bovina cozida lentamente.", "Região Sul"));
        cardapio.add(new Cardapio("Pato no Tucupi", "Um prato típico do Pará, onde o pato é cozido com tucupi e jambu.", "Região Norte"));
    }
    // Mostrar a disponibilidade das mesas
    public void mostrarDisponibilidadeMesa() {
        for (Mesa i : mesas) {
            if (i.isDisponivel()) {
                System.out.println("Mesa " + i.getNumeroMesa() + " está disponível.");
            } else {
                System.out.println("Mesa " + i.getNumeroMesa() + " está ocupada.");
            }
        }
    }

    // Fazer um pedido selecionando itens do cardápio
    public void fazerPedido() {
        System.out.println("Cardápio: \n");
        int ctd = 0;
        int opcao;
        String nomeDoCliente;
        for (Cardapio i : cardapio) {
            ctd++;
            System.out.printf("____________________ Digite %d ________________________\n", ctd);
            System.out.println("Comida: " + i.getComida());
            System.out.println("Descrição: " + i.getDescricao());
            System.out.println("Nacionalidade: " + i.getNacionalidade());
            System.out.println("____________________________________________________________");
        }

        System.out.println("Digite o número do alimento que deseja:");
        opcao = sc.nextInt();
        System.out.println("Digite o seu nome:");
        nomeDoCliente = sc.next();
        // Adiciona o item selecionado ao pedido (verifica se a opção é válida)
        if (opcao > 0 && opcao <= cardapio.size()) {
            itens.add(new ItemPedido(cardapio.get(opcao - 1).getComida(), cardapio.get(opcao - 1).getNacionalidade()));
            System.out.println("Item adicionado ao pedido.");
            Pedido novoPedido = new Pedido(nomeDoCliente, cardapio.get(opcao - 1).getComida());
            pedidos.add(novoPedido);
        } else {
            System.out.println("Opção inválida.");
        }
    }
    public void buscarPedido(){
        
    }
    public void relatorioMesas(){
        
    }
    public void avaliarAtendimento(){
        
    }
    public void pratoMaisPedido(){
        
    }
}


   
