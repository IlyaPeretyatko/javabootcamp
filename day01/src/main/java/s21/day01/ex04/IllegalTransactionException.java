package s21.day01.ex04;

public class IllegalTransactionException extends RuntimeException {
    public IllegalTransactionException() {
        super("Illegal Transaction Exception");
    }
}
