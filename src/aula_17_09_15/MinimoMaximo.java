package aula_17_09_15;

import auxiliares.Auxiliar;

public class MinimoMaximo {

	public static void main(String[] args) {
		
		int A[] = { 99, 35, 20, 25, 40, 44, 55, 38, 10, 65, 50, 12 };
		int n = A.length;
		
		System.out.print("Vetor analisado: ");
		Auxiliar.imprimeVetor(A);
		
		int[] resultado = minMax(A, n);
		
		System.out.println("\n\nM�nimo: " + resultado[0] + "\nM�ximo: " + resultado[1]);
		
	}

	public static int[] minMax (int[] A, int n) {
		
		// Para �ndice...
		// [0] : m�nimo
		// [1] : m�ximo
		int[] valores = new int[2];

		valores[0]=A[0];
		valores[1]=A[0];
		
		for (int j=1; j<n; j++) {

			if (A[j] < valores[0]) 
				valores[0] = A[j];

			if (A[j] > valores[1]) 
				valores[1] = A[j];
		}
		
		return valores;
	}
}
