/*
 * Inicialmente, pega os dois primeiros elementos de um vetor, ou seja, posi��es 0 e 1
 * 
 *  1. Atribui o elemento na posi��o 1 como chave
 *  Compara a chave com todos os elementos cujos respectivos �ndices sejam inferiores
 *  		- At� que encontre um menor valor menor que o da chave; OU
 *  		- O in�cio do vetor seja atingido.
 *  		
 *  2. Repete o processo at� o �ltimo elemento do vetor
 *  3. Retorna o vetor ordenado
 *  
 *  Exemplo: VER OUTPUT
 *  
 */


package aula_04_08_17;

public class OrdenaPorInsercao {

	public static void main(String[] args) {
		
		int A[] = {99,35,20,25,40,44,55,38,10,65,50};
		
		int i=0;
		System.out.print("ENTRADA..: ");
		while (i<A.length) {
			System.out.print(A[i++] + " ");	
		}
		
		int n = A.length;
		
		System.out.println();
		
		A = ordenaPorInsercao(A, n);
		
		i=0;
		System.out.print("\n\nSA�DA....: ");
		while (i<A.length) {
			System.out.print(A[i++] + " ");	
		}
	}

	public static int[] ordenaPorInsercao(int[] A, int n) {

		for (int j = 1; j < n; j++) {
			int chave = A[j];
			System.out.print("\nCHAVE=" + chave+" / ");
			
			int i = j - 1;

			//Compara chave com elementos posicionados antes no vetor
			//Para se pelo menos uma das situa��es ocorrer:
			//Alcan�ar o in�cio do vetor OU
			//Chave for maior que o elemento anterior
			while (i>=0 && A[i]>chave) {
				//Troca a posi��o avaliada com a chave
				A[i+1]=A[i];
				i--;
			}

			A[i+1]=chave;

			// --------------------------------------------------------------------- //
			// IMPRESSAO AUXILIAR                                                    //
			// --------------------------------------------------------------------- //
			int u=0;
			while (u<A.length) {
				System.out.print(A[u++] + " ");	
			}
			// --------------------------------------------------------------------- //
		}
		
		return A;
	}

}
