package restaurante.fachada;

import restaurante.dados.cardapio.Item;

import restaurante.exception.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import restaurante.dados.pedido.Pedido;

/**
 * @author Lucas
 * @author Carlos Henrique
 */
public interface IFachada {

    //***********I T E N S  D O  C A R D Á P I O*********************
    /**
     * Método para consultar item no cardápio.
     * @param codigo String - código do item.
     * @return Item - endereço do item que tem esse código.
     * @throws ItemInexistenteException
     */
    public Item consultarItem(String codigo) throws ItemInexistenteException;

    /**
     * Método que insere um item no cardápio.
     * @param item Item - item que vai ser inserido.
     * @throws ItemJaExistenteException
     */
    public void inserir(Item item) throws ItemJaExistenteException;

    /**
     * Remove um item do Cardápio a partir do código dele.
     * @param codigo String - código do item.
     * @throws ItemInexistenteException
     */
    public void remover(String codigo) throws ItemInexistenteException;

    /**
     * Altera o preço do item do cardápio.
     * @param codigo String - código do item.
     * @param valor Double - preço do item.
     * @throws PrecoInvalidoException
     * @throws ItemInexistenteException
     */
    public void alterarPreco(String codigo, double valor) throws PrecoInvalidoException, ItemInexistenteException;

    /**
     * Lê o cardápio, arquivo .txt, do diretório.
     * @throws FileNotFoundException
     * @throws ItemJaExistenteException
     */
    public void lerCardapio() throws FileNotFoundException, ItemJaExistenteException;

    /**
     * Método chamado quando é feito alguma alteracao no cardapio. Ele salva no arquivo cardapio.txt as altercoes.
     */
    public void salvarAlteracoesItem();

    /**
     * Lista todos os nomes dos itens do cardápio.
     * @return String[] - array com o nome dos itens.
     */
    public String[] listarItens();

    /**
     * Lista os nomes dos itens que são de determinado tipo.
     * @param categoria String - tipo do item, entrada, pratos, sobremesas, bebidas.
     * @return String - lista de nomes da categoria.
     */
    public String[] listarItensCategoria(String categoria);

    /**
     * Método que irá listar todos os precos de uma categoria.
     * @param categoria String - tipo de item que se deseja listar os precos.
     * @return String - lista de precos da categoria.
     */
    public String[] listarPrecosCategoria(String categoria);

    /**
     * Método que lista a arraylist do cardápio.
     * @return ArrayList - lista de todos os itens do cardápio.
     */
    public ArrayList<Item> listarItensArray();

    //*********** P E D I D O *********************
    /**
     * Método para listar os pedidos abertos numa ArrayList.
     * @return ArrayList - contem os pedidos abertos.
     */
    public ArrayList<Pedido> listarPedidosArray();

    /**
     * Método para listar os pedidos encerrados numa arrayList.
     * @return ArrayList - contem os pedidos encerrados.
     */
    public ArrayList<Pedido> listarPedidosEncerradosArray();

    /**
     * Método para inserir um novo pedido no repositório de pedidos(ArrayList)
     *
     * @param pedido Pedido - novo pedido
     */
    public void inserirPedido(Pedido pedido);

    /**
     * Método para encerrar um pedido, fechar a conta.
     *
     * @param pedido Pedido - pedido que vai ser encerrado
     */
    public void encerrarPedido(Pedido pedido);

    /**
     * Método para adicionar um novo item no pedido, uma nova comida.
     *
     * @param pedido Pedido - pedido que vai ser editado.
     * @param item Item - item que vai ser adicionado.
     */
    public void inserirItem(Pedido pedido, Item item);

    /**
     * Método para remover um item do pedido.
     *
     * @param pedido Pedido - pedido que vai ser editado.
     * @param item Item - item que vai ser removido.
     */
    public void removerItem(Pedido pedido, Item item);

    /**
     * Método para ler o pedido de um arquivo
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
     * Método para retornar a lista de itens do pedido.
     * @param pedido Pedido - Pedido a ser consultado.
     * @return ArrayList - lista de itens do pedido.
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
    public String[] listarPedidosEncerrados();
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
