package aula_17_09_01;

public class ExponenciacaoDC {

	public static void main(String[] args) {
		
		double base = 2.5;
		int expoente = 3; 
		
		System.out.println(base + " elevado a " + expoente + " é igual a " + exponenciacaoDC(base, expoente));
	}

	public static double exponenciacaoDC (double a, int n) {
		
		double anLinha;
		double an;
		
		if (n==0) {
			return 1;
		} else {
			
			anLinha = exponenciacaoDC(a, n/2);
			
			an = anLinha * anLinha;
		
			if ((n%2)==1) {
				an = an * a;
			}
			
			return an;
		}

	}
	
}
