/**
 * ****** REFAZER ******
 * Esta classe é o objeto Carga, vetor de lotes.
 * @author Gabriel Rabelo
 * @version e1 (primeira entrega)
 */

public class Carga{
    private Lote[] carga;
    private int pos;

    public Carga(){
        carga = new Lote[20];
        pos = 0;
    }


    public boolean estaCheia(){
        for(int i=0;i<carga.length;i++){
            if(carga[i]==null) return false;
        }
        return true;
    }

    public boolean addLoteB(String cliente, int quantidade) {
        if (estaCheia()) return false;
        carga[pos] = new Lote(cliente, quantidade);
        pos++;
        return true;
    }

    public double totalImpostos(){
        double soma=0;
        for(int i = 0; i<carga.length;i++){
            if(carga[i]!=null){
                soma += carga[i].somaImpostos();
            }
        }
        return soma;
    }

    public double totalMercadorias(){
        double soma=0;
        for(int i = 0; i<carga.length;i++){
            if(carga[i]!=null){
                soma += carga[i].calculaValorTotal();
            }
        }
        return soma;
    }

    public String toString(){
        double totalGeral = totalImpostos() + totalMercadorias();
        String msg="";

        for(int i=0; i<carga.length;i++){
            if(carga[i]==null) break;
            msg += carga[i] + " ";
        }

        msg += "\n\nTotal Impostos: R$" + totalImpostos() + "\nTotal Mercadorias: R$" + totalMercadorias() +
        "\nTotal Geral: R$" + totalGeral;

        return msg;
    }


}
