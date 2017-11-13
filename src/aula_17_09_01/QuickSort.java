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
			int q = particione(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q + 1,r);
		}
		
		return A;
	}
	public static int particione (int[] A, int p, int r) {

		int x = A[r]; // x é o pivô
		int i = p-1;
		for (int j=p; j< r; j++) {
			if (A[j] <= x) {
				i++;
				Auxiliar.troca(A, i, j);
			}
			
		}
		Auxiliar.troca (A, i+1, r);
		return i+1;
		
	}

}
