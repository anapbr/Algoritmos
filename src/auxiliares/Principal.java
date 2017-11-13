package auxiliares;

/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
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
     * Algoritmos de ordenação podem ser ou não in-place ou estáveis.
     * Um método de ordenação é estável se elementos iguais ocorrem no 
     * vetor ordenado na mesma ordem em que são passados na entrada.
     * O CountingSort é estável. 
     *
     * Complexidade para o pior caso Theta(k+n).
     * Complexidade para o caso médio/esperado Theta(k+n).
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
        //C[j] É o número de A[j] tais que A[j] = i
        for (int j = 0; j < n; j++) {
            C[A[j]] = C[A[j]] + 1;
        }
        //Orrdenando os indices do vetor auxiliar C
        //C[i] é o número de js tais que A[j] 
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        // Classifica o vetor da direita para a esquerda
        // Procure no vetor de ocorrências a última ocorrência do valor dado
        // Coloca no vetor ordenado
        // Decrementa o índice da última ocorrência do valor dado
        // Continue com o valor anterior do vetor de entrada, termina se todos os valores já foram classificados
        // n - 1 pois vetor em java começa em 0 zero
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