package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * implementa��o dinamica de baixo para cima do problema de corte de hastes
 * @author vanilson
 *
 */
public class HasteDinamicaBaixoCima {

    public static int bottomUpCutRod(int price[], int n) {
        int val[] = new int[n + 1];
        val[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max_val = Math.max(max_val,
                        price[j] + val[i - j - 1]);
            }
            val[i] = max_val;
        }
        return val[n];
    }

    public static void executar() throws FileNotFoundException {

        System.out.println("Entre com o diretorio do arquivo TXT:");

        Scanner sc = new Scanner(System.in);
        String arquivo = sc.nextLine();

        File file = new File(arquivo);//Leitura do arquivo TXT
        Scanner scan = null;

        ArrayList<Integer> vetorAux = new ArrayList<>();//Vetor Auxiliar

        scan = new Scanner(file);

        while (scan.hasNextLine()) {//Separa��o de Linhas e Colunas
            String[] campos = scan.nextLine().split(" ");
            vetorAux.add(Integer.parseInt(campos[0]));
        }

        int[] vetor = new int[vetorAux.size()];//Vetor Principal

        for (int i = 0; i < vetorAux.size(); i++) {//Passando Variaveis do vetor auxiliar para vetor principal
            vetor[i] = vetorAux.get(i);
        }

        Cronometro.start();
        int num = bottomUpCutRod(vetor, vetorAux.size());//Executando algoritimo
        System.out.println("Melhor valor possivel: " + num);//Mostrando o resultado final
        Cronometro.stop();

    }

}