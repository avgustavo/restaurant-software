package restaurante.repositorio;

import restaurante.repositorio.IRepositorioCardapio;
import restaurante.exception.ItemInexistenteException;
import restaurante.exception.ItemJaExistenteException;
import restaurante.exception.PrecoInvalidoException;
import restaurante.dados.cardapio.Item;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author joao Victor
 * Lista dos metodos que são usados no RepositorioCardapio
 */

public interface IRepositorioCardapio {

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
     * Método para consultar item no cardápio.
     * @param codigo String - código do item.
     * @return Item - endereço do item que tem esse código.
     * @throws ItemInexistenteException
     */
    public Item consultar(String codigo) throws ItemInexistenteException;

    /**
     * Método que pega um arquivo txt e transforma num arraylist.
     * @throws FileNotFoundException
     * @throws ItemJaExistenteException
     */
    public void lerCardapio() throws FileNotFoundException, ItemJaExistenteException;

    /**
     * Método chamado quando é feito alguma alteracao no cardapio. Ele salva no arquivo cardapio.txt as alteracoes.
     */
    public void salvarAlteracoes();

    /**
     * Lista todos os nomes dos itens do cardápio.
     * @return String[] - array com o nome dos itens.
     */
    public String[] listarItens();

    /**
     * Lista os nomes dos itens que são de determinada categoria.
     * @param categoria String - categoria: Entrada, Pratos, Sobremesas, Bebidas;
     * @return String - lista de itens da categoria.
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
    
   
    

}
