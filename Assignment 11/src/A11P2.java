import java.util.Scanner;

public class A11P2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("d = ");
        int d = input.nextInt();
        System.out.print("n = ");
        int n = input.nextInt();
        System.out.print("Generated: ");
        int[] arr = generateArr(d, n);
        radixSort(arr, d, n);
        input.close();
    }

    public static void radixSort(int[] arr, int d, int n) {
        int[] sortedArr = new int[n];
        int place = 1;
        sortedArr = countingSort(arr, place, n);
        for (int i = 1; i < d; i++) {
            place *= 10;
            sortedArr = countingSort(arr, place, n);
        }
        System.out.print("Sorted:    ");
        print(sortedArr);
    }

    public static int getMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] countingSort(int[] arr, int place, int n) {
        // Need to know max in order to create max + 1 number of buckets
        int max = getMax(arr, n);

        int[] countArr = new int[max + 1];
        int[] sortedArr = new int[n];

        // Set all elements of countArr equal to zero
        for (int i = 0; i < max; i++) {
            countArr[i] = 0;
        }

        // Count the number of appearances of a digit in nth digit place
        for (int i = 0; i < n; i++) {
            countArr[(arr[i] / place) % 10]++;
        }

        // We carry a cumulative number of appearances of the digits in nth digit place
        for (int i = 1; i < 10; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }

        // We place the elements in ther corresponding positions based on countArr and
        // decrease indeces count by one
        for (int i = n - 1; i >= 0; i--) {
            sortedArr[countArr[(arr[i] / place) % 10] - 1] = arr[i];
            countArr[(arr[i] / place) % 10]--;
        }

        // Copy arr results to the new sorted array
        for (int i = 0; i < n; i++) {
            arr[i] = sortedArr[i];
        }

        return sortedArr;
    }

    public static int[] generateArr(int d, int n) {
        int[] arr = new int[n];
        String number = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                number = number + Integer.toString((int) ((Math.random() * ((9 - 0) + 1)) + 0));
            }
            arr[i] = Integer.parseInt(number);
            number = "";
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