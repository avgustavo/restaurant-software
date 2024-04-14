package restaurante.dados.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import restaurante.dados.cardapio.Item;

/**
 * @author Gustavo
 * @author Lucas
 * @author Carlos Henrique
 */
public abstract class Pedido {

     protected ArrayList<Item> itens;
     protected String formaPagamento;
     protected LocalDateTime horaPedido;
     protected boolean pedidoEncerrado;
     protected double valor = 0.0;
     protected static int contador = 0;
     protected int numero;

     /**
      * Construtor de Pedido
      */
    public Pedido() {
        this.itens = new ArrayList();
        this.horaPedido = LocalDateTime.now();
        this.formaPagamento = null;
        this.pedidoEncerrado = false;
        contador++;
        this.numero = contador;
     }

    /**
     * Método que retorna a lista de itens do pedido.
     * @return ArrayList - lista dos itens no pedido.
     */
     public ArrayList<Item> getItens() {
        return itens;
    }

    /**
     * Método que retorna um Array de Strings que é a lista de nomes e valores dos itens no pedido.
     * @return ArraList - lista em String dos nomes e valores de itens no pedido.
     */
     public ArrayList<String> getItensString() {
        ArrayList<String> array = new ArrayList<String>();
        
        for(Item item : this.itens)
        {
            array.add(item.getNome()+'-'+item.getValor());
        }
         return array;
    }


    /**
     * Método que configura os itens no Array de itens.
     * @param itens ArrayList - a lista de itens.
     */
    public void setItens(ArrayList<Item> itens) {
        valor=0.0;
        for(Item item : itens)
        {
            valor = valor+item.getValor();
        }
        this.itens = itens;
    }

    /**
     * Método que retorna a forma em que o pedido foi pago.
     * @return String - forma do pagamento.
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * Método que define como o pedido será pago.
     * @param formaPagamento String - maneira como o pedido será pago.
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * Método que retorna a hora do sistema.
     * @return LocalDateTime - a hora do sistema naquela instância.
     */
    public LocalDateTime getHoraPedido() {
        return horaPedido;
    }

    /**
     * Método que define a hora em que o pedido foi feito.
     * @param horaPedido LocalDateTime - horário definido para o pedido.
     */
    public void setHoraPedido(LocalDateTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    /**
     * Método que retorna se o pedido está encerrado.
     * @return boolean - true se foi encerrado, false se está aberto.
     */
    public boolean isPedidoEncerrado() {
        return pedidoEncerrado;
    }

    /**
     * Método que define um pedido como encerrado.
     * @param pedidoEncerrado boolean - atributo que define um pedidocomo encerrado.
     */
    public void setPedidoEncerrado(boolean pedidoEncerrado) {
        this.pedidoEncerrado = pedidoEncerrado;
    }

    /**
     * Método que irá pôr um item em um pedido.
     * @param item Item - item a ser adicionado.
     */
    public void inserirItem(Item item)
    {
        itens.add(item);
        valor = valor + item.getValor();
    }

    /**
     * Método que removerá um item de um pedido.
     * @param item Item - o item a ser removido.
     */
    public void removerItem(Item item){
        itens.remove(item);
        valor = valor - item.getValor();
    }

    /**
     * Método que retorna o preco do pedido.
     * @return double - preco do pedido.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Método que altera o preco do pedido.
     * @param valor double - preco do pedido.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Método que retorna a numeracao do pedido.
     * @return int - numero do pedido.
     */
    public int getNumero()
    {
        return this.numero;
    }

    /**
     * Método que altera o numero do pedido.
     * @param numero int - numero do pedido.
     */
    public void setNumero(int numero){this.numero = numero;}
}

