import java.util.Scanner;
import java.util.ArrayList;

public class A1P1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("How many primes should be generated? ");
        int n = input.nextInt();
        input.close();
        
        primePrinter(n);
    }
    
    static void primePrinter(int n) {
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

        int curr = 3;

        if(n >= 1) {
            primeNumbers.add(2);
        }

        for (primeNumbers.size(); primeNumbers.size() < n; curr += 2) {
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