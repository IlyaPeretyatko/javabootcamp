package s21.day00.ex04;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();
        int[] frea = new int[65535];
        for (char symb : text.toCharArray()) {
            frea[symb]++;
        }
        int countLet = 0;
        int maxNum = 0;
        char maxLet = ' ';
        int[] resNum = new int[10];
        char[] resLet = new char[10];
        int x = 0;
        int j = 0;
        for (int i = 0; i < 10; ++i) {
            for (; j < 65535; ++j) {
                if (maxNum < frea[j]) {
                    maxNum = frea[j];
                    maxLet = (char) j;
                    x = j;
                }
            }
            resNum[i] = maxNum;
            resLet[i] = maxLet;
            frea[x] = 0;
            if (maxNum != 0) {
                countLet++;
            }
            maxNum = 0;
            j = 0;

        }
        Print(resLet, resNum, countLet);
    }

    public static void Print(char[] arrLet, int[] arrNum, int countLet) {
        int maxValue = arrNum[0];
        System.out.println();
        for(int i = 0; i < 10; ++i) {
            if (arrNum[i] == maxValue) {
                System.out.print(maxValue + "    ");
            }
        }
        System.out.println();
        for (int i = 10; i > 0; --i) {
            for (int j = 0; j < 10; ++j) {
                if (arrNum[j] * 10 / maxValue >= i)
                    System.out.print("#    ");
                if (arrNum[j] * 10 / maxValue == i - 1) {
                    if (arrNum[j] != 0)
                        System.out.print(arrNum[j] + "    ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < countLet; ++i) {
            System.out.print((char)arrLet[i] + "    ");
        }
    }
}