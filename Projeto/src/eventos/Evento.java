class Evento extends Entidade {
    private String data;
    private String local;
 
    public Evento(String nome, String data, String local) {
        super(nome);
        this.data = data;
        this.local = local;
    }
 
    @Override
    public void mostrarDetalhes() {
        System.out.println("Evento: " + getNome() + " - Data: " + data + " - Local: " + local);
    }
}
