package aula_17_09_01;

import auxiliares.Auxiliar;

public class QuickSortAleatorio {

	public static void main(String[] args) {

		int A[] = {99,35,20,25,40,44,55,38,10,65,50};
		
		System.out.print("ENTRADA..: ");
		Auxiliar.imprimeVetor(A);
		
		A = quickSortAleatorio(A, 0, A.length-1);
		
		System.out.print("\nSAÍDA....: ");
		Auxiliar.imprimeVetor(A);

	}

	public static int[] quickSortAleatorio (int[] A, int p, int r) {
		
		if (p < r) {
			int q = Auxiliar.particioneAleatorio(A, p, r);
			quickSortAleatorio(A, p, q-1);
			quickSortAleatorio(A, q+1, r);	
		}
		
		return A;
	}
	
}
