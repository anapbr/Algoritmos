package aula_17_09_01;

import java.util.Random;

public class QuickSortAleatorio {

	public static void main(String[] args) {

		int A[] = {99,35,20,25,40,44,55,38,10,65,50};
		
		int i=0;
		System.out.print("ENTRADA..: ");
		while (i<A.length) {
			System.out.print(A[i++] + " ");	
		}
		
		A = quickSortAleatorio(A, 0, A.length-1);
		
		i=0;
		System.out.print("\nSAÍDA....: ");
		while (i<A.length) {
			System.out.print(A[i++] + " ");	
		}

	}

	public static int[] quickSortAleatorio (int[] A, int p, int r) {
		
		if (p < r) {
			int q = particioneAleatorio(A, p, r);
			quickSortAleatorio(A, p, q-1);
			quickSortAleatorio(A, q+1, r);	
		}
		
		return A;
	}

	private static int particioneAleatorio(int[] A, int p, int r) {

		Random random = new Random();
		
		int i = p + (Math.abs(random.nextInt()) % (r-p+1));
		
		troca(A, i, r);

		return particione (A, p, r);
	}
	
	public static int particione (int[] A, int p, int r) {

		int x = A[r]; // x é o pivô
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
     * Realiza a troca de posição de dois elementos do vetor.
     * @param A Vetor que contem os dados
     * @param i Primeira posição de troca
     * @param j Segunda posição de troca
     */
    public static void troca(int[] A, int i, int j) {
        int aux = A[i];
        A[i] = A[j];
        A[j] = aux;
    }
	
}
