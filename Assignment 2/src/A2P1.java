import java.util.ArrayList;

public class A2P1 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
		
		print(create(arr));
		print(sort(arr));
    }

	static ArrayList<Integer> create(ArrayList<Integer> arr) {
		int random = (int) ((Math.random() * ((10 - 2) + 1)) + 2);
		
		for (int i = 0; i < random; i++) {
			arr.add((int) ((Math.random() * ((100 - 1) + 1)) + 1));
		}
		return arr;
    }
    
    static ArrayList<Integer> sort(ArrayList<Integer> arr) {
        int n = arr.size();

        for (int i = 0; i < (n - 1); i++) {
            int minIndex = i;

            for (int j = (i + 1); j < n; j++) {
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }

            int temp = arr.get(minIndex);
            arr.set(minIndex, arr.get(i));
            arr.set(i, temp);
        }
        return arr;
    }

    static void print(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}
}