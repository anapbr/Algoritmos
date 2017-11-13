package auxiliares;

public class Auxiliar {


	public static void imprimeVetor (int[] A) {
		int j = 0;
		while (j < A.length) {
			System.out.print(A[j++] + " ");
		}
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
