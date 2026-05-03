
public class SimpleMultiplication {
    
    public static long opCount = 0;

    public static String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        
        // Assignments and length checks for n and m
        opCount += 4; 
        
        // Result can have up to n + m digits
        int[] result = new int[n + m];
        
        // Array initialization and addition
        opCount += 2; 

        // Loop through each digit of the multiplier (bottom number)
        for (int i = m - 1; i >= 0; i--) {
            // i assignment, m - 1 subtraction, comparison, and loop decrement
            opCount += 4;

            int carrier = 0;
            // Carrier assignment
            opCount++; 

            //Loop through each digit of the multiplicand (top number)
            for (int j = n - 1; j >= 0; j--){
                // j assignment, n - 1 subtraction, comparison, and loop decrement
                opCount += 4; 

                int multiplierDigit = num2.charAt(i) - '0';
                int multiplicandDigit = num1.charAt(j) - '0';
                // Char extractions, subtractions, and assignments
                opCount += 6; 
            
                // Multiply digits and add previous carrier
                int product = (multiplierDigit * multiplicandDigit) + carrier;
                // Multiplication, assignment, and addition
                opCount += 3; 

                // Determine partial product and carrier
                int partialProduct = product % 10;
                carrier = product / 10;
                // Assignment, modulo, and division
                opCount += 5; 

                // Add to the correct position in final result array
                int currentPos = i + j + 1;
                int sum = result[currentPos] + partialProduct;
                result[currentPos] = sum % 10;
                carrier += sum / 10; // Extra carrier from adding to result
                // Array access, additions, and assignments
                opCount += 10; 
            }
            // Add remaining carrier to the final position
            result[i] += carrier;
            // Array access and addition
            opCount += 2; 
        }

        // Convert result array back to String, ignoring leading zeros
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            // Loop comparison
            opCount++; 
            if (!(sb.length() == 0 && digit == 0)){ 
                sb.append(digit);
                // Append operation
                opCount++; 
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}