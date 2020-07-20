import java.util.ArrayList; 

public class A2P2 {
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

       for (int i = 1; i < n; i++) {
           int key = arr.get(i);
           int j = i - 1;

           while (j >= 0 && arr.get(j) > key) {
               arr.set(j + 1, arr.get(j));
               j = j - 1;
           }

           arr.set(j + 1, key);
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