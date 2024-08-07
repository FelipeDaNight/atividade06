public class Atividade2 {

    public static void main(String[] args) {
        int x = 56;
        int y = 98;
        System.out.println("O MDC de " + x + " e " + y + " é " + gcd(x, y));
    }

    public static int gcd(int x, int y) {

        if (x == y) {
            return x;
        }


        if (x > y) {
            return gcd(x - y, y);
        }


        return gcd(y - x, x);
    }
}
