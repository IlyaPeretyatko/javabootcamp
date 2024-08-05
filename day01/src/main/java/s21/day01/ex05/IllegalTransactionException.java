package s21.day01.ex05;

public class IllegalTransactionException extends RuntimeException {
    public IllegalTransactionException() {
        super("Illegal Transaction Exception");
    }
}
