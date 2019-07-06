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

    /**
     * Construtor da classe, inclui impostos e valor unitário do produto
     * @param cliente Nome do cliente
     * @param quantidade quantidade do produto para realizar o cálculo.
     */
    public Lote(String cliente, int quantidade){
        if(Character.isLetter(cliente.charAt(0))) this.cliente = cliente ;
            else this.cliente = "Não informado";
        if (quantidade < 1) this.quantidade = 0;
            else this.quantidade = quantidade;
        valorUnitario = 4.5;
        ICMS = 1.18;
        IPI = 1.04;
        PIS = 1.0186;
        COFINS = 1.0854;
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

    public double calculaTotalTax() { return calculaValorTotal() + calculaICMS() + calculaIPI() + calculaPIS() +
            calculaCOFINS();}

    public double calculaICMS() { return calculaValorTotal() * ICMS - calculaValorTotal(); }
    public double calculaIPI() { return calculaValorTotal() * IPI - calculaValorTotal(); }
    public double calculaPIS() { return calculaValorTotal() * PIS - calculaValorTotal(); }
    public double calculaCOFINS() { return calculaValorTotal() * COFINS - calculaValorTotal(); }

    public double somaImpostos() {return calculaICMS() + calculaIPI() + calculaPIS() + calculaCOFINS(); }

    public String toString(){
        return "\n\nCliente: " + getCliente() + "\nICMS: R$" + calculaICMS() + "\nIPI: R$" + calculaIPI() + "\nPIS: R$" +
                calculaPIS() + "\nCOFINS: R$" + calculaCOFINS() + "\nTotal: R$" + calculaTotalTax();
    }
}
