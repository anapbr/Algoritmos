package auxiliares;

import java.util.Random;

public class Auxiliar {


	public static void imprimeVetor (int[] A) {
		int j = 0;
		while (j < A.length) {
			System.out.print(A[j++] + " ");
		}
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
	
    // Divide o vetor em duas partes iguais
	public static int particione (int[] A, int p, int r) {

		int x = A[r]; // x é o pivô
		int i = p-1;
		for (int j=p; j< r; j++) {
			if (A[j] <= x) {
				i++;
				Auxiliar.troca(A, i, j);
			}
			
		}
		Auxiliar.troca (A, i+1, r);
		return i+1;
		
	}

	// Divide o vetor em duas partes delimitadas pelo pivô aleatoriamente selecionado
	public static int particioneAleatorio(int[] A, int p, int r) {

		Random random = new Random();
		
		int i = p + (Math.abs(random.nextInt()) % (r-p+1));
		
		Auxiliar.troca(A, i, r);

		return Auxiliar.particione(A, p, r);
	}

}
