import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Esta classe é a Main do aplicativo calculador de taxa,  desenvolvido para o processo seletivo
 * da Aceleradora Agil ThoughtWorks.
 * @author Gabriel Rabelo
 * @version e1 (primeira entrega)
 */

public class AppTaxCalc {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int opcao;
        double valorUnitario=4.5;
        int desc=0, qntDesc=0;

        do{
            System.out.println("\nCalculadora AcceleratorTax");
            System.out.println("Valor do energético: " + NumberFormat.getCurrencyInstance().format(valorUnitario));
            if(desc>0 && qntDesc>0)
                System.out.println("Desconto aplicado: " + desc + "%, quando vendido mais de " + qntDesc + " energéticos.");
            else System.out.println("Sem desconto aplicado.");
            System.out.println("\n   ===Menu===");
            System.out.println("\n1 - Gerar nota fiscal");
            System.out.println("2 - Alterar valor");
            System.out.println("3 - Alterar desconto");
            System.out.println("4 - Redefinir valores padrão");
            System.out.println("0 - Sair");
            opcao = input.nextInt();

            switch(opcao) {
                case 1 :
                    notaFiscal(valorUnitario, desc, qntDesc); break;
                case 2:
                    do{
                        System.out.println("Informe o novo valor do energético: ");
                        valorUnitario = input.nextDouble();
                        if(valorUnitario == 0 ) { valorUnitario = 4.5; break; }
                    }while(valorUnitario<0);
                    break;
                case 3 :
                    do {
                        System.out.println("Quantos porcento de desconto você deseja aplicar? (Sem usar símbolo (%)) EX: 10");
                        desc = input.nextInt();
                        if(desc == 0) { System.out.println("Desconto zerado."); return; }
                    }while(desc<0 || desc>99);
                    do{
                        System.out.println("Digite a quantidade energéticos que torna este desconto válido: ");
                        qntDesc = input.nextInt();
                    }while(qntDesc<1);
                    break;
                case 4:
                    if(desc == 0 && qntDesc==0 && valorUnitario == 4.5){
                        System.out.println("Valores já estão padrão");
                        break;
                    }
                    desc = 0; qntDesc = 0; valorUnitario = 4.5;
                    System.out.println("Valores redefinidos.");
                    break;
                case 0 : return;
                default : System.out.println("Opcao Inválida");
            }

        }while(opcao!=0);

    }

    private static void notaFiscal(double valorProduto, int desc, int qntDesc){
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
            addLote = umaCarga.addLoteB(cliente, quantidade, valorProduto, desc, qntDesc);
            if (!addLote) { System.out.println("Limite de registros atingido."); break; }
            item++;
        }while(addLote);

        if (item==0) { System.out.println("Não existe item a ser exibido."); return; }

        System.out.println(umaCarga);

        System.out.println("\nDigite qualquer coisa para retornar ao menu.");
        int menu = input.nextInt();

    }
}

