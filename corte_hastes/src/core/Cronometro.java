package core;

public class Cronometro {
	
	private static long start;
	
	public static void start(){
		start = System.currentTimeMillis();
	}
	
	public static void stop(){
		long time = System.currentTimeMillis()-start;
		System.out.print("Tempo de execução: ");
		if(((double)time)>1000.0){
			if(time/1000 > 60){
				System.out.println((((double)time/1000.0)/60.0) +"minutos");
			}else{
				System.out.println(((double)time)/1000.0+" segundos");
			}
		}else{
			System.out.println(time+" milessegundos");
		}
		start = 0;
		System.out.println("");
	}

}
