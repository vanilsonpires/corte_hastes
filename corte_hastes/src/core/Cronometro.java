package core;

public class Cronometro {
	
	private static long start;
	
	public static void start(){
		start = System.currentTimeMillis();
	}
	
	public static void stop(){
		long time = System.currentTimeMillis()-start;
		System.out.print("Tempo de execução: ");
		if(time>1000){
			if(time/1000 > 60){
				System.out.println(((time/1000)/60) +"minutos");
			}else{
				System.out.println(time/1000+" segundos");
			}
		}else{
			System.out.println(time+" milessegundos");
		}
		start = 0;
		System.out.println("");
	}

}
