/**
 * ****** REFAZER ******
 * Esta classe é o objeto Carga, vetor de lotes ... [concluir descrição]
 * @author Gabriel Rabelo
 * @version e1 (primeira entrega)
 */

public class Carga{
    private Lote[] carga;
    private double totalCarga, valorCargaTax;

    public Carga(){
        carga = new Lote[20];
        totalCarga = 0;
        valorCargaTax = 0;
    }

    public double getTotalCarga() { return totalCarga; }
    public double getValorCargaTax() { return valorCargaTax; }

    /**
     * Este método percorre o vetor e verifica se algum índice está nulo
     * @return false se encontrar algum índice diferente de nulo
     */
    public boolean estaVazia(){
        for(int i=0;i<carga.length;i++){
            if(carga[i]!=null) return false;
        }
        return true;
    }

    public void calculaTotalCarga(){
        if(estaVazia()) return;
        for(int i=0; i<carga.length;i++){

        }
    }


}
