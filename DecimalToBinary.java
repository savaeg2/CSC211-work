public class DecimalToBinary {
    /**
     * Recursive implementation of decimal to binary conversion
     * Works by repeatedly dividing by 2 and concatenating remainders
     */
    public static String decimalToBinaryRecursive(int decimal) {
        // Base cases
        if (decimal == 0) {
            return "0";
        }
        if (decimal == 1) {
            return "1";
        }
        
        // Recursive case: divide by 2 and concatenate remainder
        int remainder = decimal % 2;
        return decimalToBinaryRecursive(decimal / 2) + remainder;
    }
    
    /**
     * Recursive implementation that handles negative numbers
     */
    public static String decimalToBinaryRecursiveSigned(int decimal) {
        if (decimal < 0) {
            return "-" + decimalToBinaryRecursive(-decimal);
        }
        return decimalToBinaryRecursive(decimal);
    }

    /**
     * Iterative implementation of decimal to binary conversion
     * Uses StringBuilder for efficient string concatenation
     */
    public static String decimalToBinaryIterative(int decimal) {
        // Handle 0 separately
        if (decimal == 0) {
            return "0";
        }
        
        // Handle negative numbers
        boolean isNegative = decimal < 0;
        if (isNegative) {
            decimal = -decimal;
        }
        
        StringBuilder binary = new StringBuilder();
        
        // Convert to binary by repeatedly dividing by 2
        while (decimal > 0) {
            binary.insert(0, decimal % 2);
            decimal = decimal / 2;
        }
        
        // Add negative sign if necessary
        if (isNegative) {
            binary.insert(0, "-");
        }
        
        return binary.toString();
    }

    /**
     * Alternative iterative implementation using built-in Integer.toBinaryString()
     * Included for comparison
     */
    public static String decimalToBinaryBuiltIn(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static void main(String[] args) {
        // Test cases
        int[] testNumbers = {0, 1, 5, 10, 42, -5, -10, 255};
        
        System.out.println("Decimal to Binary Conversion Test Cases:");
        System.out.println("======================================");
        
        for (int num : testNumbers) {
            System.out.printf("Number: %d%n", num);
            System.out.printf("Recursive: %s%n", decimalToBinaryRecursiveSigned(num));
            System.out.printf("Iterative: %s%n", decimalToBinaryIterative(num));
            System.out.printf("Built-in:  %s%n", decimalToBinaryBuiltIn(num));
            System.out.println("--------------------------------------");
        }
    }
}