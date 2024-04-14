package restaurante.repositorio;

import java.util.ArrayList;
import restaurante.dados.pedido.Pedido;
import restaurante.dados.cardapio.Item;

import java.util.List;

/**
 * @author Gustavo
 * @author Lucas
 * @author Carlos Henrique
 */
public interface IRepositorioPedido {

    /**
     * Método para listar os pedidos abertos numa ArrayList.
     * @return ArrayList - contem os pedidos abertos.
     */
    public ArrayList<Pedido> listarPedidosArray();

    /**
     * Método para listar os pedidos encerrados numa arrayList
     * @return ArrayList - contem os pedidos encerrados.
     */
    public String[] listarPedidosEncerrados();

    /**
     * Método para adicionar um novo pedido.
     * @param pedido Pedido - pedido a ser adicionado.
     */
    public void inserirPedido(Pedido pedido);

    /**
     * Método para encerrar um pedido.
     * @param pedido Pedido - pedido que vai ser encerrado.
     */
    public void encerrarPedido(Pedido pedido);

    /**
     * Método para inserir um novo item no pedido.
     * @param pedido Pedido - pedido consultado.
     * @param item Item - item a ser adicionado.
     */
    public void inserirItem(Pedido pedido, Item item);

    /**
     * Método para remover um item do pedido.
     * @param pedido Pedido - pedido consultado.
     * @param item Item - item a ser removido.
     */
    public void removerItem(Pedido pedido, Item item);

    /**
     * Método para ler o pedido de um arquivo.
     */
    public void lerPedido();

    /**
     * Método para gravar os pedidos ao encerrar o sistema.
     */
    public void gravarPedidos();

    /**
     * Método para listar os pedidos abertos numa List.
     * @return List - lista contendo o endereco dos pedidos.
     */
    public List<Pedido> getListaPedidos();

    /**
     * Método para listar num ArrayList os itens do pedido.
     * @param pedido Pedido- pedido consultado.
     * @return ArrayList - contem os itens do pedido.
     */
    public ArrayList<Item> getListaItens(Pedido pedido);

    /**
     * Método para listar os pedidos, com número, tipo do pedido e horário.
     * @return String[] - Lista de pedidos.
     */
    public String[] listarPedidos();

    /**
     * Método para listar os pedidos encerrados.
     * @return String[] - retorna um array contendo o numero do pedido, a mesa (se tiver) e o horário
     * que o pedido foi feito.
     */
    public ArrayList<Pedido> listarPedidosEncerradosArray();

    /**
     * Método para filtrar os pedidos pelo tipo deles.
     * @param categoria String - tipo do pedido: mesa, balcao, entrega.
     * @return String[] - array contendo os pedidos que sao do tipo determinado.
     */
    public String[] filtrarPedido(String categoria);

    /**
     * Método para listar os itens do pedido.
     * @param pedido Pedido - pedido consultado.
     * @return String[] - array contendo os itens do pedido.
     */
    public String[] listarItensPedido(Pedido pedido);

    /**
     * Método para listar os precos dos itens que estão no pedido.
     * @param pedido Pedido - pedido consultado.
     * @return String[] - array contendo os precos dos itens.
     */
    public String[] listarPrecosPedido(Pedido pedido);

}
