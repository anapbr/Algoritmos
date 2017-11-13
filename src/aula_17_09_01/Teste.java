package aula_17_09_01;

import java.util.Random;

public class Teste {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		System.out.println("De 2 a 5");
		
		for (int j = 1; j<30; j++) {
			
			int i = 2 + (Math.abs(random.nextInt()) % (5-2+1));
			System.out.print(i + " ");	
		}
		
	}

}
