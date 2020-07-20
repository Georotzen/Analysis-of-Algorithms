import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

class MinHeapNode {
    double element;
    int i;
    int j;

    // Constructor
    public MinHeapNode(double element, int i, int j) {
        this.element = element;
        this.i = i;
        this.j = j;
    }
}

class MinHeap {
    MinHeapNode[] heapArr;
    int heapSize;

    // Constructor
    public MinHeap(MinHeapNode arr[], int size) {
        heapSize = size;
        heapArr = arr;

        int i = (heapSize - 1) / 2;

        while ( i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    // it heapifies a subtree with root given
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heapSize && heapArr[l].element < heapArr[i].element) {
            smallest = l;
        }
        if (r < heapSize && heapArr[r].element < heapArr[smallest].element) {
            smallest = r;
        }
        if (smallest != i) {
            swap(heapArr, i, smallest);
            MinHeapify(smallest);
        }
    }

    // Get index of left child of the node at index i
    int left(int i) {
        return (2 * i + 1);
    }

    // Get index of right child of the node at index i
    int right(int i) {
        return (2 * i + 2);
    }

    // Get root
    MinHeapNode getMin() {
        if (heapSize <= 0) {
            return null;
        }
        return heapArr[0];
    }

    // Replace root
    void replaceMin(MinHeapNode root) {
        heapArr[0] = root;
        MinHeapify(0);
    }

    // Swap two min heap nodes
    void swap(MinHeapNode[] arr, int i, int j) {
        MinHeapNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class A10P2 {

    static double[] mergeKSortedArrays(double[][] arr, int k) {
    // Create min heap and insert the first elem of each Arr into the heap
    // get root add it to the result and then replace the root for the next min
    MinHeapNode[] heapArr = new MinHeapNode[k];
        int n = 0;

        for (int i = 0; i < arr.length; i++) {
            MinHeapNode node = new MinHeapNode(arr[i][0], i, 1);
            heapArr[i] = node;
            n += arr[i].length;
        }
        // create min heap with k heap nodes. every heap node has first element of an array
        MinHeap minHeap = new MinHeap(heapArr, k);

        double[] sortedArr = new double[n];

        for (int i = 0; i < n; i++) {
            // get root and store it in result
            MinHeapNode root = minHeap.getMin();
            sortedArr[i] = root.element;

            // prepare next root, they belong to the same arr as curr root
            if (root.j < arr[root.i].length) {
                root.element = arr[root.i][root.j++];
            }
            // no more elements
            else {
                root.element = Integer.MAX_VALUE;
            }
            // replace curr root with next element
            minHeap.replaceMin(root);
        }
        return sortedArr; 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("k = ");
        int k = input.nextInt();

        System.out.print("l = ");
        int l = input.nextInt();

        double[][] arr = new double[k][l];
        arr = generateArrays(k, l);
        print(arr, k, l);

        double[] sortedArr = mergeKSortedArrays(arr, k);
        print(sortedArr);

        input.close();
    }

    static double[][] generateArrays(int k, int l) {
        double[][] arr = new double[k][l];
        double a = 0;
        double b = 1;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                double random = a + (new Random().nextDouble() * (b - a));
                arr[i][j] = random;
                a = random;
            }
            a = 0;
        }
        return arr;
    }

    static void print(double[][] arr, int k, int l) {
        System.out.println();
        DecimalFormat newFormat = new DecimalFormat("0.0000");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(newFormat.format(arr[i][j]) + " ");
            }
            System.out.println();
        }
    }

    static void print(double[] arr) {
        System.out.println();
        DecimalFormat newFormat = new DecimalFormat("0.0000");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(newFormat.format(arr[i]) + " ");
        }
    }
}