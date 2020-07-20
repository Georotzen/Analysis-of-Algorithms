import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Map; 

public class A1P3 {

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        input.close();

        primeFactorization(n);
    }

    public static void primeFactorization(int n) {

        ArrayList<String> pf = new ArrayList<String>();
        String format = "";

        while (n % 2 == 0) {
            pf.add(Integer.toString(2));
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                pf.add(Integer.toString(i));
                n /= i;
            }
        }

        if (n > 2) {
            pf.add(Integer.toString(n));
        }

        Map<String, Integer> hash = new HashMap<String, Integer>(); 
  
        for (String i : pf) { 
            Integer j = hash.get(i); 
            hash.put(i, (j == null) ? 1 : j + 1); 
        }

        pf.clear();

        for (Map.Entry<String, Integer> val : hash.entrySet()) { 
            pf.add(val.getKey() + "^" + val.getValue());
        } 

        for (int i = 0; i < pf.size(); i++) {
            if (i == pf.size() - 1) {
                format = format + pf.get(i);
            }
            else {
                format = format + pf.get(i) + " * ";
            }
        }
        System.out.print(format);
    }
}