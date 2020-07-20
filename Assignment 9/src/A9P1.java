import java.util.ArrayList;
import java.util.Scanner;

public class A9P1 {
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
        for (int i = 2; i <= n; i++) {
            result += (1 / (double) (i - 1));
        }
        System.out.println("Method 1 : " + ((1 / ((double) n)) * result));
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

        double hiredTwo = 0;

        for (int k = 0; k < hired.size(); k++) {
            if (hired.get(k) == 2) {
                hiredTwo++;
            }
        }
        System.out.println("Method 2 : " + (hiredTwo / (double) 10000));
    }

    static void method3(int n) {
        ArrayList<Integer> hired = new ArrayList<>();
        int[] arr = new int[n];

        for (int i = 1; i <= 1000000; i++) {
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

        double hiredTwo = 0;

        for (int k = 0; k < hired.size(); k++) {
            if (hired.get(k) == 2) {
                hiredTwo++;
            }
        }
        System.out.println("Method 3 : " + (hiredTwo / (double) 1000000));
    }

    static void method4(int n) {
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

        double hiredTwo = 0;

        for (int k = 0; k < hired.size(); k++) {
            if (hired.get(k) == 2) {
                hiredTwo++;
            }
        }

        System.out.println("Method 4 : " + (hiredTwo / (double) factorial(n)));
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

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return (n * factorial(n - 1));
    }
}