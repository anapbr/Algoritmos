package aula_17_09_15;

public class HeapSort {

	/*
	 * Conceitos:
	 * heap: árvore binária ordenada
	 * max heap: heap onde nós pais são maiores que os respectivos nós filhos
	 * 
	 * Passo a passo:
	 * 
	 * 1. Cria a max heap
	 * 2. Remove o maior elemento
	 * 3. Coloca este elemento em parte ordenada
	 * 
	 * Quando o maior elemento é removido da heap, a mesma fica "desequilibra"
	 * 
	 * Como a max heap já havia sido previamente criada, é necessário realizar pequenos ajustes
	 * 
	 * Os ajustes serão realizados através do heapify
	 * Agora que voltamos a ter uma max heap, repetimos os processo.
	 * 
	 * Até que todos os elementos tenham sido marcados como ordenados.
	 * */
	
	public static void main(String[] args) {
		
		int A[] = { 99, 35, 20, 25, 40, 44, 55, 38, 10, 65, 50, 12 };
		int n = A.length;
		
		System.out.print("ENTRADA....: ");
		imprimeVetor(A);

		// n representa o número de elementos
		// Logo, o índice deve variar de 0 a n-1 elementos.
		// Portanto, o último índice é n-1
		heapSort(A, n-1);

		System.out.print("\nSAÍDA......: ");
		imprimeVetor(A);

	}

    private static void heapSort(int A[], int n) {
        buildMaxHeap(A, n);                      
        int m = n + 1;                          
        for (int i = n; i >= 0; i--) {          
            troca(A, 0, i);                     
            m--;                          
            maxHeapify(A, m, 0);                
        }
    }
	
    // Cria a Max Heap a partir de um array não ordenado
	public static void buildMaxHeap(int[] A, int n) {

		// OBSERVAÇÃO: i = n/2; i receberá o piso da divisão
		for (int i = n/2; i >= 0; i--) {
			maxHeapify(A, n, i);
		}
	}
	
	// Similar ao buildMaxHeap, porém assume que partes do array já estão ordenadas
	public static void maxHeapify(int[] A, int n, int i) {
		
		// Filhos sempre está nas posições 2*i e 2*i + 1
		int esquerda = 2 * i;
		int direita = 2 * i + 1;
		int maior;

		if (esquerda < n && A[esquerda] > A[i]) {
			maior = esquerda;
		} else {
			maior = i;
		}

		if (direita < n && A[direita] > A[maior]) {
			maior = direita;
		}

		if (maior != i) {
			troca(A, i, maior);
			System.out.println("\nn="+n);
			imprimeVetor(A);
			maxHeapify(A, n, maior);
		}
	}

	/* Troca a posição dos elementos i e j no vetor A */
	public static void troca(int[] A, int i, int j) {
		int auxAI = A[i];
		A[i] = A[j];
		A[j] = auxAI;
	}

	/* Método auxiliar */
	private static void imprimeVetor (int[] A) {
		int j = 0;
		while (j < A.length) {
			System.out.print(A[j++] + " ");
		}
	}
	
}
