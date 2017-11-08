package aula_25_08_17;

public class CalculaPolinomio {

	public static void main(String[] args) {

		float[] A = {2, 3, 1};
		
		System.out.println(calcularPolinomio(A, 2));
		
	}

	public static float calcularPolinomio(float[] A, float x) {

		int n = A.length;
		float P;
		
		// Quando restar apenas o último coeficiente, 
		// APENAS RETORNA (não é necessário multiplicar - grau de x = 0)
		if (n == 1) {
			P = A[0];
		} else {

			// Elimina recursivamente o primeiro coeficiente da matriz 
			// até que reste apenas um
			float[] ALinha = new float[n-1];
			
			// n termos, grau do polinômio n-1
			// Meio de eliminar o elemento de grau n-1
			for (int i = 0; i < ALinha.length; i++) {
				ALinha[i] = A[i+1];
			}			
			
			float PLinha = calcularPolinomio(ALinha, x);
			
			float xn = 1;
			
			for (int i = 1; i <= ALinha.length; i++) {
				xn = xn * x;
			}
			
			//O elemento A[n] fica na posicao A[0]
			System.out.println("A[n-1]="+A[0] + " xn="+xn);
			
			P = PLinha + A[0] * xn;
			
		}

		return P;
	}

}
