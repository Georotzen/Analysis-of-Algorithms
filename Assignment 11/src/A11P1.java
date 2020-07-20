import java.util.Scanner;

public class A11P1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("k = ");
        int k = input.nextInt();
        System.out.print("n = ");
        int n = input.nextInt();
        System.out.print("Generated: ");
        int[] arr = generateArr(k, n);
        countingSort(arr, k, n);
        input.close();
    }

    public static void countingSort(int[] arr, int k, int n) {
        int[] countArr = new int[k + 1];
        int[] sortedArr = new int[n];

        // Set all elements of countArr equal to zero
        for (int i = 0; i < k + 1; i++) {
            countArr[i] = 0;
        }

        // Count the numbers of appearances of a number
        for (int i = 0; i < n; i++) {
            countArr[arr[i]] = countArr[arr[i]] + 1;
        }

        // We carry a cumulative number based on appearances of the numbers
        for (int i = 1; i <= k; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }

        // We place the elements in ther corresponding positions based on countArr and decrease index count by one
        for (int i = n - 1; i >= 0; i--) {
            sortedArr[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]] = countArr[arr[i]] - 1;
        }
        System.out.print("Sorted:    ");
        print(sortedArr);
    }

    public static int[] generateArr(int k, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) ((Math.random() * ((k - 0) + 1)) + 0);
        }
        print(arr);
        return arr;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}