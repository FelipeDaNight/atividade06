public class Atividade1 {

    public static void main(String[] args) {
        int N = 762021192;
        int K = 2;
        System.out.println("O dígito " + K + " ocorre " + countDigitOccurrences(N, K) + " vezes em " + N);
    }

    public static int countDigitOccurrences(int N, int K) {

        if (N == 0) {
            return 0;
        }


        int lastDigit = N % 10;
        int count = (lastDigit == K) ? 1 : 0;


        return count + countDigitOccurrences(N / 10, K);
    }
}
