import java.util.Scanner;

public class A10P1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("n = ");
        int n = input.nextInt();
        print(heapsort(generateArray(n)));
        input.close();
    }

    static int[] heapsort(int[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = (n - 1); i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;

        if ((l < n) && (arr[l] > arr[largest])) {
            largest = l;
        }

        if ((r < n) && (arr[r] > arr[largest])) {
            largest = r;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }

    }

    static int[] generateArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) ((Math.random() * ((100 - 0) + 1)) + 0);
        }
        print(arr);
        System.out.println();
        return arr;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}