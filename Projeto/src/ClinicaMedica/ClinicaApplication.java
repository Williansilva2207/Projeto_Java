import java.util.Scanner;

public class ClinicaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultorioManager consultorioManager = new ConsultorioManager();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Agendar atendimento");
            System.out.println("2. Buscar paciente");
            System.out.println("3. Relatório de atendimentos");
            System.out.println("4. Avaliar atendimento");
            System.out.println("5. Consultar médico mais requisitado");
            System.out.println("6. Sair");
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
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
