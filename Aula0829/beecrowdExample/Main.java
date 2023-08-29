import java.io.IOException;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws IOException {

        //CONSUMO DA ENTRADA DO PROBLEMA
        Scanner sc = new Scanner (System.in);

        //1a linha -> int double double
        String [] linha = sc.nextLine().split(" ");

        int nroPessoas=Integer.parseInt(linha[0]);
        double garrafaTermica=Double.parseDouble(linha[1]);
        double cuia=Double.parseDouble(linha[2]);

        //2a linha -> strings
        String [] nomes = sc.nextLine().split(" ");

        //PROCESSAMENTO

        int nroCuiasServidas = (int) (garrafaTermica/cuia);
        double resto= garrafaTermica - (((double)nroCuiasServidas)*cuia);

        if(resto==0){
            nroCuiasServidas--;
            resto=cuia;
        }


        //SAIDA        
        //System.out.println("Nro de cuias: "+ nroCuiasServidas);
        //System.out.println("ultima pessoa: "+ nomes[nroCuiasServidas%nroPessoas]);
        //System.out.println("Qtde última cuia: "+ garrafaTermica%cuia);        
        System.out.printf("%s %.1f\n", nomes[nroCuiasServidas%nroPessoas], resto);

        sc.close();
        
 
    }
 
}