package restaurante.repositorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import restaurante.dados.cardapio.Item;
import restaurante.dados.pedido.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gustavo 
 * @author Lucas
 * @author Carlos Henrique
 * @version 3.0
 */
public class RepositorioPedido implements IRepositorioPedido {
    private List<Pedido> pedidos = new ArrayList();
    //private static int indice = 0;
    private List<Pedido> pedidosEncerrados = new ArrayList();
    public static double receita = 0.0;

    /**
     * Método para listar os pedidos abertos numa ArrayList.
     * @return ArrayList - contem os pedidos abertos.
     */
    @Override
    public ArrayList<Pedido> listarPedidosArray()
    {
        return (ArrayList<Pedido>) this.pedidos;
    }

    /**
     * Método para listar os pedidos encerrados numa arrayList
     * @return ArrayList - contem os pedidos encerrados.
     */
     @Override
    public ArrayList<Pedido> listarPedidosEncerradosArray()
    {
        return (ArrayList<Pedido>) this.pedidosEncerrados;
    }

    /**
     * Método para adicionar um novo pedido.
     * @param pedido Pedido - pedido a ser adicionado.
     */
    @Override
    public void inserirPedido(Pedido pedido) {
        pedidos.add(pedido);
        // deve gravar no arquivo
    }


    /**
     * Método para encerrar um pedido.
     * @param pedido Pedido - pedido que vai ser encerrado.
     */
    @Override
    public void encerrarPedido(Pedido pedido) {// deve gravar no arquivo

        pedido.setPedidoEncerrado(true);
        receita += pedido.getValor();
        pedidos.remove(pedido);
        pedidosEncerrados.add(pedido);

    }

    /**
     * Método para inserir um novo item no pedido.
     * @param pedido Pedido - pedido consultado.
     * @param item Item - item a ser adicionado.
     */
    @Override
    public void inserirItem(Pedido pedido, Item item) {
        pedido.inserirItem(item);

    }

    /**
     * Método para remover um item do pedido.
     * @param pedido Pedido - pedido consultado.
     * @param item Item - item a ser removido.
     */
    @Override
    public void removerItem(Pedido pedido, Item item) {
        pedido.removerItem(item);
    }
    /**
     * Método para ler o pedido de um arquivo.
     */
    @Override
    public void lerPedido() {// deve ler os dados do pedido e copiar para uma lista, com o preço e tudo.

    }

