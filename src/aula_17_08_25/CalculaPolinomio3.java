package aula_17_08_25;

public class CalculaPolinomio3 {

	public static void main(String[] args) {

		float[] A = {2, 3, 1};
		
		System.out.println(calcularPolinomio(A, 2));
		
	}

	public static float calcularPolinomio(float[] A, float x) {

		float P;
		float PLinha;
		int n = A.length;
		
		// Quando restar apenas o último coeficiente, 
		// APENAS RETORNA (não é necessário multiplicar - grau de x = 0)		
		if (n==1) {
			P = A[0];
		} else {
		
			// Elimina recursivamente o primeiro coeficiente da matriz 
			// até que reste apenas um
			float[] ALinha = new float[n-1];
			
			//Eliminando o último termo do Array (o de menor grau)
			for (int i = 0; i < ALinha.length; i++) {
				ALinha[i] = A[i];
			}		
			
			//System.out.println();
			
			PLinha = calcularPolinomio(ALinha, x);
			
			System.out.println("n=" + n + " PLinha=" + PLinha + " A[0]=" + A[0]);
			
			P = x * PLinha + A[n-1];
		}
		return P;
	}

}
