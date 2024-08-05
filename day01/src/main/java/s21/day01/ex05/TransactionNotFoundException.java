package s21.day01.ex05;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException() {
        super("Illegal id of transaction.");
    }

}
