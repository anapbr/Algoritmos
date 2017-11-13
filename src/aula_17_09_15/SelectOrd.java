package aula_17_09_15;

import aula_17_08_18.MergeSortComSentinela;
import auxiliares.Auxiliar;

public class SelectOrd {

	public static void main(String[] args) {
	
		int A[] = { 99, 35, 20, 25, 40, 44, 55, 38, 10, 65, 50, 12 };
		int n = A.length;
		int i = 3;
		System.out.print("Vetor analisado: ");
		Auxiliar.imprimeVetor(A);
		
		System.out.println("\n\n"+ i +"º menor valor: " + selectOrdenado(A, n-1, i));

		System.out.print("Vetor ordenado: ");
		Auxiliar.imprimeVetor(A);
		
	}
	
	public static int selectOrdenado(int[] A, int n, int i) {
		HeapSort.heapSort(A, n);
		return A[i-1]; // Correção para contar do 1º ao n-ésimo termo
	}
}
