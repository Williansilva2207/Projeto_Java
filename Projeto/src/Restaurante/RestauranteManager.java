import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RestauranteManager {
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Mesa> mesas = new ArrayList<>();
    private List<ItemPedido> itens = new ArrayList<>();
    private List<Cardapio> cardapio = new ArrayList<>();
    Scanner sc = new Scanner (System.in);
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

        cardapio.add(new Cardapio("Tacacá", "Uma sopa típica feita com tucupi, goma de mandioca, camarão e jambu.", "Região Norte"));
        cardapio.add(new Cardapio("Acarajé", "Um bolinho de feijão-fradinho frito no azeite de dendê, recheado com vatapá, camarão seco e caruru.", "Região Nordeste"));
        cardapio.add(new Cardapio("Arroz com Pequi", "Um prato de arroz cozido com o pequi, um fruto típico do Cerrado.", "Região Centro-Oeste"));
        cardapio.add(new Cardapio("Feijão Tropeiro", "Um prato feito com feijão, farinha de mandioca, linguiça, bacon e ovos.", "Região Sudeste"));
        cardapio.add(new Cardapio("Barreado", "Um prato tradicional do litoral do Paraná feito com carne bovina cozida lentamente.", "Região Sul"));
        cardapio.add(new Cardapio("Pato no Tucupi", "Um prato típico do Pará, onde o pato é cozido com tucupi e jambu.", "Região Norte"));
    }
    

    public void mostrarDisponibilidadeMesa(){
        for(Mesa i : mesas){
            if(i.isDisponibilidade()){
                System.out.println("Mesa " + i.getNumeroMesa() + "Disponível");
            }
        }
    }

    public void fazerPedido(){
        System.out.println("Cardápio: \n");
        int ctd = 0;
        int opcao;
        for(Cardapio i : cardapio){
            ctd ++;
            System.out.printf("____________________ Digite %d ________________________", ctd);
            System.out.println("Comida: " + i.getComida());
            System.out.println("Descrição: " + i.getDescrision());
            System.out.println("Nacionalidade: " + i.getNationalite());
            System.out.println("____________________________________________________________");
        }

        System.out.println("Digite o número do alimento que deseja:");
        opcao = sc.nextInt();
        itens.add(cardapio.get(opcao-1));
    }

}
