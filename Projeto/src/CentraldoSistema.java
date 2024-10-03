import java.util.Scanner;

public class CentraldoSistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaRestaurante sr = new SistemaRestaurante();
        SistemaClinica scl = new SistemaClinica();

        sr.limparTela();
        System.out.println("========================================");
        System.out.println("            Central de Sistema          ");
        System.out.println("========================================");
        System.out.println("1. Sistema de Restaurante");
        System.out.println("2. Sistema de Clínica");
        System.out.println("3. Sistema de Eventos");
        System.out.println("0. Sair");
        System.out.println("========================================");
        System.out.print("Escolha uma opção: ");
        int option = sc.nextInt();
        sc.nextLine(); // Limpar o buffer

        switch (option) {
            case 1:
                sr.iniciarSistema();
                break;
            case 2:
                scl.iniciarSistema();
                break;
            case 3:
                //so falta o de nicolas agora nesse po@%
                break;
            case 0:
                System.out.println("Obrigado por usar nosso Sistema!!!");
        }

        sr.iniciarSistema();
    }
}