package aula_17_09_15;

public class HeapSort {

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

	private static void imprimeVetor (int[] A) {
		int j = 0;
		while (j < A.length) {
			System.out.print(A[j++] + " ");
		}
	}
	
    private static void heapSort(int A[], int n) {
        maxHeap(A, n);                      
        int m = n + 1;                          
        for (int i = n; i >= 0; i--) {          
            troca(A, 0, i);                     
            m--;                          
            maxHeapify(A, m, 0);                
        }
    }
	
	public static void maxHeap(int[] A, int n) {

		// OBSERVAÇÃO: i = n/2; i receberá o piso da divisão
		for (int i = n/2; i >= 0; i--) {
			maxHeapify(A, n, i);
		}
	}
	
	public static void maxHeapify(int[] A, int n, int i) {
		
		// Filhos sempre está nas posições 2*i e 2*i + 1
		int e = 2 * i;
		int d = 2 * i + 1;
		int maior;

		if (e < n && A[e] > A[i]) {
			maior = e;
		} else {
			maior = i;
		}

		if (d < n && A[d] > A[maior]) {
			maior = d;
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

}
