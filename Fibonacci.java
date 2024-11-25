public class Fibonacci {
    /**
     * Recursive implementation of Fibonacci
     * Time Complexity: O(2^n) - exponential
     * Space Complexity: O(n) - due to recursion stack
     */
    public static long fibonacciRecursive(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }
        // Recursive case: fib(n) = fib(n-1) + fib(n-2)
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * Iterative implementation of Fibonacci
     * Time Complexity: O(n) - linear
     * Space Complexity: O(1) - constant
     */
    public static long fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        
        long prev = 0;
        long current = 1;
        
        for (int i = 2; i <= n; i++) {
            long next = prev + current;
            prev = current;
            current = next;
        }
        
        return current;
    }

    public static void main(String[] args) {
        // Example usage
        int n = 10;
        
        System.out.println("Recursive Fibonacci for n = " + n + ": " + 
            fibonacciRecursive(n));
        System.out.println("Iterative Fibonacci for n = " + n + ": " + 
            fibonacciIterative(n));
    }
}
