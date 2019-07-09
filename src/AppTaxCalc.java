import java.util.Scanner;

public class AppTaxCalc {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\fCalculadora AcceleratorTax");
            System.out.println("   ===Menu===");
            System.out.println("\n1 - Gerar nota fiscal");
            System.out.println("2 - Configurar desconto");
            System.out.println("0 - Sair");
            opcao = input.nextInt();

            switch(opcao) {
                case 1 :
                    notaFiscal(); break;
                case 2 :
                    System.out.println("Em construção."); break;
                case 0 : return;
                default : System.out.println("Opcao Inválida");
            }

        }while(opcao!=0);

    }

    private static void notaFiscal(){
        Carga umaCarga = new Carga();
        Scanner input = new Scanner(System.in);

        String cliente;
        int item=0, quantidade;
        boolean addLote;

        do{
            do{
                System.out.println("Insira o nome do cliente: ");
                System.out.println("Digite 0 para sair e mostrar resultado.");
                cliente = input.nextLine();
                if(cliente.equals("0")) break;
            }while(Character.isDigit(cliente.charAt(0)));
            if(cliente.equals("0")) break;

            do {
                System.out.println("Quantidade de energéticos: ");
                System.out.println("Digite 0 para sair e mostrar resultado.");
                quantidade = input.nextInt();
            }while(quantidade<0);
            if(quantidade <= 0) break;

            input.nextLine();
            addLote = umaCarga.addLoteB(cliente, quantidade);
            if (!addLote) { System.out.println("Não foi possível inserir este registro."); break; }
            item++;
        }while(addLote);

        if (item==0) { System.out.println("Não existe item a ser exibido."); return; }

        System.out.println(umaCarga);

        System.out.println("\nDigite qualquer coisa para retornar ao menu.");
        int menu = input.nextInt();

    }
}

