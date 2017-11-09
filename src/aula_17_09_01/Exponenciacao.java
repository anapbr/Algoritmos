package aula_17_09_01;

public class Exponenciacao {

	public static void main(String[] args) {
		
		System.out.println(exponenciacao(2.5, 3));

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
