
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        // Number of digits for the random numbers 
        int[] digits = {1,10,100,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};


        // Print partial products and carriers
        for (int n: digits) {
            
            String n1 = generateRandomDigits(n);
            String n2 = generateRandomDigits(n);

            // opCount
            // Reset before starting
            SimpleMultiplication.opCount = 0; 
            RefactoredKaratsuba.opCount = 0;

            String simple_mult_result = SimpleMultiplication.multi(n1, n2);        
            //System.out.println("n1: " + n1);
            //System.out.println("n2: " + n2);
            //System.out.println("Final Result: " + simple_mult_result);
            //System.out.println("Total Operations: " + SimpleMultiplication.opCount);


            String karatsuba_result = RefactoredKaratsuba.mult(new java.math.BigInteger(n1), new java.math.BigInteger(n2)).toString();
            //System.out.println("Final Result: " + karatsuba_result);
            //System.out.println("Total Operations (Refactored Karatsuba): " + RefactoredKaratsuba.opCount);

            System.out.println(n + "," + SimpleMultiplication.opCount + "," + RefactoredKaratsuba.opCount);   
        }
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