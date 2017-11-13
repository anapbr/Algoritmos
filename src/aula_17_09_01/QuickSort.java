package aula_17_09_01;

import auxiliares.Auxiliar;

public class QuickSort {

	public static void main(String[] args) {
		int A[] = {99,35,20,25,40,44,55,38,10,65,50};
		
		System.out.print("ENTRADA..: ");
		Auxiliar.imprimeVetor(A);

		A = quickSort(A, 0, A.length-1);
		
		System.out.print("\nSAÍDA....: ");
		Auxiliar.imprimeVetor(A);

	}

	public static int[] quickSort (int[] A, int p, int r) {
		if (p < r) {
			int q = Auxiliar.particione(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q + 1,r);
		}
		
		return A;
	}

}
