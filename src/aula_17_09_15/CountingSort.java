package aula_17_09_15;

import auxiliares.Auxiliar;

public class CountingSort {

	public static void main(String[] args) {

		int[] A = {2, 3, 1, 0, 2, 3, 3, 1, 5};
		int[] B = new int[A.length];
		
		int n = A.length;
		int k = maiorElemento(A); // Busca o maior elemento a fim de determinar o range de n�mero de 0..maiorElemento!
		countingSort(A, B, n, k);
	
	}
	
	public static int maiorElemento (int[] A) {

		int maior=A[0];
		
		for (int j=1; j < A.length; j++) {
			if(A[j]>maior)
				maior=A[j];
		}
		
		return maior;
	}
	
	/*
	 * A - Array original
	 * B - Vetor com os dados ordenados
	 * n - N�mero de elementos do array original
	 * k - At� que valor pode variar os elementos do array. Ex.: Se k=10, ent�o n�o h� elementos maiores que 10!
	 * 
	 * */
	public static void countingSort(int[] A, int[] B, int n, int k) {
		
		// Se k varia at� 5, ou seja, de 0 a 5, ent�o s�o necess�rios k+1 elementos
		int[] C = new int[k+1];
		
		// Zera o array
		for (int i=0; i<=k; i++)
			C[i] = 0;

		System.out.println("Vetor Zerado: ");
		Auxiliar.imprimeVetor(C);
		
		// NESTE PONTO, C armazena as quantidades de cada um dos elementos contidos no array original A
		// Note que cada �ndice do array C corresponde ao respectivo valor do elemento contabilizado
		// O conte�do em cada �ndice corresponde � quantidade deste elemento no array A de entrada
		// Ex.:
		// A = {2, 3, 1, 0, 2, 3, 3, 1, 5}
		// C = {1, 2, 2, 3, 0, 1} 
		for (int j=0; j<n;j++)
			C[A[j]]++;

		System.out.println("\n\nVetor com as quantidades: ");
		Auxiliar.imprimeVetor(C);
		
		// NESTE PONTO, o conte�do do array C � sobrescrito de forma a armazenar as "fronteiras" de
		// cada elemento. Aproveitando o exemplo anterior, ter�amos:
		// SE C = {1, 2, 2, 3, 0, 1} 
		// ENT�O C = {1, 3, 5, 8, 8, 9}
		for (int i=1; i<=k; i++)
			C[i] = C[i] + C[i-1];

		System.out.println("\n\nVetor com os delimitadores: ");
		Auxiliar.imprimeVetor(C);
		
		for (int j=n-1; j>=0; j--) {
			System.out.println("\n\nPara j="+j);
			B[C[A[j]]-1] = A[j];
			Auxiliar.imprimeVetor(A);
			C[A[j]] = C[A[j]]-1;
		}
	}
	
}
