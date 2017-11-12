package aula_17_09_01;

public class BuscaBinaria {

	public static void main(String[] args) {
		
		int[] A = {2, 5, 7, 8, 9};
		int x = 9;
		
		System.out.println("A possui "+ A.length + " posi��es, identificadas de 0 at� "+ (A.length-1) +".");
		System.out.println("x encontra-se na posi��o "+ buscaBinaria(A, 0, 4, x)+".");
	}
	
	public static int buscaBinaria (int[] A, int e, int d, int x) {
		if (e==d) {
			if (A[e] == x) {
				return e;
			} else {
				return 0;
			}
		} else {
			int i=(e+d)/2;
			if (A[i] == x) {
				return i;
			} else {
				if (A[i] > x) {
					i= buscaBinaria(A, e, i-1, x);
				} else {
					i = buscaBinaria(A, i+1, d, x);
				}
			}
			return i;
		}
	}

}
