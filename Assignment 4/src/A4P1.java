
public class A4P1 {
    public static void main(String[] args) {
        int[] arr = create();
		print(arr);
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

	static int[] create() {
		int random = (int) ((Math.random() * ((10 - 5) + 1)) + 5);
        int[] arr = new int[random];
		for (int i = 0; i < random; i++) {
			arr[i] = (int) ((Math.random() * ((100 - 1) + 1)) + 1);
		}
		return arr;
    }
    
    static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid, int end) {
       int n1 = (mid - start + 1);
       int n2 = (end - mid);

       int L[] = new int[n1];
       int R[] = new int[n2];

       for (int i = 0; i < n1; i++) {
           L[i] = arr[start + i];
       }
       for (int j = 0; j < n2; j++) {
           R[j] = arr[mid + 1 + j];
       }

       int i = 0;
       int j = 0;
       int k = start;

       while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
       }
       while (i < n1) {
           arr[k] = L[i];
           i++;
           k++;
       }
       while (j < n2) {
            arr[k] = R[j];
           j++;
           k++;
       }
    }

    static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}