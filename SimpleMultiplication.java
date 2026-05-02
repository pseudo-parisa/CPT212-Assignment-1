
public class SimpleMultiplication {
 
    public static String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        
        // Result can have up to n + m digits
        int[] result = new int[n + m];

        // Loop through each digit of the multiplier (bottom number)
        for (int i = m - 1; i >= 0; i--) {
            int carrier = 0;
            //Loop through each digit of the multiplicand (top number)
            for (int j = n - 1; j >= 0; j--){
                int multiplierDigit = num2.charAt(i) - '0';
                int multiplicandDigit = num1.charAt(j) - '0';
            
                // Multiply digits and add previous carrier
                int product = (multiplierDigit * multiplicandDigit) + carrier;

                // Determine partial product and carrier
                int partialProduct = product % 10;
                carrier = product / 10;

                // Print for Testing
                if (n < 10) {
                    System.out.println("Step: " + multiplicandDigit + " * " + multiplierDigit + 
                                       " = " + product + " -> Partial: " + partialProduct + " Carrier: " + carrier);
                }

                // Add to the correct position in final result array
                int currentPos = i + j + 1;
                int sum = result[currentPos] + partialProduct;
                result[currentPos] = sum % 10;
                carrier += sum / 10; // Extra carrier from adding to result
            }
            // Add remaining carrier to the final position
            result[i] += carrier;
        }

        // Convert result array back to String, ignoring leading zeros
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0)) sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}