public class Atividade4 {

    public static void main(String[] args) {
        int decimalNumber = 23;
        String binaryRepresentation = decimalToBinary(decimalNumber);
        System.out.println("O número " + decimalNumber + " em binário é " + binaryRepresentation);
    }

    public static String decimalToBinary(int n) {

        if (n == 0) {
            return "0";
        }


        if (n == 1) {
            return "1";
        }

        return decimalToBinary(n / 2) + (n % 2);
    }
}
