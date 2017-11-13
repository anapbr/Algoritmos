package aula_17_09_15;

public class HeapSort {

	/*
	 * Conceitos:
	 * heap: �rvore bin�ria ordenada
	 * max heap: heap onde n�s pais s�o maiores que os respectivos n�s filhos
	 * 
	 * Passo a passo:
	 * 
	 * 1. Cria a max heap
	 * 2. Remove o maior elemento
	 * 3. Coloca este elemento em parte ordenada
	 * 
	 * Quando o maior elemento � removido da heap, a mesma fica "desequilibra"
	 * 
	 * Como a max heap j� havia sido previamente criada, � necess�rio realizar pequenos ajustes
	 * 
	 * Os ajustes ser�o realizados atrav�s do heapify
	 * Agora que voltamos a ter uma max heap, repetimos os processo.
	 * 
	 * At� que todos os elementos tenham sido marcados como ordenados.
	 * */
	
	public static void main(String[] args) {
		
		int A[] = { 99, 35, 20, 25, 40, 44, 55, 38, 10, 65, 50, 12 };
		int n = A.length;
		
		System.out.print("ENTRADA....: ");
		imprimeVetor(A);

		// n representa o n�mero de elementos
		// Logo, o �ndice deve variar de 0 a n-1 elementos.
		// Portanto, o �ltimo �ndice � n-1
		heapSort(A, n-1);

		System.out.print("\nSA�DA......: ");
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
	
    // Cria a Max Heap a partir de um array n�o ordenado
	public static void buildMaxHeap(int[] A, int n) {

		// OBSERVA��O: i = n/2; i receber� o piso da divis�o
		for (int i = n/2; i >= 0; i--) {
			maxHeapify(A, n, i);
		}
	}
	
	// Similar ao buildMaxHeap, por�m assume que partes do array j� est�o ordenadas
	public static void maxHeapify(int[] A, int n, int i) {
		
		// Filhos sempre est� nas posi��es 2*i e 2*i + 1
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

	/* Troca a posi��o dos elementos i e j no vetor A */
	public static void troca(int[] A, int i, int j) {
		int auxAI = A[i];
		A[i] = A[j];
		A[j] = auxAI;
	}

	/* M�todo auxiliar */
	private static void imprimeVetor (int[] A) {
		int j = 0;
		while (j < A.length) {
			System.out.print(A[j++] + " ");
		}
	}
	
}
