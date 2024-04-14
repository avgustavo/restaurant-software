package restaurante.negocios;

import restaurante.repositorio.IRepositorioCardapio;
import restaurante.exception.ItemInexistenteException;
import restaurante.exception.ItemJaExistenteException;
import restaurante.exception.PrecoInvalidoException;
import restaurante.dados.cardapio.Item;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Puxa os métodos do RepositorioCardapio
 * @author joao Victor
 */
public class ControladorRepositorioItem {

    /**
 * Construtor do controlador.
 * @param iRepositorioCardapio IRepositorioCardapio - interface do repositório.
 */
    private IRepositorioCardapio repositorioCardapio;

    public ControladorRepositorioItem(IRepositorioCardapio repositorioCardapio) {
        this.repositorioCardapio = repositorioCardapio;
    }

    /**
     * Método que insere um item no cardápio.
     * @param item Item - item que vai ser inserido.
     * @throws ItemJaExistenteException
     */
    public void inserir(Item item) throws ItemJaExistenteException {
        repositorioCardapio.inserir(item);
    }

    /**
     * Remove um item do Cardápio a partir do código dele.
     * @param codigo String - código do item.
     * @throws ItemInexistenteException
     */
    public void remover(String codigo) throws ItemInexistenteException {
        repositorioCardapio.remover(codigo);
    }

    /**
     * Altera o preço do item do cardápio.
     * @param codigo String - código do item.
     * @param valor Double - preço do item.
     * @throws PrecoInvalidoException
     * @throws ItemInexistenteException
     */
    public void alterarPreco(String codigo, double valor) throws PrecoInvalidoException, ItemInexistenteException {
        repositorioCardapio.alterarPreco(codigo, valor);
    }

    /**
     * Método para consultar item no cardápio.
     * @param codigo String - código do item.
     * @return Item - endereço do item que tem esse código.
     * @throws ItemInexistenteException
     */
    public Item consultarItem(String codigo) throws ItemInexistenteException {
        return repositorioCardapio.consultar(codigo);
    }
    /**
     * Método que pega um arquivo txt e transforma num arraylist.
     * @throws FileNotFoundException
     * @throws ItemJaExistenteException
     */
    public void lerCardapio() throws FileNotFoundException, ItemJaExistenteException{
        repositorioCardapio.lerCardapio();
    }
    /**
     * Salva as alterações
     */
    public void salvarAlteracoesItem(){
        repositorioCardapio.salvarAlteracoes();
    }

    /**
     * Lista todos os nomes dos itens do cardápio.
     * @return String[] - array com o nome dos itens.
     */
    public String[] listarItens() {
        return this.repositorioCardapio.listarItens();
    }

    /**
     * Lista os nomes dos itens que são de determinada categoria.
     * @param categoria String - categoria: Entrada, Pratos, Sobremesas, Bebidas;
     * @return String - lista de itens da categoria.
     */
    public String[] listarItensCategoria(String categoria){
        return this.repositorioCardapio.listarItensCategoria(categoria);
    }

    /**
     * Método que irá listar todos os precos de uma categoria.
     * @param categoria String - tipo de item que se deseja listar os precos.
     * @return String - lista de precos da categoria.
     */
    public String[] listarPrecosCategoria(String categoria){
        return this.repositorioCardapio.listarPrecosCategoria(categoria);
    }

    /**
     * Método que lista a arraylist do cardápio.
     * @return ArrayList - lista de todos os itens do cardápio.
     */
    public ArrayList<Item> listarItensArray(){
        return this.repositorioCardapio.listarItensArray();
    }
}
