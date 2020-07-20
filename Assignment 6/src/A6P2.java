
public class A6P2 {
    static int start = 0;
    static int end = 0;
    public static void main(String[] args) {
        int[] arr = create();
        System.out.print("ARRAY: ");
        printArray(arr);
        System.out.println("SUM SUBARRAY: " + maxSubArr(arr, 0, arr.length - 1));
        System.out.print("MAX SUBARRAY: ");
        printSubArray(arr, start, end);
    }

    public static int[] create() {
        int random = (int) ((Math.random() * ((10 - 5) + 1)) + 5);
        int[] arr = new int[random];
        for (int i = 0; i < random; i++) {
            arr[i] = -10 + (int) (Math.random() * ((10 - (-10)) + 1));
        }
        return arr;
    }

    public static int maxSubArr(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }

        int m = (l + r) / 2;

        return Math.max(Math.max(maxSubArr(arr, l, m), maxSubArr(arr, m + 1, r)), maxCrossingArr(arr, l, m, r));
    }

    public static int maxCrossingArr(int[] arr, int l, int m, int r) {
        int currentSum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            currentSum = currentSum + arr[i];
            if (currentSum > leftSum) {
                leftSum = currentSum;
                start = i;
            }
        }

        currentSum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= r; i++) {
            currentSum = currentSum + arr[i];
            if (currentSum > rightSum) {
                rightSum = currentSum;
                end = i;
            }
        }

        return leftSum + rightSum;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printSubArray(int[] arr, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
