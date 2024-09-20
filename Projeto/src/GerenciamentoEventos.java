class GerenciadorEventos extends Gerenciador<Evento> {
    public void cadastrarEvento(Evento evento) {
        adicionar(evento);
        System.out.println("Evento cadastrado: " + evento.getNome());
    }
}