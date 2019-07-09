import java.text.NumberFormat;

/**
 * Esta classe é o objeto Lote, utilizado na classe Carga, como vetor.
 * @author Gabriel Rabelo
 * @version e1 (primeira entrega)
 */

public class Lote {
    private String cliente;
    private int quantidade;
    private double valorUnitario;
    private double ICMS, IPI, PIS, COFINS;
    private boolean desconto;

    /**
     * Construtor da classe, inclui impostos e valor unitário do produto
     * @param cliente Nome do cliente
     * @param quantidade quantidade do produto para realizar o cálculo.
     */
    public Lote(String cliente, int quantidade, double valorUnitario, int desc, int qntDesc){
        if(Character.isLetter(cliente.charAt(0))) this.cliente = cliente ;
            else this.cliente = "Não informado";

        if (quantidade < 1) this.quantidade = 1;
            else this.quantidade = quantidade;

        if(valorUnitario<0) this.valorUnitario = 4.5f ;
        else this.valorUnitario = valorUnitario;

        if(desc > 0 && quantidade >= qntDesc) {
            this.valorUnitario = valorUnitario - calculaDesconto(desc, valorUnitario);
            desconto = true;
        }
        ICMS = 1.18f;
        IPI = 1.04f;
        PIS = 1.0186f;
        COFINS = 1.0854f;
    }

    /**
     * Getter do cliente, utilizado no toString
     * @return cliente
     */
    public String getCliente(){ return cliente; }

    /**
     * Getter da quantidade, utilizado para realizar cálculos dos valores.
     * @return
     */
    public int getQuantidade(){ return quantidade; }

    /**
     * Getter do valor unitário, utilizado para realizar calculo dos valores.
     * @return
     */
    public double getValorUnitario(){ return valorUnitario; }

    /**
     * Calcula o valor total do lote
     * @return valor total;
     */
    public double calculaValorTotal(){
        return getValorUnitario() * getQuantidade();
    }

    /**
     * Soma todos o total os impostos.
     * @return
     */
    public double calculaTotalTax() {
        return calculaValorTotal() + calculaICMS() + calculaIPI() + calculaPIS() + calculaCOFINS();
    }

    /**
     * Calcula o ICMS
     * @return valor apenas do ICMS calculado em cima do valor total do lote
     */
    public double calculaICMS() { return calculaValorTotal() * ICMS - calculaValorTotal(); }

    /**
     * Calcula o IPI
     * @return valor apenas do IPI calculado em cima do valor total do lote
     */
    public double calculaIPI() { return calculaValorTotal() * IPI - calculaValorTotal(); }

    /**
     * Calcula o PIS
     * @return valor apenas do PIS calculado em cima do valor total do lote
     */
    public double calculaPIS() { return calculaValorTotal() * PIS - calculaValorTotal(); }

    /**
     * Calcula o COFINS
     * @return valor apenas do COFINS calculado em cima do valor total do lote
     */
    public double calculaCOFINS() { return calculaValorTotal() * COFINS - calculaValorTotal(); }

    /**
     * Soma apenas os impostos.
     * @return
     */
    public double somaImpostos() {return calculaICMS() + calculaIPI() + calculaPIS() + calculaCOFINS(); }

    /**
     * Este método calcula o valor a ser descontado do produto, a partir de um valor pré-definido na classe main.
     * @param desconto desconto em unidades inteiras entre 0 e 100.
     * @param valorUnitario valor unitário do produto.
     * @return
     */
    public double calculaDesconto(int desconto, double valorUnitario){
        double desc = valorUnitario * desconto / 100;
        return desc;
    }

    public String toString(){
        return "\n\nCliente: " + getCliente() +
                "\nValor mercadorias: " + NumberFormat.getCurrencyInstance().format(calculaValorTotal()) +
                "\nICMS: " + NumberFormat.getCurrencyInstance().format(calculaICMS()) +
                "\nIPI: " + NumberFormat.getCurrencyInstance().format(calculaIPI()) +
                "\nPIS: " + NumberFormat.getCurrencyInstance().format(calculaPIS()) +
                "\nCOFINS: " + NumberFormat.getCurrencyInstance().format(calculaCOFINS()) +
                "\nTotal: " + NumberFormat.getCurrencyInstance().format(calculaTotalTax());

    }
}
