package aula_17_08_25;

public class CalculaPolinomio2 {

	public static void main(String[] args) {

		float[] A = { 2, 3, 1 };

		System.out.println(calcularPolinomio(A, 2)[0]);

	}

	public static float[] calcularPolinomio(float[] A, float x) {

		int n = A.length;
		float xn;
		float P;
		
		// retorno = PLinha, xLinha
		float[] retorno = new float[2];

		// Quando restar apenas o último coeficiente, 
		// APENAS RETORNA (não é necessário multiplicar - grau de x = 0)
		if (n == 1) {
			retorno[0]=A[0]; //P
			retorno[1]=1;    //xn
			return retorno;
		} else {

			// Elimina recursivamente o primeiro coeficiente da matriz
			// até que reste apenas um
			float[] ALinha = new float[n - 1];

			// n termos, grau do polinômio n-1
			// Meio de eliminar o elemento de grau n-1
			for (int i = 0; i < ALinha.length; i++) {
				ALinha[i] = A[i + 1];
			}
			
			retorno = calcularPolinomio(ALinha, x);
			
			float PLinha = retorno[0];
			float xLinha = retorno[1];
			
			xn = x * xLinha;

			// A[0] = a de grau n
			P = PLinha + A[0] * xn;

		}
		
		retorno[0] = P;
		retorno[1] = xn;
		
		return retorno;
	}

}
