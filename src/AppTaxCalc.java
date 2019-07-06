import java.util.Scanner;

public class AppTaxCalc {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("\nCalculadora AcceleratorTax");
            System.out.println("Menu de opções");
            System.out.println("\n1 - Gerar nota fiscal");
            System.out.println("0 - Sair");
            opcao = input.nextInt();
            switch(opcao) {
                case 1 : notaFiscal(); break;
                case 0 : return;
                default : System.out.println("Opcao Inválida");
            }

        }while(opcao!=0);

    }

    private static void notaFiscal(){
        Carga umaCarga = new Carga();
        Scanner input = new Scanner(System.in);
        int item=0;
        boolean continua;
        do{
            System.out.println("Insira o nome do cliente: ");
            System.out.println("Digite 0 para sair e mostrar resultado.");
            String cliente = input.next();
            if(cliente.equals("0")) break;
            System.out.println("Quantidade de energéticos: ");
            System.out.println("Digite 0 para sair e mostrar resultado.");
            int quantidade = input.nextInt();
            if(quantidade == 0) break;
            continua = umaCarga.addLoteB(cliente, quantidade);
            if (!continua) { System.out.println("Não foi possível inserir este registro."); break; }
            item++;
        }while(continua);
        if (item==0) { System.out.println("Não existem items para exibir."); return; }

        System.out.println(umaCarga);
    }
}
