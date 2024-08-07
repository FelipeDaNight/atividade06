public class Atividade3 {

    public static void main(String[] args) {
        int x = 23;
        int y = 5;
        System.out.println("O resto da divisão de " + x + " por " + y + " é " + mod(x, y));
    }

    public static int mod(int x, int y) {

        if (x == y) {
            return 0;
        }

        // Se x é menor que y, o resto é x
        if (x < y) {
            return x;
        }


        return mod(x - y, y);
    }
}