    /**
     * Método para gravar os pedidos ao encerrar o sistema.
     */
    @Override
    public void gravarPedidos() {
        try {
            File arquivo = new File("PedidosDoDia.txt");
            FileWriter fw = new FileWriter(arquivo, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (Pedido pedido : this.pedidosEncerrados) {
                pw.printf("*Pedido%d*\n", pedidosEncerrados.indexOf(pedido) + 1);
                for (int i = 0; i < pedido.getItens().size(); i++) {
                    pw.println(pedido.getItens().get(i).toString());
                }
                pw.println(pedido.getFormaPagamento() + ", " + pedido.getHoraPedido() + ", " + pedido.getValor());
            }
            pw.println("Receita do dia: " + RepositorioPedido.receita);
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para listar os pedidos abertos numa List.
     * @return List - lista contendo o endereco dos pedidos.
     */
    @Override
    public List<Pedido> getListaPedidos() {
        return this.pedidos;
    }

    /**
     * Método para listar num ArrayList os itens do pedido.
     * @param pedido Pedido- pedido consultado.
     * @return ArrayList - contem os itens do pedido.
     */
    @Override
    public ArrayList<Item> getListaItens(Pedido pedido) {
        return pedido.getItens();
    }

    /**
     * Método para listar os pedidos, com número, tipo do pedido e horário.
     * @return String[] - Lista de pedidos.
     */
    @Override
    public String[] listarPedidos() {
        String[] retorno = new String[pedidos.size()];
        int i = 0;
        for (Pedido p : pedidos) {

            if (!p.isPedidoEncerrado()) {
                if (p instanceof PedidoMesa) {
                    retorno[i] = p.getNumero() + "- Pedido Mesa: " + ((PedidoMesa) p).getMesa() + ", Horario: " + p.getHoraPedido();
                } else if (p instanceof PedidoBalcao) {
                    retorno[i] = p.getNumero() + "- Pedido Balcao" + ", Horario: " + p.getHoraPedido();
                } else if (p instanceof PedidoEntrega) {
                    retorno[i] = p.getNumero() + "- Pedido Entrega" + ", Horario: " + p.getHoraPedido();
                }
                i++;
            }

        }
        return retorno;
    }

    /**
     * Método para listar os pedidos encerrados.
     * @return String[] - retorna um array contendo o numero do pedido, a mesa (se tiver) e o horário
     * que o pedido foi feito.
     */
    @Override
    public String[] listarPedidosEncerrados() {
        String[] retorno = new String[pedidosEncerrados.size()];
        int i = 0;
        for (Pedido p : pedidosEncerrados) {

            if (p.isPedidoEncerrado()) {
                if (p instanceof PedidoMesa) {
                    retorno[i] = p.getNumero() + "- Pedido Mesa: " + ((PedidoMesa) p).getMesa() + ", Horario: " + p.getHoraPedido();
                } else if (p instanceof PedidoBalcao) {
                    retorno[i] = p.getNumero() + "- Pedido Balcao" + ", Horario: " + p.getHoraPedido();
                } else if (p instanceof PedidoEntrega) {
                    retorno[i] = p.getNumero() + "- Pedido Entrega" + ", Horario: " + p.getHoraPedido();
                }
                i++;
            }

        }
        return retorno;
    }

    /**
     * Método para filtrar os pedidos pelo tipo deles.
     * @param categoria String - tipo do pedido: mesa, balcao, entrega.
     * @return String[] - array contendo os pedidos que sao do tipo determinado.
     */
    public String[] filtrarPedido(String categoria) {
        String[] tipoPedido = new String[pedidos.size()];
        int i = 0;
        for (Pedido p : pedidos) {

            if (!p.isPedidoEncerrado()) {
                if (categoria == "mesa") {
                    if (p instanceof PedidoMesa) {
                        tipoPedido[i] = p.getNumero() + "- Pedido Mesa: " + ((PedidoMesa) p).getMesa() + ", Horario: " + p.getHoraPedido();
                    } 
                } else if(categoria == "balcao"){
                    if (p instanceof PedidoBalcao) {
                        tipoPedido[i] = p.getNumero() + "- Pedido Balcao" + ", Horario: " + p.getHoraPedido();
                    }
                } else if (categoria == "entrega"){
                    if (p instanceof PedidoEntrega) {
                        tipoPedido[i] = p.getNumero() + "- Pedido Entrega" + ", Horario: " + p.getHoraPedido();
                    }
                }
                i++;
            }
        }
        return tipoPedido;
    }

    /**
     * Método para listar os itens do pedido.
     * @param pedido Pedido - pedido consultado.
     * @return String[] - array contendo os itens do pedido.
     */
    public String[] listarItensPedido(Pedido pedido) {
        String[] itensPedido = new String[pedido.getItens().size()];
        int j = 0;
        for (Item i : pedido.getItens()) {
            itensPedido[j] = i.getNome();
            j++;
        }
        return itensPedido;
    }

    /**
     * Método para listar os precos dos itens que estão no pedido.
     * @param pedido Pedido - pedido consultado.
     * @return String[] - array contendo os precos dos itens.
     */
    public String[] listarPrecosPedido(Pedido pedido) {
        String[] valorItens = new String[pedido.getItens().size()];
        int j = 0;
        for (Item i : pedido.getItens()) {
            valorItens[j] = ""+i.getValor();
            j++;
        }
        return valorItens;
    }
   
}
