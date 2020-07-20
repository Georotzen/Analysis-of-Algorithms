public class A4P2 {
    public static void main(String[] args) {
        int[] arr = create();
        //int v = (int) ((Math.random() * ((100 - 1) + 1)) + 1);
        int v = 50;
        sort(arr, 0, arr.length - 1);
        print(arr);
        System.out.println("v = " + v + " found in array? " + search(arr, v));
    }

    static boolean search(int[] arr, int v){
        int low = 0;
        int high = arr.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (v == arr[mid]) {
                return true;
            }
            else if (v > arr[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }

	static int[] create() {
		int random = (int) ((Math.random() * ((10 - 5) + 1)) + 5);
        int[] arr = new int[random];
		for (int i = 0; i < random; i++) {
			arr[i] = (int) ((Math.random() * ((100 - 1) + 1)) + 1);
        }
        arr[(int)((Math.random() * ((arr.length - 0) + 1)) + 0)] = 50;
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