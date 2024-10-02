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

        cardapio.comida.add("Tacacá\n");
        cardapio.descrision.add("Uma sopa típica feita com tucupi (caldo fermentado da mandioca),\ngoma de mandioca, camarão e jambu (erva que provoca leve dormência na boca).\nMuito popular no Pará e Amazonas.\n");
        cardapio.comida.add("Acarajé\n");
        cardapio.descrision.add("Um bolinho de feijão-fradinho frito no azeite de dendê,\nrecheado com vatapá, camarão seco e caruru, típico da Bahia, principalmente em Salvador.\n");
        cardapio.comida.add("Arroz com Pequi\n");
        cardapio.descrision.add("Um prato de arroz cozido com o pequi, um fruto típico do Cerrado, muito apreciado em Goiás e Mato Grosso.\n");
        cardapio.comida.add("Feijão Tropeiro\n");
        cardapio.descrision.add("Um prato feito com feijão, farinha de mandioca, linguiça, bacon e ovos,\ntípico de Minas Gerais, mas popular em toda a região Sudeste.\n");
        cardapio.comida.add("Barreado\n");
        cardapio.descrision.add("Um prato tradicional do litoral do Paraná. Ele é feito com carne bovina cozida\nlentamente em uma panela de barro, junto com temperos como alho, cebola, louro e cominho.\n A carne é cozida até se desmanchar e é servida com farinha de mandioca e banana.\n É um prato festivo e muito apreciado na região.\n");
        cardapio.comida.add("Pato no Tucupi\n");
        cardapio.descrision.add("Um prato típico do Pará, onde o pato é cozido com tucupi e jambu, e geralmente servido em ocasiões especiais.\n");
        
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
