
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RestauranteManager {

    private List<Pedido> pedidos = new ArrayList<>();
    private List<Mesa> mesas = new ArrayList<>();
    private List<ItemPedido> itens = new ArrayList<>();
    private List<Cardapio> cardapio = new ArrayList<>();
    private int num;
    Scanner sc = new Scanner(System.in);

    public RestauranteManager() {
        this.pedidos = new ArrayList<>();
        this.mesas = new ArrayList<>();
        this.itens = new ArrayList<>();
        this.cardapio = new ArrayList<>();

        // Adicionando mesas ao restaurante
        // Adicionando pratos ao cardápio
        cardapio.add(new Cardapio("Tacacá", "Uma sopa típica feita com tucupi, goma de mandioca, camarão e jambu.", "Região Norte", 22.50));
        cardapio.add(new Cardapio("Acarajé", "Um bolinho de feijão-fradinho frito no azeite de dendê, recheado com vatapá, camarão seco e caruru.", "Região Nordeste", 11.50));
        cardapio.add(new Cardapio("Arroz com Pequi", "Um prato de arroz cozido com o pequi, um fruto típico do Cerrado.", "Região Centro-Oeste", 15.00));
        cardapio.add(new Cardapio("Feijão Tropeiro", "Um prato feito com feijão, farinha de mandioca, linguiça, bacon e ovos.", "Região Sudeste", 16.50));
        cardapio.add(new Cardapio("Barreado", "Um prato tradicional do litoral do Paraná feito com carne bovina cozida lentamente.", "Região Sul", 17.50));
        cardapio.add(new Cardapio("Pato no Tucupi", "Um prato típico do Pará, onde o pato é cozido com tucupi e jambu.", "Região Norte", 22.50));
    }

    public int getNum() {
        return num;
    }

    public void setNum(int numero) {
        this.num += numero;
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
        int numero = 1;
        String nomeDoCliente;
        for (Cardapio i : cardapio) {
            ctd++;
            System.out.printf("____________________ Digite %d ________________________\n", ctd);
            System.out.println("Comida: " + i.getComida());
            System.out.println("Descrição: " + i.getDescricao());
            System.out.println("Nacionalidade: " + i.getNacionalidade());
            System.out.println("Preço: R$" + i.getPreco1());
            System.out.println("____________________________________________________________");
        }



        System.out.println("Digite o número do alimento que deseja:");
        opcao = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o seu nome:");
        nomeDoCliente = sc.nextLine();
        setNum(numero);
        if (opcao > 0 && opcao <= cardapio.size() && num <= 7) {
            itens.add(new ItemPedido(cardapio.get(opcao - 1).getComida(), cardapio.get(opcao - 1).getNacionalidade(), cardapio.get(opcao - 1).getPreco1()));
            System.out.println("Item adicionado ao pedido.");
            Pedido novoPedido = new Pedido(nomeDoCliente, cardapio.get(opcao - 1).getComida());
            pedidos.add(novoPedido);
            Mesa mesinha = new Mesa(novoPedido, new ItemPedido(cardapio.get(opcao - 1).getComida(), cardapio.get(opcao - 1).getNacionalidade(), cardapio.get(opcao - 1).getPreco1()), getNum(), true);
            mesas.add(mesinha);
        } else if (num > 7) {
            System.out.println("Não há mesas disponíveis");
        } else {
            System.out.println("Opção inválida");
        }
    }

    public void buscarPedido() {
        int numberTable;
        System.out.println("Digite o número da mesa:");
        numberTable = sc.nextInt();
        for (Mesa mesa : mesas) {
            if (mesa.getNumeroMesa() == numberTable) {
                System.out.println(mesa.toString());
                return;
            }
        }

    }

    public void liberarMesa() {
        System.out.println("Qual é a senha: ");
        String senha = sc.next();
        if (senha.equals("ADM2024")) {
            int numberTable;
            System.out.println("Digite o número da mesa:");
            numberTable = sc.nextInt();
            for (Mesa mesa : mesas) {
                if (mesa.getNumeroMesa() == numberTable) {
                    mesas.get(numberTable - 1).setNumeroMesa(0);
                    num = numberTable - 1;
                    return;
                }
            }
            System.out.println("Mesa não encontrada!");
        }

    }

}
