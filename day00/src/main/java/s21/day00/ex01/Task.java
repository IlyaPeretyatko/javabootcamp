package s21.day00.ex01;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number < 2) {
            System.err.println("Illegal Argument");
            scanner.close();
            System.exit(-1);
        } else {
            int count = 0;
            boolean isSimple = true;
            for (int i = 2; i <= Math.ceil(Math.sqrt(number)); ++i) {
                if (number % i == 0) {
                    isSimple = false;
                    count++;
                    break;
                }
                count++;
            }
            System.out.println(isSimple + " " + count);
            scanner.close();
        }
    }
}
