package s21.day00.ex05;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        int countOfStudents = 0;
        String[] students = new String[10];
        Scanner scanner = new Scanner(System.in);
        String expression;
        while (true) {
            expression = scanner.next();
            if (expression.equals(".") || countOfStudents == 10) {
                break;
            }
            students[countOfStudents] = expression;
            countOfStudents++;
        }
        int countOfSubjects = 0;
        int[] timesOfSubjects = new int[10];
        String[] daysOfSubject = new String[10];
        while (true) {
            expression = scanner.next();
            if (expression.equals(".") || countOfSubjects == 10) {
                break;
            }
            int time = Integer.parseInt(expression);
            timesOfSubjects[countOfSubjects] = time;
            daysOfSubject[countOfSubjects] = scanner.next();
            countOfSubjects++;
        }
        int[][][] attendance = new int[countOfStudents][5][30];
        while (true) {
            expression = scanner.next();
            if (expression.equals(".")) {
                break;
            }
            int numberOfStudent = -1;
            for (int i = 0; i < countOfStudents; ++i) {
                if (expression.equals(students[i])) {
                    numberOfStudent = i;
                    break;
                }
            }
            int time = scanner.nextInt();
            int day = scanner.nextInt();
            String isArrive = scanner.next();
            int arrived = -1;
            if (isArrive.equals("HERE")) {
                arrived = 1;
            }
            attendance[numberOfStudent][time][day - 1] = arrived;
        }
        scanner.close();
        print(countOfStudents, countOfSubjects, daysOfSubject, timesOfSubjects, students, attendance);
    }

    private static void print(int countOfStudents, int countOfSubjects, String[] daysOfSubject, int[] timesOfSubjects, String[] students, int[][][] attendance) {
        System.out.print("          ");
        for (int i = 1; i < 31; ++i) {
            String thisDay = getDayOfWeek(i);
            for (int j = 0; j < countOfSubjects; ++j) {
                if (daysOfSubject[j].equals(thisDay)) {
                    System.out.print(timesOfSubjects[j] + ":00 " + thisDay + "  " + i + "|");
                }
            }
        }
        System.out.println();
        for (int i = 0; i < countOfStudents; ++i) {
            System.out.print(students[i]);
            for (int m = 0; m < 10 - students[i].length(); ++m) {
                System.out.print(" ");
            }
            for (int j = 1; j < 31; ++j) {
                String thisDay = getDayOfWeek(j);
                for (int k = 0; k < countOfSubjects; ++k) {
                    if (daysOfSubject[k].equals(thisDay)) {
                        if (attendance[i][timesOfSubjects[k]][j - 1] == 0) {
                            if (j > 9) {
                                System.out.print("           |");
                            } else {
                                System.out.print("          |");
                            }
                        } else {
                            System.out.print("         " + attendance[i][timesOfSubjects[k]][j - 1] + "|");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    private static String getDayOfWeek(int i) {
        String day = "";
        switch (i % 7) {
            case 0:
                day = "MO";
                break;
            case 1:
                day = "TU";
                break;
            case 2:
                day = "WE";
                break;
            case 3:
                day = "TH";
                break;
            case 4:
                day = "FR";
                break;
            case 5:
                day = "SA";
                break;
            case 6:
                day = "SU";
                break;
        }
        return day;
    }
}


