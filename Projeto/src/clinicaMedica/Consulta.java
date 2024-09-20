class Consulta extends Entidade {
    private Paciente paciente;
    private Medico medico;
 
    public Consulta(String nome, Paciente paciente, Medico medico) {
        super(nome);
        this.paciente = paciente;
        this.medico = medico;
    }
 
    @Override
    public void mostrarDetalhes() {
        System.out.println("Consulta: " + getNome() + " - Paciente: " + paciente.getNome() + " com Médico: " + medico.getNome());
    }
}
