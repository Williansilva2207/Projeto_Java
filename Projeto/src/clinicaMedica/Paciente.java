class Participante extends Entidade {
    private String email;
 
    public Participante(String nome, String email) {
        super(nome);
this.email = email;
    }
 
    @Override
    public void mostrarDetalhes() {
        System.out.println("Participante: " + getNome() + " - Email: " + email);
    }
}
