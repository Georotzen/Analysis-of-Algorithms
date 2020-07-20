import java.util.ArrayList;
import java.util.Scanner;

public class A8P1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("n = ");
        int n = input.nextInt();
        method1(n);
        method2(n);
        method3(n);
        method4(n);
        input.close();
    }

    static void method1(int n) {
        double result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + (1 / (double) i);
        }
        System.out.println("Method 1: " + result);
    }

    static void method2(int n) {
        ArrayList<Integer> hired = new ArrayList<>();
        int[] arr = new int[n];

        for (int i = 1; i <= 10000; i++) {
            int total = 0;
            int rank = Integer.MAX_VALUE;
            arr = generateRankArray(n);

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < rank) {
                    rank = arr[j];
                    total++;
                }
            }
            hired.add(total);
        }

        int average = 0;
        for (int k = 0; k < hired.size(); k++) {
            average = average + hired.get(k);
        }
        System.out.println("Method 2: " + (average / (double) hired.size()));
    }

    static void method3(int n) {
        ArrayList<Integer> hired = new ArrayList<>();
        ArrayList<String> permutations = new ArrayList<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        permuteRankArray(arr, 0, permutations);

        for (int j = 0; j < permutations.size(); j++) {
            String tempArr = permutations.get(j);
            int total = 0;
            int rank = Integer.MAX_VALUE;
            for (int k = 0; k < tempArr.length(); k++) {
                if (Character.getNumericValue(tempArr.charAt(k)) < rank) {
                    rank = Character.getNumericValue(tempArr.charAt(k));
                    total++;
                }
            }
            hired.add(total);
        }

        int average = 0;

        for (int i = 0; i < hired.size(); i++) {
            average = average + hired.get(i);
        }

        System.out.println("Method 3: " + (average / (double) hired.size()));
    }

    static void method4(int n) {
        System.out.println("Method 4: " + Math.log(n));
    }

    static int[] generateRankArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        
        for (int j = 0; j < n; j++) {
            int random = (int) ((Math.random() * (((n - 1) - 0) + 1)) + 0);
            int temp = arr[j];
            arr[j] = arr[random];
            arr[random] = temp;
        }
        return arr;
    }

    static void permuteRankArray(int[] arr, int start, ArrayList<String> permutations) {
        for (int i = start; i < arr.length; i++) {
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            permuteRankArray(arr, start + 1, permutations);
            arr[i] = arr[start];
            arr[start] = temp;
        }
        if (start == arr.length - 1) {
            String permutation = "";
            for (int i = 0; i < arr.length; i++) {
                permutation = permutation + arr[i]; 
            }
            permutations.add(permutation);
        }
    }
}
