class Sistema {
    private GerenciadorConsultas gerenciadorConsultas = new GerenciadorConsultas();
    private GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();
    private GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos();
 
    // Métodos para agendamento, cadastro e registro
    public void agendarConsulta(Consulta consulta) {
        gerenciadorConsultas.agendarConsulta(consulta);
    }
 
    public void cadastrarEvento(Evento evento) {
        gerenciadorEventos.cadastrarEvento(evento);
    }
 
    public void registrarPedido(Pedido pedido) {
        gerenciadorPedidos.registrarPedido(pedido);
    }
 
    public void listarConsultas() {
        gerenciadorConsultas.listar();
    }
 
    public void listarEventos() {
        gerenciadorEventos.listar();
    }
 
    public void listarPedidos() {
        gerenciadorPedidos.listar();
    }
}
