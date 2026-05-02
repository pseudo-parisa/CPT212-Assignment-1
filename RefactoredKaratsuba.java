/// Refactored Karatsuba Algorithm
 
// Importing Random class from java.util packahge
import java.math.BigInteger;
import java.util.Random;

// MAin class 
class RefactoredKaratsuba {
 
    // Main driver method 
    // Refactored to use BigInteger instead of long
    public static BigInteger mult(BigInteger x, BigInteger y) {
 
        // Checking only if input is within range  
        // Refactored to use compareTo method of BigInteger
        if (x.compareTo(BigInteger.TEN) < 0 && y.compareTo(BigInteger.TEN) < 0) {
            
            // Refactored to use multiply method of BigInteger
            // Multiplying the inputs entered 
            return x.multiply(y);
        }
      
        // Declaring variables in order to  
        // Find length of both integer
        // numbers x and y
        // Refactored to use toString method of BigInteger to find length
        int noOneLength = x.toString().length();    
        int noTwoLength = y.toString().length();    
 
        // Finding maximum length from both numbers
        // using math library max function
        int maxNumLength
            = Math.max(noOneLength, noTwoLength);
 
        // Rounding up the divided Max length
        Integer halfMaxNumLength
            = (maxNumLength / 2) + (maxNumLength % 2);
 
        // Multiplier
        // Refactored to use pow method of BigInteger
        BigInteger maxNumLengthTen
            = BigInteger.TEN.pow(halfMaxNumLength);
 
        // Compute the expressions
        // Refactored to use divide and remainder methods of BigInteger
        BigInteger a = x.divide(maxNumLengthTen);
        BigInteger b = x.remainder(maxNumLengthTen);
        BigInteger c = y.divide(maxNumLengthTen);
        BigInteger d = y.remainder(maxNumLengthTen);
 
 
        // Compute all mutilpying variables
        // needed to get the multiplication
        // Refactored to use BigInteger for z0, z1, and z2    
        BigInteger z0 = mult(a, c);   
        BigInteger z1 = mult(a.add(b), c.add(d));
        BigInteger z2 = mult(b, d);

        // Refactored to use BigInteger for ans
        BigInteger ans = z0.multiply(BigInteger.TEN.pow(halfMaxNumLength * 2))
            .add(z1.subtract(z0).subtract(z2).multiply(BigInteger.TEN.pow(halfMaxNumLength)))
            .add(z2);
 
        return ans; 
 
    }
    
    // Method 1
    // Removed numLength method as it is no longer needed with BigInteger

    // Method 2
    // Main driver function
    public static void main(String[] args)
    {
        // Showcasing karatsuba multiplication
         
        // Case 1: Big integer lengths
        // Refactored to use BigInteger for expected and actual products
        BigInteger expectedProduct = BigInteger.valueOf(1234).multiply(BigInteger.valueOf(5678));
        BigInteger actualProduct = mult(BigInteger.valueOf(1234), BigInteger.valueOf(5678));
 
        // Printing the expected and corresponding actual product 
        System.out.println("Expected 1 : " + expectedProduct);
        System.out.println("Actual 1 : " + actualProduct + "\n\n");

        // Using assertions to verify correctness of the multiplication
        // Refactored to use equals method of BigInteger for assertion
        assert(expectedProduct.equals(actualProduct));
 
        expectedProduct = BigInteger.valueOf(102).multiply(BigInteger.valueOf(313));
        actualProduct = mult(BigInteger.valueOf(102), BigInteger.valueOf(313));
 
        System.out.println("Expected 2 : " + expectedProduct);
        System.out.println("Actual 2 : " + actualProduct + "\n\n");
         
        assert(expectedProduct.equals(actualProduct));
 
        expectedProduct = BigInteger.valueOf(1345).multiply(BigInteger.valueOf(63456));
        actualProduct = mult(BigInteger.valueOf(1345), BigInteger.valueOf(63456));
 
        System.out.println("Expected 3 : " + expectedProduct);
        System.out.println("Actual 3 : " + actualProduct + "\n\n");
         
         assert(expectedProduct.equals(actualProduct));        
     
        Integer x = null;
        Integer y = null;
        Integer MAX_VALUE = 10000;
 
        // Boe creating an object of random class
        // inside main() method 
        Random r = new Random();
 
        for (int i = 0; i < MAX_VALUE; i++) {
            x = (int) r.nextInt(MAX_VALUE);
            y = (int) r.nextInt(MAX_VALUE);

            // Refactored to use BigInteger for expected product
            expectedProduct = BigInteger.valueOf(x).multiply(BigInteger.valueOf(y));
 
            if (i == 9999) {
               
              // Prove assertions catch the bad stuff.
              // Refactored to use BigInteger for expected product
                expectedProduct = BigInteger.valueOf(1);    
            }

            // Refactored to use BigInteger for actual product
            actualProduct = mult(BigInteger.valueOf(x), BigInteger.valueOf(y));
 
             // Again printing the expected and 
            // corresponding actual product 
            System.out.println("Expected: " + expectedProduct);
            System.out.println("Actual: " + actualProduct + "\n\n");
 
            assert(expectedProduct.equals(actualProduct));        
        }
    }
}