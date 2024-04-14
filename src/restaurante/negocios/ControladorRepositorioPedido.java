package restaurante.negocios;

import java.util.ArrayList;
import java.util.List;
import restaurante.dados.cardapio.Item;
import restaurante.dados.pedido.Pedido;
import restaurante.repositorio.IRepositorioPedido;

/**
 * Puxa os métodos do RepositorioPedido
 * @author Gustavo
 * @author Lucas
 */
public class ControladorRepositorioPedido {

    private IRepositorioPedido iRepositorioPedido;
/**
 * Construtor do controlador.
 * @param iRepositorioPedido IRepositorioCardapio - interface do repositório.
 */
    public ControladorRepositorioPedido(IRepositorioPedido iRepositorioPedido) {
        this.iRepositorioPedido = iRepositorioPedido;
    }

    /**
     * Método para listar os pedidos abertos numa ArrayList.
     * @return ArrayList - contem os pedidos abertos.
     */

    public ArrayList<Pedido> listarPedidosArray()
    {
        return this.iRepositorioPedido.listarPedidosArray();
    }

    /**
     * Método para listar os pedidos encerrados numa arrayList
     * @return ArrayList - contem os pedidos encerrados.
     */
    public ArrayList<Pedido> listarPedidosEncerradosArray()
    {
        return this.iRepositorioPedido.listarPedidosEncerradosArray();
    }

    /**
     * Método para adicionar um novo pedido no repositorio de pedidos.
     * @param pedido Pedido- pedido a ser adicionado.
     */
    public void inserirPedido(Pedido pedido) {
        this.iRepositorioPedido.inserirPedido(pedido);
    }

    /**
     * Método para encerrar um pedido no repositório.
     * @param pedido Pedido - pedido que vai ser encerrado.
     */
    public void encerrarPedido(Pedido pedido) {
        this.iRepositorioPedido.encerrarPedido(pedido);
    }

    /**
     * Método para adicionar um novo item no pedido, uma nova comida.
     *
     * @param pedido Pedido - pedido que vai ser editado.
     * @param item Item - item que vai ser adicionado.
     */
    public void inserirItem(Pedido pedido, Item item) {
        this.iRepositorioPedido.inserirItem(pedido, item);

    }

    /**
     * Método para remover um item do pedido.
     * @param pedido Pedido - pedido que vai ser editado.
     * @param item Item - item que vai ser removido.
     */
    public void removerItem(Pedido pedido, Item item) {
        this.iRepositorioPedido.removerItem(pedido, item);
    }

    /**
     * Método para gravar os pedidos ao encerrar o sistema.
     */
    public void gravarPedidos() {
        this.iRepositorioPedido.gravarPedidos();
    }

    /**
     * Método para ler o pedido de um arquivo
     */
    public void lerPedido() {
        this.iRepositorioPedido.lerPedido();
    }

    /**
     * Método para listar os pedidos abertos numa List.
     * @return List - lista contendo o endereco dos pedidos.
     */
    public List<Pedido> getListaPedidos() {
        return this.iRepositorioPedido.getListaPedidos();
    }

    /**
     * Método para retornar a lista de itens do pedido.
     * @param pedido Pedido - Pedido a ser consultado.
     * @return ArrayList - lista de itens do pedido.
     */
    public ArrayList<Item> getListaItens(Pedido pedido) {
        return this.iRepositorioPedido.getListaItens(pedido);
    }

    /**
     * Método para listar os pedidos, com número, tipo do pedido e horário.
     * @return String[] - Lista de pedidos.
     */
    public String[] listarPedidos() {
        return this.iRepositorioPedido.listarPedidos();
    }

    /**
     * Método para listar os pedidos encerrados.
     * @return String[] - retorna um array contendo o numero do pedido, a mesa (se tiver) e o horário
     * que o pedido foi feito.
     */
    public String[] listarPedidosEncerrados()
    {
        return this.iRepositorioPedido.listarPedidosEncerrados();
    }

    /**
     * Método para filtrar os pedidos pelo tipo deles.
     * @param categoria String - tipo do pedido: mesa, balcao, entrega.
     * @return String[] - array contendo os pedidos que sao do tipo determinado.
     */
    public String[] filtrarPedido(String categoria){
        return this.iRepositorioPedido.filtrarPedido(categoria);
    }

    /**
     * Método para listar os itens do pedido.
     * @param pedido Pedido- pedido consultado.
     * @return String[] - array contendo os itens do pedido.
     */
    public String[] listarItensPedido(Pedido pedido){
        return this.iRepositorioPedido.listarItensPedido(pedido);
    }

    /**
     * Método para listar os precos dos itens que estão no pedido.
     * @param pedido Pedido - pedido consultado.
     * @return String[] - array contendo os precos dos itens.
     */
     public String[] listarPrecosPedido(Pedido pedido)
     {
         return this.iRepositorioPedido.listarPrecosPedido(pedido);
     }

}
