class GerenciadorConsultas extends Gerenciador<Consulta> {
    public void agendarConsulta(Consulta consulta) {
        adicionar(consulta);
        System.out.println("Consulta agendada: " + consulta.getNome());
    }
}
