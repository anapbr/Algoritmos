package aula_17_09_15;

import auxiliares.Auxiliar;

public class Minimo {

	public static void main(String[] args) {

		int A[] = { 99, 35, 20, 25, 40, 44, 55, 38, 10, 65, 50, 12 };
		int n = A.length;
		
		System.out.print("Vetor analisado: ");
		Auxiliar.imprimeVetor(A);
		
		System.out.println("\n\nValor mínimo: " + minimo(A, n));
	
	}

    public static int minimo(int[] A, int n) {
	
    	int minimo = A[0];
    	
		for (int j=1; j<n; j++) {
			if (minimo > A[j]) {
				minimo = A[j];				
			}	 			
		}
		
		return minimo;
   }
}