package restaurante.repositorio;

import restaurante.repositorio.IRepositorioCardapio;
import restaurante.exception.ItemInexistenteException;
import restaurante.exception.ItemJaExistenteException;
import restaurante.exception.PrecoInvalidoException;
import restaurante.dados.cardapio.Item;

import java.io.FileNotFoundException;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author joão victor
 *
 */

public class RepositorioCardapio implements IRepositorioCardapio {

    private List<Item> itensCardapio = new ArrayList();

    /**
     * Método que insere um item no cardápio.
     * @param item Item - item que vai ser inserido.
     * @throws ItemJaExistenteException
     */
    @Override
    public void inserir(Item item) throws ItemJaExistenteException {
        try {
            if (consultar(item.getCodigo()) != null) {
                throw new ItemJaExistenteException();
            }
        } catch (ItemInexistenteException ex) {
            itensCardapio.add(item);
        }

        salvarAlteracoes();
    }

    /**
     * Remove um item do Cardápio a partir do código dele.
     * @param codigo String - código do item.
     * @throws ItemInexistenteException
     */
    @Override
    public void remover(String codigo) throws ItemInexistenteException {
        try {
            Item itemRemover = consultar(codigo);
            if (itemRemover != null) {
                this.itensCardapio.remove(itemRemover);
            }
        } catch (ItemInexistenteException ex) {
            throw ex;
        }

        salvarAlteracoes();
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
        try {
            Item itemAlterar = consultar(codigo);
            if (itemAlterar != null) {
                if (valor > 0) {
                    itemAlterar.setValor(valor);
                } else {
                    throw new PrecoInvalidoException();
                }
            }
        } catch (ItemInexistenteException ex) {
            throw ex;
        }

        salvarAlteracoes();
    }

    /**
     * Método para consultar item no cardápio.
     * @param codigo String - código do item.
     * @return Item - endereço do item que tem esse código.
     * @throws ItemInexistenteException
     */
    @Override
    public Item consultar(String codigo) throws ItemInexistenteException {
        Item itemBuscado = null;
        for (Item item : this.itensCardapio) {
            if (item.getCodigo().equals(codigo)) {
                itemBuscado = item;
                break;
            }
        }
        if (itemBuscado == null) {
            throw new ItemInexistenteException();
        }
        return itemBuscado;
    }

    /**
     * Método que pega um arquivo txt e transforma num arraylist.
     * @throws FileNotFoundException
     * @throws ItemJaExistenteException
     */
    @Override
    public void lerCardapio() throws FileNotFoundException, ItemJaExistenteException { //converter o arquivo para uma arraylist
        //codigo, nome, tipo, valor

        Scanner scanner = new Scanner(new File("Cardapio.txt"));

        while (scanner.hasNext()) {
            String linha = scanner.nextLine();

            Scanner linhaScanner = new Scanner(linha);
            linhaScanner.useLocale(Locale.US);
            linhaScanner.useDelimiter(", ");

            String valor1 = linhaScanner.next();
            String valor2 = linhaScanner.next();
            String valor3 = linhaScanner.next();
            double valor4 = linhaScanner.nextDouble();

            Item item = new Item(valor1, valor2, valor3, valor4);
            try {
                inserir(item);
            } catch (ItemJaExistenteException ex) {
                ex.printStackTrace();
            }
//             itensCardapio.add(item);

        }
    }

    /**
     * Método chamado quando é feito alguma alteracao no cardapio. Ele salva no arquivo cardapio.txt as alteracoes.
     */
    @Override
    public void salvarAlteracoes() {

        try {
            FileWriter fw = new FileWriter("Cardapio.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

//            pw.println();
            for (Item item : this.itensCardapio) {
                pw.println(item.getCodigo() + ", " + item.getNome() + ", " + item.getTipo() + ", " + item.getValor());
            }

            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Lista todos os nomes dos itens do cardápio.
     * @return String[] - array com o nome dos itens.
     */
    @Override
    public String[] listarItens() {
        try {
            lerCardapio();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepositorioCardapio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ItemJaExistenteException ex) {
            Logger.getLogger(RepositorioCardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] itens = new String[itensCardapio.size()];
        int i = 0;
        for (Item item : itensCardapio) {

            itens[i] = item.getNome();

            i++;
        }
        return itens;
    }

    /**
     * Lista os nomes dos itens que são de determinado tipo.
     * @param categoria String - tipo de item que se deseja listar os nomes.
     * @return String - lista de nomes da categoria.
     */
    public String[] listarItensCategoria(String categoria) {
        String[] itens;
        itens = new String[itensCardapio.size()];
        int j = 0;
        for (Item i : itensCardapio) {
            if (i.getTipo().equals(categoria)) {
                itens[j] = i.getNome();
                j++;
            }
        }
        String[] itensCategoria = new String[j];
        for (int k = 0; k < j; k++) {
            itensCategoria[k] = itens[k];
        }
        return itensCategoria;
    }

    /**
     * Método que irá listar todos os precos de uma categoria.
     * @param categoria String - tipo de item que se deseja listar os precos.
     * @return String - lista de precos da categoria.
     */
    public String[] listarPrecosCategoria(String categoria) {
        String[] itens;
        itens = new String[itensCardapio.size()];
        int j = 0;
        for (Item i : itensCardapio) {
            if (i.getTipo().equals(categoria)) {
                itens[j] = ""+i.getValor();
                j++;
            }
        }
        String[] precosCategoria = new String[j];
        for (int k = 0; k < j; k++) {
            precosCategoria[k] = itens[k];
        }
        return precosCategoria;
    }

    /**
     * Método que lista a arraylist do cardápio.
     * @return ArrayList - lista de todos os itens do cardápio.
     */
    @Override
    public ArrayList<Item> listarItensArray() {
        return (ArrayList<Item>) this.itensCardapio;
    }
}
