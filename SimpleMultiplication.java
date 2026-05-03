// Simple multiplication algorithm

//import java.util.Arrays;

public class SimpleMultiplication { 

    public static long opCount;
    public static void main(String[] args) {
        // two numbers with long data type
        String firstNum = largeNumHandler(3);
        String secondNum = largeNumHandler(3); 

        // print statements
        System.out.println("*************************************************************************************************");
        System.out.println("Multiplicand: " + firstNum + "      Multiplier: " + secondNum);
        System.out.println("*************************************************************************************************");

        // conversion of int to string for easy digit-by-digit manipulation
        String firstNumString = String.valueOf(firstNum);
        String secondNumString = String.valueOf(secondNum);
        

        String finalAns = multi(firstNumString, secondNumString);
        System.out.println();
        System.out.println("The length of the answer is " + finalAns.length());
        //System.out.println("The product of the two terms is " + finalAns);

    }

    public static String multi(String firstNumString, String secondNumString){

        // preparation of arrays to store numbers
        // the final answer is the size of the sum of all digits together
        int firstNumStringLen = firstNumString.length();
        int secondNumStringLen = secondNumString.length();
        opCount += 2; // 2 assignments

        int[] result = new int[firstNumStringLen + secondNumStringLen];
        opCount += 2; // one assignment, one addition

        // for loop to traverse through all numbers and multiply
        // responsible for keeping track of parital product of each step as well as carry
        for (int i = firstNumStringLen - 1; i >= 0; i--){
            for(int j = secondNumStringLen - 1; j >= 0; j--){
                opCount += 2*2; // nested loop 

                // calculating index positions of carry and partial product in array
                int carry = i+j;
                int partialProduct = i+j+1; 
                opCount += 4; // 2 assignment, 2 addition

                // multiplying digit by digit
                int product = (Character.getNumericValue(firstNumString.charAt(i)) * Character.getNumericValue(secondNumString.charAt(j)));
                opCount += 6; // 2 array access, 1 multiplication, 2 conversion, 1 assignment
                
                // shifting 
                product = product + result[partialProduct];   
                // left-most digit is carry
                result[partialProduct] = product % 10;
                opCount += 4; // 2 assignment, 2 addition

                // printing statements for each step
                // recommended to uncomment when dealing with larger digit count
                //System.out.println("Array contents:" + Arrays.toString(result) +    "     Partial products: " + result[partialProduct] + "      Carriers: " + result[carry]);

                // right-most is parital product
                // all carry will be added before stored into array
                result[carry] = result[carry] + product/10;
                opCount += 5; // 1 assignment, 2 addition, 2 array access      
        }
    }
    opCount += (firstNumStringLen * secondNumStringLen);
    StringBuilder builder = new StringBuilder();
    
        for (int j : result) {
            if (builder.length() != 0 || j !=0){ // removal of any leading zeros 
                builder.append(j);
                opCount += 4;
            }  
        }

        // System.out.println();
        // System.out.println("Total number of operations: " + opCount);
        return builder.length() == 0 ? "0" : builder.toString();
}

    public static String largeNumHandler(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("9");
    }
        return sb.toString();
    }

}