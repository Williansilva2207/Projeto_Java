import java.util.Scanner;

public class ClinicaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultorioManager consultorioManager = new ConsultorioManager();

        while (true) {
            limparTela();
            System.out.println("========================================");
            System.out.println("         Sistema de Clínica Médica      ");
            System.out.println("========================================");
            System.out.println("1. Agendar Atendimento");
            System.out.println("2. Buscar Paciente");
            System.out.println("3. Relatório de Atendimentos");
            System.out.println("4. Avaliar Atendimento");
            System.out.println("5. Consultar Médico Mais Requisitado");
            System.out.println("6. Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (option) {
                case 1:
                    consultorioManager.agendarAtendimento(scanner);
                    break;
                case 2:
                    consultorioManager.buscarPaciente(scanner);
                    break;
                case 3:
                    consultorioManager.relatorioAtendimentos();
                    break;
                case 4:
                    consultorioManager.avaliarAtendimento(scanner);
                    break;
                case 5:
                    consultorioManager.medicoMaisRequisitado();
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
