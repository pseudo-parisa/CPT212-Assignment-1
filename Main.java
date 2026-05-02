
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        // Print partial products and carriers
        String n1 = generateRandomDigits(10000);
        String n2 = generateRandomDigits(10000);

        // Testing opCount
        SimpleMultiplication.opCount = 0; // Reset before starting
        
        //long startTime = System.currentTimeMillis();
        String result = SimpleMultiplication.multiply(n1, n2);
        //long endTime = System.currentTimeMillis();
        //System.out.println("n1: " + n1);
        //System.out.println("n2: " + n2);
        System.out.println("Final Result: " + result);
        System.out.println("Total Operations: " + SimpleMultiplication.opCount);
        //System.out.println("Completed 10,000 digits in: " + (endTime - startTime) + "ms");

    }

    // Generate random n-digit numbers
    public static String generateRandomDigits(int n) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
}