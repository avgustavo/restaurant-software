package restaurante.fachada;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import restaurante.dados.cardapio.Item;

import restaurante.dados.pedido.Pedido;
import restaurante.exception.*;

import restaurante.negocios.ControladorRepositorioPedido;

import restaurante.repositorio.*;

import restaurante.negocios.ControladorRepositorioItem;

/**
 * @author Carlos Henrique
 * @author Lucas
 */
public class Fachada implements IFachada {

    private ControladorRepositorioItem controladorRepositorioItem;
    private ControladorRepositorioPedido controladorRepositorioPedido;
    

    private static Fachada instancia = null;

    //SINGLETON
    public static Fachada getInstancia()
    {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    private Fachada() {
        IRepositorioCardapio repositorioCardapio = new RepositorioCardapio();
        IRepositorioPedido iRepositorioPedido = new RepositorioPedido();
       
        controladorRepositorioPedido = new ControladorRepositorioPedido(iRepositorioPedido);
        controladorRepositorioItem = new ControladorRepositorioItem(repositorioCardapio);
       
    }

    //***********I T E N S  D O  C A R D Á P I O*********************
    /**
     * Método para consultar item no cardápio.
     * @param codigo String - código do item.
     * @return Item - endereço do item que tem esse código.
     * @throws ItemInexistenteException
     */
    @Override
    public Item consultarItem(String codigo) throws ItemInexistenteException {
        return controladorRepositorioItem.consultarItem(codigo);
    }

    /**
     * Método que insere um item no cardápio.
     * @param item Item - item que vai ser inserido.
     * @throws ItemJaExistenteException
     */
    @Override
    public void inserir(Item item) throws ItemJaExistenteException {
        controladorRepositorioItem.inserir(item);
    }
    
    /**
     * Remove um item do Cardápio a partir do código dele.
     * @param codigo String - código do item.
     * @throws ItemInexistenteException
     */
    @Override
    public void remover(String codigo) throws ItemInexistenteException {
        controladorRepositorioItem.remover(codigo);
    }

    /**
     * Altera o preço do item do cardápio.
     * @param codigo String - código do item.
     * @param valor Double - preço do item.
     * @throws PrecoInvalidoException
     * @throws ItemInexistenteException 
     */
    @Override
    public void alterarPreco(String codigo, double valor) throws PrecoInvalidoException, ItemInexistenteException {
        controladorRepositorioItem.alterarPreco(codigo, valor);
    }

    /**
     * Lê o cardápio, arquivo .txt, do diretório.
     * @throws FileNotFoundException
     * @throws ItemJaExistenteException 
     */
    @Override
    public void lerCardapio() throws FileNotFoundException, ItemJaExistenteException {
        controladorRepositorioItem.lerCardapio();
    }

    /**
     * Método chamado quando é feito alguma alteracao no cardapio. Ele salva no arquivo cardapio.txt as altercoes.
     */
    @Override
    public void salvarAlteracoesItem() {
        controladorRepositorioItem.salvarAlteracoesItem();
    }

    /**
     * Lista todos os nomes dos itens do cardápio.
     * @return String[] - array com o nome dos itens.
     */
    @Override
    public String[] listarItens() {
        return this.controladorRepositorioItem.listarItens();
    }
    
    /**
     * Lista os nomes dos itens que são de determinado tipo.
     * @param categoria String - tipo do item, entrada, pratos, sobremesas, bebidas. 
     * @return String - lista de nomes da categoria.
     */
    public String[] listarItensCategoria(String categoria){
        return this.controladorRepositorioItem.listarItensCategoria(categoria);
    }

    /**
     * Método que irá listar todos os precos de uma categoria.
     * @param categoria String - tipo de item que se deseja listar os precos.
     * @return String - lista de precos da categoria.
     */
    public String[] listarPrecosCategoria(String categoria){
        return this.controladorRepositorioItem.listarPrecosCategoria(categoria);
    }

    /**
     * Método que lista a arraylist do cardápio.
     * @return ArrayList - lista de todos os itens do cardápio.
     */
    public ArrayList<Item> listarItensArray(){
        return this.controladorRepositorioItem.listarItensArray();
    }
    
    //*********** P E D I D O *********************
    /**
     * Método para listar os pedidos abertos numa ArrayList.
     * @return ArrayList - contem os pedidos abertos.
     */
    public ArrayList<Pedido> listarPedidosEncerradosArray(){
        return this.controladorRepositorioPedido.listarPedidosEncerradosArray();
    }

    /**
     * Método para listar os pedidos encerrados numa arrayList.
     * @return ArrayList - contem os pedidos encerrados.
     */
    public ArrayList<Pedido> listarPedidosArray()
    {
        return this.controladorRepositorioPedido.listarPedidosArray();
    }
    /**
     * Método para inserir um novo pedido no repositório de pedidos(ArrayList)
     *
     * @param pedido Pedido - novo pedido
     */
    @Override
    public void inserirPedido(Pedido pedido) {
        this.controladorRepositorioPedido.inserirPedido(pedido);
    }

    /**
     * Método para encerrar um pedido, fechar a conta.
     *
     * @param pedido Pedido - pedido que vai ser encerrado
     */
    @Override
    public void encerrarPedido(Pedido pedido) {
        this.controladorRepositorioPedido.encerrarPedido(pedido);
    }

    /**
     * Método para adicionar um novo item no pedido, uma nova comida.
     *
     * @param pedido Pedido - pedido que vai ser editado.
     * @param item Item - item que vai ser adicionado.
     */
    @Override
    public void inserirItem(Pedido pedido, Item item) {//deve gravar no arquivo
        this.controladorRepositorioPedido.inserirItem(pedido, item);

    }

    /**
     * Método para remover um item do pedido.
     *
     * @param pedido Pedido - pedido que vai ser editado.
     * @param item Item - item que vai ser removido.
     */
    @Override
    public void removerItem(Pedido pedido, Item item) {//deve gravar no arquivo
        this.controladorRepositorioPedido.removerItem(pedido, item);
    }

    /**
     * Método para ler o pedido de um arquivo
     */
    @Override
    public void lerPedido() {// deve ler os dados do pedido e copiar para uma lista, com o preço e tudo.
        this.controladorRepositorioPedido.lerPedido();
    }

    /**
     * Método para gravar os pedidos ao encerrar o sistema.
     */
    public void gravarPedidos(){
        this.controladorRepositorioPedido.gravarPedidos();
    }


    /**
     * Método para listar os pedidos abertos numa List.
     * @return List - lista contendo o endereco dos pedidos.
     */
    @Override
    public List<Pedido> getListaPedidos() {
        return this.controladorRepositorioPedido.getListaPedidos();
    }

    /**
     * Método para retornar a lista de itens do pedido.
     * @param pedido Pedido - Pedido a ser consultado.
     * @return ArrayList - lista de itens do pedido.
     */
    public ArrayList<Item> getListaItens(Pedido pedido){
        return this.controladorRepositorioPedido.getListaItens(pedido);
    }

    /**
     * Método para listar os pedidos, com número, tipo do pedido e horário.
     * @return String[] - Lista de pedidos.
     */
    @Override
    public String[] listarPedidos() {
        return this.controladorRepositorioPedido.listarPedidos();
    }

    /**
     * Método para listar os pedidos encerrados.
     * @return String[] - retorna um array contendo o numero do pedido, a mesa (se tiver) e o horário
     * que o pedido foi feito.
     */
    public String[] listarPedidosEncerrados()
    {
        return this.controladorRepositorioPedido.listarPedidosEncerrados();
    }

    /**
     * Método para filtrar os pedidos pelo tipo deles.
     * @param categoria String - tipo do pedido: mesa, balcao, entrega.
     * @return String[] - array contendo os pedidos que sao do tipo determinado.
     */
    public String[] filtrarPedido(String categoria){
        return this.controladorRepositorioPedido.filtrarPedido(categoria);
    }

    /**
     * Método para listar os itens do pedido.
     * @param pedido Pedido- pedido consultado.
     * @return String[] - array contendo os itens do pedido.
     */
    public String[] listarItensPedido(Pedido pedido){
        return this.controladorRepositorioPedido.listarItensPedido(pedido);
    }

    /**
     * Método para listar os precos dos itens que estão no pedido.
     * @param pedido Pedido - pedido consultado.
     * @return String[] - array contendo os precos dos itens.
     */
    public String[] listarPrecosPedido(Pedido pedido)
     {
         return this.controladorRepositorioPedido.listarPrecosPedido(pedido);
     }


}
