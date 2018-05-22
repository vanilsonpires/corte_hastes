package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ReadFile {
	
	private List<String[]> dados;
	private static final String SEPARATOR = " ";
	private File file;
	
	public ReadFile(File file) {
		this.file = file;
		lerArquivo();
	}
	
	/**
	 * Método que faz a leitura do arquivo CSV
	 * @author Vanilson Pires
	 * @date 2018-03-18
	 * @param arquivo
	 * @return
	 */
	private boolean lerArquivo() {
		
		BufferedReader br = null;
		
		try {
			if (file != null && !file.getName().equals("")) {

				//Ler o nome do arquivo
				String sNomeArquivo = file.getName();
				
				//Ler a extensao do arquivo
				String extensao = getFileExtension(sNomeArquivo);
				
				//Faz a verificação para permitir o processamento somente de arquivos em CSV
				if (extensao.equalsIgnoreCase("csv") || extensao.equalsIgnoreCase("txt")) {				
					
					InputStream in = new FileInputStream(file); //Cria um stream para manusear os dados do arquivo
					InputStreamReader isr = new InputStreamReader(in, "UTF-8"); //Especifica o formato em UTF-8
					br = new BufferedReader(isr); // Gera o arquivo em Buffered
					
					//Inicia a leitura do aquivo
					String s = null;
					int qtd = 0;
					
					while((s = br.readLine()) !=null) {
						qtd++;						
						if(qtd!=1){
							// Separa cada dado da linha em um vetor	
							dados.add(s.split(SEPARATOR)); //Adiciona os arquivos na lista..
						}
					};
					return true;
				}else {
					System.err.println("Somente arquivos 'CSV' podem ser lidos. Por favor tente novamente!");
					return false;
				}				
			} else {
				System.err.println("Arquivo não selecionado ou inválido. Favor tente novamente!");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Retorna a extensão do arquivo
	 * @author Vanilson Pires
	 * @date 2018-03-18
	 * @param fileName
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		int index = fileName.lastIndexOf('.');
		if (index > 0 && index < fileName.length() - 1) {
			return fileName.substring(index + 1).toLowerCase();
		} else {
			return "";
		}
	}
	
	public List<String[]> getDados() {
		return dados;
	}
}
