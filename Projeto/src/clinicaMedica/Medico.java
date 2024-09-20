class Medico extends Entidade {
    private String especialidade;
 
    public Medico(String nome, String especialidade) {
        super(nome);
        this.especialidade = especialidade;
    }
 
    @Override
    public void mostrarDetalhes() {
        System.out.println("Médico: " + getNome() + ", Especialidade: " + especialidade);
    }
}
