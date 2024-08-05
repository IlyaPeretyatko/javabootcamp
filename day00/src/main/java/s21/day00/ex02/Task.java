package s21.day00.ex02;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            int number = scanner.nextInt();
            if (number < 2) {
                System.err.println("Illegal Argument");
            }
            if (number == 42) {
                break;
            }
            int sum = 0;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            boolean isSimple = true;
            for (int i = 2; i <= Math.ceil(Math.sqrt(sum)); ++i) {
                if (sum % i == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) {
                count++;
            }
        }
        System.out.println("Count of coffee-request – " + count);
        scanner.close();
    }
}
