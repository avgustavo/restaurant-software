package restaurante.dados.cardapio;
/**
 * 
 * @author joão Victor
 */
public class Item {
    private String codigo; //identificacao do produto
    private String nome; //nome do item
    private String tipo; //entrada, prato principal, sobremesa, bebida
    private double valor; //preco do produto

    /**
     * Método que retorna o valor deste item.
     * @return double - o valor do item.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Método que altera o valor do item.
     * @param valor - novo valor do item.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Método que retorna o tipo do item.
     * @return String - o tipo do item.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método que altera o tipo do item.
     * @param tipo - novo tipo do item.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método que retorna o nome do item.
     * @return String - o nome do item.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera o nome do item.
     * @param nome - novo nome do item.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna o codigo do item.
     * @return String - o codigo do item.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método que altera o codigo do item.
     * @param codigo - novo codigo do item.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que cria um novo item com base nos parâmetros recebidos.
     * @param codigo - codigo do novo item.
     * @param nome - nome do novo item.
     * @param tipo - tipo do novo item.
     * @param valor - valor do novo item.
     */
    public Item(String codigo, String nome, String tipo, double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    /**
     * Método que retorna uma String que descreve os atributos do item.
     * @return String - descreve os atributos do item.
     */
    @Override
    public String toString() {
        return "Codigo: " + this.codigo + ", Nome: " + this.nome +
                ", Tipo do item: " + this.tipo + ", Valor: " + this.valor;
    }

}
