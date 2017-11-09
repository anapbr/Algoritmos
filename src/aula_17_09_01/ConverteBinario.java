package aula_17_09_01;

public class ConverteBinario {

	public static void main(String[] args) {

		int[] resultado = converterBinario(10);
		
		for (int i=0; i<resultado.length; i++) {
			System.out.print(resultado[i]);	
		}
		
		
	}
	
	public static int[] converterBinario (int n) {
		
		int t = n;
		
		int tamanho = (int) (Math.log10(n) / Math.log10(2)) + 1;

		int[] b = new int[tamanho];

		int k=-1;
		while (t>0) {

			k++;

			// Precisa gravar de trás para frente do vetor
			// Do contrário, precisará inverter ao final o 
			// vetor para encontrar o resultado
			b[tamanho-1-k] = t % 2;
			t = t/2;
						
		}
		
		return b;
		
	}

}
