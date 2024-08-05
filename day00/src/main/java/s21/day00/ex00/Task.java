package s21.day00.ex00;

public class Task {
    public static void main(String[] args) {
        int number = 583;
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println(sum);
    }
}
