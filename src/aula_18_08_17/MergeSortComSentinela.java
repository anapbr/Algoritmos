/*
 * INTERCALA DOIS SUBVETORES PREVIAMENTE ORDENADOS *** COM SENTINELA ***
 *
 */

package aula_18_08_17;

public class MergeSortComSentinela {

		public static void main(String[] args) {
			int A[] = {22,33,55,77,99,11,44,66,88};
			
			int i=0;
			System.out.print("ENTRADA..: ");
			while (i<A.length) {
				System.out.print(A[i++] + " ");	
			}
			
			System.out.println();
			
			//Apesar de haver n elementos, r é o ÍNDICE, logo, n-1 é a sua posição!
			int n = A.length - 1;
			mergeSort(A, 0, n);
			
			i=0;
			System.out.print("\n\nSAÍDA....: ");
			while (i<A.length) {
				System.out.print(A[i++] + " ");	
			}
		}

		public static void mergeSort(int[] A, int p, int r) {
			if (p < r) {
				int q = (int) Math.floor((p+r)/2);
				mergeSort(A, p, q);
				mergeSort(A, q + 1, r);
				mergeComSentinela(A, p, q, r);
			}
			
		}

		/*
	     * @param A Vetor a ser ordenado
		 * @param q Pivo do vetor
		 * @param p Inicio do vetor
		 * @param r Fim do vetor
		 * */
	    
		private static void mergeComSentinela(int[] A, int p, int q, int r) {
			int n1 = q - p + 1; // Tamanho do início (p) até o pivô (q)
			int n2 = r - q;     // Tamanho do pivô (q) até o final (r)
			
			int[] L = new int[n1+1]; // n1 + 1 elementos, indexados de 0..n1
			int[] R = new int[n2+1]; // n2 + 1 elementos, indexados de 0..n2
			
			// Inicializei L com a primeira parte
			for (int i=0; i<n1; i++) {
				L[i] = A[p+i];
			}
			
			// Inicializei R com a segunda parte
			for (int j=0; j<n2; j++) {
				R[j] = A[(q + 1) + j]; // (q + 1) -> após o pivô
			}
			
			L[n1] = Integer.MAX_VALUE;
			R[n2] = Integer.MAX_VALUE;
			
			int i = 0;
			int j = 0;
			
			for (int k=p; k<=r; k++) {
				if (L[i] <= R[j]) {
					A[k] = L[i];
					System.out.println("Pivô="+q+" Início="+p+" Fim="+r);
					System.out.println(L[i]+"<="+R[j]);
					System.out.println("   A["+k+"]="+A[k]);
					i++;
				} else {
					A[k] = R[j];
					System.out.println("Pivô="+q+" Início="+p+" Fim="+r);
					System.out.println(L[i]+">="+R[j]);
					System.out.println("   A["+k+"]="+A[k]);
					j++;				
				}

				System.out.println();
			}
		}

	}
