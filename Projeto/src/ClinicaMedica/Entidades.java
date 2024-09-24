import java.util.ArrayList;
import java.util.List;

class Paciente {
    private String nome;
    private String cpf;

    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

class Medico {
    private String nome;
    private String especialidade;
    private boolean disponivel;
    private int atendimentosRealizados;
    private List<Integer> avaliacoes;
    private List<String> horariosDisponiveis;

    public Medico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponivel = true;
        this.atendimentosRealizados = 0;
        this.avaliacoes = new ArrayList<>();
        this.horariosDisponiveis = new ArrayList<>();
        for (int i = 8; i <= 17; i++) {
            horariosDisponiveis.add(i + ":00");
            horariosDisponiveis.add(i + ":30");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void incrementarAtendimentos() {
        this.atendimentosRealizados++;
    }

    public int getAtendimentosRealizados() {
        return atendimentosRealizados;
    }

    public void adicionarAvaliacao(int estrelas) {
        avaliacoes.add(estrelas);
    }

    public double calcularMediaAvaliacoes() {
        if (avaliacoes.isEmpty()) return 0;
        int soma = 0;
        for (int nota : avaliacoes) {
            soma += nota;
        }
        return (double) soma / avaliacoes.size();
    }

    public List<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void removerHorario(String horario) {
        horariosDisponiveis.remove(horario);
    }
}

class Atendimento {
    private Paciente paciente;
    private Medico medico;
    private String dataHora;

    public Atendimento(Paciente paciente, Medico medico, String dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        medico.incrementarAtendimentos();
        medico.removerHorario(dataHora.split(" ")[1]);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    @Override
    public String toString() {
        return "Atendimento com Dr(a). " + medico.getNome() + " para o paciente " + paciente.getNome() + " na data " + dataHora;
    }
}
