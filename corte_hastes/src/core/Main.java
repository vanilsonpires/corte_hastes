package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		while (true) {

			try {
				Scanner sc = new Scanner(System.in);

				int op = 0;

				System.out.println("Entre com umas das opções abaixo\n"
						+ "1 - Corte de haste / implementação recursiva de cima para baixo\n"
						+ "2 - Corte de haste / implementação dinâmica de cima para baixo com memoização\n"
						+ "3 - Corte de haste / implementação dinâmica de baixo para cima\n"
						+ "4 - Seleção de atividades / algoritmo guloso iterativo\n" + "5 - Encerrar Programa");

				op = sc.nextInt();

				switch (op) {
				case 1:
					HasteRecursivaCimaBaixo.executar();
					break;
				case 2:
					HasteDinamicaCimaBaixoMemorization.executar();
					break;
				case 3:
					HasteDinamicaBaixoCima.executar();
					break;
				case 4:
					GulosoInterativo.executar();
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Este não é uma opção valida!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
