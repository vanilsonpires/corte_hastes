package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * implementação recursiva de cima para baixo do problema de corte de hastes
 * @author vanison
 *
 */
public class HasteRecursivaCimaBaixo {//

    public static int cutRod(int n, int[] preco) {
        if (n <= 0) {
            return 0;
        }
        int valMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            valMax = Math.max(valMax, preco[i] + cutRod(n - i - 1, preco));
        }
        return valMax;

    }

    public static void executar() throws FileNotFoundException {

        System.out.println("Entre com o diretorio do arquivo TXT:");

        Scanner sc = new Scanner(System.in);
        String arquivo = sc.nextLine();

        File file = new File(arquivo);//Leitura do arquivo TXT
        Scanner scan = null;

        ArrayList<Integer> vetorAux = new ArrayList<>();//Vetor Auxiliar

        scan = new Scanner(file);

        while (scan.hasNextLine()) {//Separação de Linhas e Colunas
            String[] campos = scan.nextLine().split(" ");
            vetorAux.add(Integer.parseInt(campos[0]));
        }

        int[] vetor = new int[vetorAux.size()];//Vetor Principal

        for (int i = 0; i < vetorAux.size(); i++) {//Passando Variaveis do vetor auxiliar para vetor principal
            vetor[i] = vetorAux.get(i);
        }

        Cronometro.start();
        int num = cutRod(vetorAux.size(), vetor);//Executando algoritimo
        System.out.println("Melhor valor possivel: " + num);//Mostrando o resultado final
        Cronometro.stop();
    }

}
