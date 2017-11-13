package aula_17_09_15;

import auxiliares.Auxiliar;

public class SelectNL {

	public static void main(String[] args) {
		int A[] = { 99, 35, 20, 25, 40, 44, 55, 38, 10, 65, 50, 12 };
		int n = A.length;
		int i = 3;
		System.out.print("Vetor analisado: ");
		Auxiliar.imprimeVetor(A);
		
		System.out.println("\n\n"+ i +"º menor valor: " + selecaoNL(A, 0, n-1, i)); // n-1 pois refere-se ao índice do n-ésimo elemento

		System.out.print("Vetor ordenado: ");
		Auxiliar.imprimeVetor(A);
	}

	public static int selecaoNL(int[] A, int p, int r, int i) {

		if (p == r) 
			return A[p];
	
		int q = Auxiliar.particione(A, p, r);
		
		int k = q - p + 1;
		
		if (i==k) {
			return A[q];
		} else {
			if (i<k) {
				return selecaoNL(A, p, q-1, i);
			} else {
				return selecaoNL(A, q+1, r, i-k);
			}
			
		}
	}
}
