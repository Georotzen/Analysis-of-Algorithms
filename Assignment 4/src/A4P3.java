import java.util.Scanner;

public class A4P3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int n = input.nextInt();
        input.close();
        System.out.println(power(a, n));
    }

    static int power(int a, int n) {
        if (n == 0) {
            return 1;
        }
        else if (n % 2 == 0) {
            return power(a, n / 2) * power(a, n / 2);
        }
        else {
            return a * power(a, n / 2) * power(a, n / 2);
        }
    }

}