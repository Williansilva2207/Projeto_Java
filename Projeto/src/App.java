import java.util.Scanner;

public class SistemaRestaurante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestauranteManager consultorioManager = new RestauranteManager();

        while (true) {
            limparTela();
            System.out.println("========================================");
            System.out.println("          Sistema de Restaurante        ");
            System.out.println("========================================");
            System.out.println("1. Fazer Pedido");
            System.out.println("2. Buscar Pedido");
            System.out.println("3. Relatório das mesas");
            System.out.println("4. Avaliar Atendimento");
            System.out.println("5. Consultar prato mais pedido");
            System.out.println("6. Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (option) {
                case 1:
                    RestauranteManager.fazerPedido(scanner);
                    break;
                case 2:
                    RestauranteManager.buscarPedido(scanner);
                    break;
                case 3:
                    RestauranteManager.relatorioMesas();
                    break;
                case 4:
                    RestauranteManager.avaliarAtendimento(scanner);
                    break;
                case 5:
                    RestauranteManager.pratoMaisPedido();
                    break;
                case 6:
                    System.out.println("Saindo... Obrigado por usar o sistema!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    pausa();
            }
            pausa();
        }
    }

    private static void limparTela() {
        // Limpa a tela (comandos para diferentes sistemas)
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    private static void pausa() {
        System.out.println("Pressione Enter para continuar...");
        new Scanner(System.in).nextLine();
    }
}
