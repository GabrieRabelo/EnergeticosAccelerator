/**
 * Esta classe é o objeto Lote, utilizado ... [completar descrição]
 * @author Gabriel Rabelo
 * @version e1 (primeira entrega)
 */

public class Lote {
    private String cliente;
    private int quantidade;
    private double valorUnitario;
    private double ICMS, IPI, PIS, COFINS;

    public Lote(String cliente, int quantidade){
        if(Character.isLetter(cliente.charAt(0))) this.cliente = cliente ;
            else this.cliente = "Não informado";
        if (quantidade < 1) this.quantidade = 1;
            else this.quantidade = quantidade;
        valorUnitario = 4.5;
        ICMS = 1.18;
        IPI = 1.04;
        PIS = 1.0186;
        COFINS = 1.0854;
    }

    public void setCliente(String cliente){
        if(Character.isLetter(cliente.charAt(0))) this.cliente = cliente ;
        else this.cliente = "Não informado";
    }

    public void setQuantidade(int quantidade){
        if (quantidade < 0) this.quantidade = quantidade;
    }

    public void setValor(double valor){
        if (valor < 0 ) this.valorUnitario = 4.5;
            else this.valorUnitario = valor;
    }

    public String getCliente(){ return cliente; }
    public int getQuantidade(){ return quantidade; }
    public double getValorUnitario(){ return valorUnitario; }


    public double calculaValorTotal(){
        return getValorUnitario() * getQuantidade();
    }

    public double calculaTotalTax() { return calculaValorTotal();}

    public double calculaICMS() { return calculaValorTotal() * ICMS - calculaValorTotal(); }
    public double calculaIPI() { return calculaValorTotal() * IPI - calculaValorTotal(); }
    public double calculaPIS() { return calculaValorTotal() * PIS - calculaValorTotal(); }
    public double calculaCOFINS() { return calculaValorTotal() * COFINS - calculaValorTotal(); }


    public String toString(){
        return "\n\nCliente: " + getCliente() + "\nICMS: " + calculaICMS() + "\nIPI: " + calculaIPI() + "\nPIS: " +
                calculaPIS() + "\nCOFINS: " + calculaCOFINS() + "\nTotal: ";
    }
}
