package s21.day00.ex03;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        long stat = 0;
        int lastNumberOfWeek = 0;
        while (true) {
            expression = scanner.next();
            if (expression.equals("Week")) {
                int numberOfWeek = scanner.nextInt();
                if (numberOfWeek < 1 || numberOfWeek > 18 || lastNumberOfWeek != numberOfWeek - 1) {
                    System.err.println("Illegal Argument");
                    scanner.close();
                    System.exit(-1);
                }
                lastNumberOfWeek++;
                int min = 10;
                for (int i = 0; i < 5; ++i) {
                    int mark = scanner.nextInt();
                    if (mark < min) {
                        min = mark;
                    }
                }
                long statOfWeek = 1;
                for (int i = 0; i < numberOfWeek - 1; ++i) {
                    statOfWeek *= 10;
                }
                statOfWeek *= min;
                stat += statOfWeek;
            } else {
                scanner.close();
                break;
            }
        }
        int countOfWeek = 1;
        while (stat != 0) {
            int mark = (int) (stat % 10);
            stat /= 10;
            System.out.print("Week " + countOfWeek + " ");
            countOfWeek++;
            for (int i = 0; i < mark; ++i) {
                System.out.print("=");
            }
            System.out.println(">");
        }
    }
}

