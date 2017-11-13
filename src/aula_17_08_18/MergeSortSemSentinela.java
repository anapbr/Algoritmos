/*
 * INTERCALA DOIS SUBVETORES PREVIAMENTE ORDENADOS *** COM SENTINELA ***
 *
 */

package aula_17_08_18;

import auxiliares.Auxiliar;

public class MergeSortSemSentinela {

	public static void main(String[] args) {
		int A[] = {22,33,55,77,99,11,44,66,88};

		System.out.print("ENTRADA..: ");
		Auxiliar.imprimeVetor(A);
		
		System.out.println();
		
		//Apesar de haver n elementos, r é o ÍNDICE, logo, n-1 é a sua posição!
		int n = A.length - 1;
		mergeSort(A, 0, n);
		
		System.out.print("\n\nSAÍDA....: ");
		Auxiliar.imprimeVetor(A);

	}

	public static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (int) Math.floor((p+r)/2);
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			mergeSemSentinela(A, p, q, r);
		}
		
	}

	/*
     * @param A Vetor a ser ordenado
	 * @param q Pivo do vetor
	 * @param p Inicio do vetor
	 * @param r Fim do vetor
	 * */
    
	private static void mergeSemSentinela(int[] A, int p, int q, int r) {
		
		int[] B = new int[r+1];
		
		for (int i=p; i<=q; i++) {
			B[i] = A[i];
		}
		
		for (int j = q + 1; j<=r; j++) {
			B[r + q + 1 - j] = A[j];
		}
		
		int i = p;
		int j = r;	
		
		for (int k = p; k<=r; k++) {
			if (B[i] <= B[j]) {
				A[k] = B[i];
				System.out.println("Pivô="+q+" Início="+p+" Fim="+r);
				System.out.println(B[i]+"<="+B[j]);
				System.out.println("   A["+k+"]="+A[k]);
				i++;
			} else {
				A[k] = B[j];
				System.out.println("Pivô="+q+" Início="+p+" Fim="+r);
				System.out.println(B[i]+">="+B[j]);
				System.out.println("   A["+k+"]="+A[k]);
				j--;
			}
			
			System.out.println();
		}
	}
	
}
