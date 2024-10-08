package Evento;

import java.util.Scanner;

public class SistemaEventos {

    private Scanner se = new Scanner(System.in);
    private Evento evento;

    public void iniciarSistema() {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Eventos");
        System.out.print("Informe o nome do evento: ");
        String nomeEvento = se.nextLine();
        System.out.print("Informe a data do evento: ");
        String dataEvento = se.nextLine();
        System.out.print("Informe o local do evento: ");
        String nomeLocal = se.nextLine();
        System.out.print("Informe a capacidade máxima: ");
        int capacidadeMaxima = se.nextInt();
        se.nextLine(); // Limpar o buffer

        Local local = new Local(nomeLocal, "Endereço Padrão");
        evento = new Evento(nomeEvento, dataEvento, local, capacidadeMaxima);

        gerenciarEvento();
    }

    private void gerenciarEvento() {
        int option;
        do {
            System.out.println("========================================");
            System.out.println("        Gerenciamento de Evento         ");
            System.out.println("========================================");
            System.out.println("1. Registrar Participante");
            System.out.println("2. Verificar Número de Participantes");
            System.out.println("3. Gerar Relatório");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");
            option = se.nextInt();
            se.nextLine(); // Limpar o buffer

            switch (option) {
                case 1:
                    registrarParticipante();
                    break;
                case 2:
                    System.out.println("Número de participantes: " + evento.getNumeroParticipantes());
                    break;
                case 3:
                    evento.gerarRelatorioParticipacao();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 0);
    }

    private void registrarParticipante() {
        System.out.print("Nome do participante: ");
        String nome = se.nextLine();
        System.out.print("Email do participante: ");
        String email = se.nextLine();

        Participante participante = new Participante(nome, email);
        boolean sucesso = evento.registrarParticipante(participante);

        if (sucesso) {
            System.out.println("Participante registrado com sucesso.");
        } else {
            System.out.println("Não foi possível registrar o participante.");
        }
    }
}
