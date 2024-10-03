import java.util.Scanner;

class SistemaRestaurante {
    private Scanner scanner = new Scanner(System.in);
    private RestauranteManager restauranteManager = new RestauranteManager();

    public void iniciarSistema() {
        while (true) {
            limparTela();
            System.out.println("========================================");
            System.out.println("          Sistema de Restaurante        ");
            System.out.println("========================================");
            System.out.println("1. Fazer Pedido");
            System.out.println("2. Informações do Pedido");
            System.out.println("3. Liberar Mesa");
            System.out.println("0. Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (option) {
                case 1:
                    restauranteManager.fazerPedido();
                    break;
                case 2:
                    restauranteManager.buscarPedido();
                    break;
                case 3:
                    restauranteManager.liberarMesa();
                    break;
                case 0:
                    System.out.println("Saindo... Obrigado por usar o sistema!");
                    scanner.close(); // Fecha o scanner antes de sair
                    return; // Sai do método iniciarSistema
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    pausa();
            }
            pausa();
        }
    }

    public void limparTela() {
        // Limpa a tela (comandos para diferentes sistemas)
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pausa() {
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }
}
