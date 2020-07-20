import java.util.Scanner;
import java.util.ArrayList;

class A1P2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Generate primes not exceeding: ");
        int n = input.nextInt();
        input.close();
        
        primePrinter(n);
    }

    static void primePrinter(int n) {

        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

        primeNumbers.add(2);
        
        for (int curr = 3; curr < n; curr += 2) {
            boolean isPrime = true;
            for (Integer prime : primeNumbers) {
                if (curr % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(curr);
            }
        }
        System.out.println(primeNumbers);
    }
    
}