
public class A6P1 {
    static int start = 0;
    static int end = 0;
    public static void main(String[] args) {
        int[] arr = create();
        System.out.print("ARRAY: ");
        printArray(arr);
        System.out.println("SUM SUBARRAY: " + maxSubArr(arr));
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

    public static int maxSubArr(int[] arr) {
        int largestSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = arr[i];
            if (currentSum > largestSum) {
                largestSum = currentSum;
                start = i;
                end = i;
            }
            for (int j = i + 1; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum > largestSum) {
                    largestSum = currentSum;
                    start = i;
                    end = j;
                }
            }
        }

        return largestSum;
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