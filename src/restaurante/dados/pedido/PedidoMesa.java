package restaurante.dados.pedido;

public class PedidoMesa extends Pedido{
    
    private String mesa;

    public PedidoMesa(String mesa) {
        super();
        this.mesa=mesa;
    }
    
    public String getMesa()
    {
        return this.mesa;
    }
}
