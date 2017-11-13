package aula_17_09_01;

public class Exponenciacao {

	public static void main(String[] args) {
		
		double base = 2.5;
		int expoente = 3; 
		
		System.out.println(base + " elevado a " + expoente + " é igual a " + exponenciacao(base, expoente));

		
	}
	
	public static double exponenciacao (double a, int n) {

		double anLinha;
		double an;
		
		if (n==0) {
			return 1;
		} else {
			anLinha = exponenciacao(a, n-1);
			an = anLinha * a;	
		}
		
		return an;
	}
}
