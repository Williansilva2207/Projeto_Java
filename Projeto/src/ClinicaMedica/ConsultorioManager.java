import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ConsultorioManager {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Atendimento> atendimentos = new ArrayList<>();

    public ConsultorioManager() {
        // Médicos pré-definidos
        medicos.add(new Medico("Drauzio Varella", "Clínico Geral"));
        medicos.add(new Medico("Dr. House", "Diagnóstico Diferencial"));
        medicos.add(new Medico("Alice", "Pediatra"));
        medicos.add(new Medico("Bob", "Dermatologista"));
        medicos.add(new Medico("Carlos", "Cardiologista"));
    }

    public void agendarAtendimento(Scanner scanner) {
        System.out.print("Digite o nome do paciente: ");
        String nomePaciente = scanner.nextLine();
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();

        Paciente paciente = new Paciente(nomePaciente, cpfPaciente);
        pacientes.add(paciente);

        System.out.println("Escolha a especialidade:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + ". " + medicos.get(i).getEspecialidade());
        }
        int especialidadeEscolhida = scanner.nextInt() - 1;

        System.out.println("Médicos disponíveis para " + medicos.get(especialidadeEscolhida).getEspecialidade() + ":");
        Medico medicoEscolhido = medicos.get(especialidadeEscolhida);
        System.out.println(medicoEscolhido.getNome());
        
        System.out.println("Horários disponíveis:");
        for (String horario : medicoEscolhido.getHorariosDisponiveis()) {
            System.out.println(horario);
        }

        System.out.print("Escolha um horário (HH:mm): ");
        String horarioEscolhido = scanner.next();
        String dataHora = "Hoje " + horarioEscolhido; // Substituir por uma data real

        atendimentos.add(new Atendimento(paciente, medicoEscolhido, dataHora));
        medicoEscolhido.setDisponivel(false);
        System.out.println("Atendimento agendado com sucesso!");
    }

    public void buscarPaciente(Scanner scanner) {
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                System.out.println("Paciente encontrado: " + paciente.getNome());
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    public void relatorioAtendimentos() {
        System.out.println("Relatório de Atendimentos:");
        for (Atendimento atendimento : atendimentos) {
            System.out.println(atendimento);
        }
    }

    public void avaliarAtendimento(Scanner scanner) {
        System.out.print("Digite o CPF do paciente para encontrar o atendimento: ");
        String cpf = scanner.nextLine();
        boolean found = false;

        for (Atendimento atendimento : atendimentos) {
            if (atendimento.getMedico().getNome().equals(cpf)) {
                System.out.print("Avalie o atendimento com estrelas (1 a 5): ");
                int estrelas = scanner.nextInt();
                if (estrelas < 1 || estrelas > 5) {
                    System.out.println("Avaliação inválida.");
                } else {
                    atendimento.getMedico().adicionarAvaliacao(estrelas);
                    System.out.println("Avaliação registrada com sucesso!");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Atendimento não encontrado para o CPF informado.");
        }
    }

    public void medicoMaisRequisitado() {
        Medico maisRequisitado = null;

        for (Medico medico : medicos) {
            if (maisRequisitado == null || medico.getAtendimentosRealizados() > maisRequisitado.getAtendimentosRealizados()) {
                maisRequisitado = medico;
            }
        }

        if (maisRequisitado != null) {
            System.out.println("Médico mais requisitado: " + maisRequisitado.getNome() +
                    " com " + maisRequisitado.getAtendimentosRealizados() + " atendimentos realizados.");
            System.out.println("Média de avaliações: " + maisRequisitado.calcularMediaAvaliacoes());
        }
    }
}
