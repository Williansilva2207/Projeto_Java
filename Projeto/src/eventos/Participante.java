class Paciente extends Entidade {
    private int idade;
 
    public Paciente(String nome, int idade) {
        super(nome);
        this.idade = idade;
    }
 
    @Override
    public void mostrarDetalhes() {
        System.out.println("Paciente: " + getNome() + ", Idade: " + idade);
    }
}
