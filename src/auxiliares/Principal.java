package auxiliares;

/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Inform�tica e Estat�stica - INE
 * Programa de P�s-Gradua��o em Ci�ncias da Computa��o - PROPG
 * Disciplinas: Projeto e An�lise de Algoritmos
 * Prof Alexandre Gon�alves da Silva 
 * Baseado nos slides 110 da aula do dia 15/09/2017  
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

    /**
     * Retorna o maior elemento do vetor.
     * @param A vetor com os dados 
     * @return Um valor inteiro com o maior elemento do vetor
     */
    public static int maiorElemento(int[] A) {
        int maior = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > maior) {
                maior = A[i];
            }
        }
        return maior;
    }

    /**
     * Counting Sort.
     * Algoritmos de ordena��o podem ser ou n�o in-place ou est�veis.
     * Um m�todo de ordena��o � est�vel se elementos iguais ocorrem no 
     * vetor ordenado na mesma ordem em que s�o passados na entrada.
     * O CountingSort � est�vel. 
     *
     * Complexidade para o pior caso Theta(k+n).
     * Complexidade para o caso m�dio/esperado Theta(k+n).
     * k pertence a O(n) portanto O(n)
     * 
     * @param A Vetor com os dados desordenados
     * @param B Vetor com os dados ordenados
     * @param n Quantidade de elementos do vetor
     * @param k Maior elemento do vetor A
     */
    public static void countingSort(int[] A, int[] B, int n, int k) {

        //Cria o vetor auxiliar C com base do maior elemento de A
        int C[] = new int[k+1];
        
        //Inicializar com zero o vetor auxiliar C
        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }

        //Realiza a contagem das ocorrencias
        //C[j] � o n�mero de A[j] tais que A[j] = i
        for (int j = 0; j < n; j++) {
            C[A[j]] = C[A[j]] + 1;
        }
        //Orrdenando os indices do vetor auxiliar C
        //C[i] � o n�mero de js tais que A[j] 
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        // Classifica o vetor da direita para a esquerda
        // Procure no vetor de ocorr�ncias a �ltima ocorr�ncia do valor dado
        // Coloca no vetor ordenado
        // Decrementa o �ndice da �ltima ocorr�ncia do valor dado
        // Continue com o valor anterior do vetor de entrada, termina se todos os valores j� foram classificados
        // n - 1 pois vetor em java come�a em 0 zero
        for (int j = n - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
    }

    public static void main(String args[]) {
        //Vetor dos dados    
        int A[] = {5, 7, 6, 0, 1, 3, 2, 4};

        //Tamanho do vetor
        int n = A.length;

        System.out.println(">>> CountingSort <<<");
        System.out.println("Original: ");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }

        //Maior valor do vetor A
        int k = maiorElemento(A);
        //Vetor para receber os dados ordenados, com tamanho igual ao vetor A
        int B[] = new int[A.length];

        countingSort(A, B, n, k);

        System.out.println("Depois: ");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " - " + B[i]);
        }
    }
}