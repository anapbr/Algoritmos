package aula_17_09_01;

public class QuickSort {

	public static void main(String[] args) {
		int A[] = {99,35,20,25,40,44,55,38,10,65,50};
		
		int i=0;
		System.out.print("ENTRADA..: ");
		while (i<A.length) {
			System.out.print(A[i++] + " ");	
		}
		
		A = quickSort(A, 0, A.length-1);
		
		i=0;
		System.out.print("\nSA�DA....: ");
		while (i<A.length) {
			System.out.print(A[i++] + " ");	
		}
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

		int x = A[r]; // x � o piv�
		int i = p-1;
		for (int j=p; j< r; j++) {
			if (A[j] <= x) {
				i++;
				troca(A, i, j);
			}
			
		}
		troca (A, i+1, r);
		return i+1;
		
	}
	
    /**
     * Realiza a troca de posi��o de dois elementos do vetor.
     * @param A Vetor que contem os dados
     * @param i Primeira posi��o de troca
     * @param j Segunda posi��o de troca
     */
    public static void troca(int[] A, int i, int j) {
        int aux = A[i];
        A[i] = A[j];
        A[j] = aux;
    }
}