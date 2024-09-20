abstract class Gerenciador<T extends Entidade> {
    protected List<T> entidades = new ArrayList<>();
 
    public void adicionar(T entidade) {
        entidades.add(entidade);
    }
 
    public void listar() {
        for (T entidade : entidades) {
            entidade.mostrarDetalhes();
        }
    }
}
