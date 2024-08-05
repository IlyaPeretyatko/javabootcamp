package s21.day01.ex05;

import java.util.UUID;

import static s21.day01.ex05.Transaction.TypeOfTransaction.CREDIT;
import static s21.day01.ex05.Transaction.TypeOfTransaction.DEBIT;

public class Transaction {

    public enum TypeOfTransaction {
        DEBIT,
        CREDIT
    }

    public Transaction(UUID id, TypeOfTransaction typeOfTransaction, User receiver, User sender, int sum) {
        this.id = id;
        this.typeOfTransaction = typeOfTransaction;
        this.receiver = receiver;
        this.sender = sender;
        setSum(sum);
    }

    private final UUID id;

    private final User receiver;

    private final User sender;

    private final TypeOfTransaction typeOfTransaction;

    private int sum;

    private Transaction nextTransaction;

    public UUID getId() {
        return id;
    }

    public User getReceiver() {
        return receiver;
    }

    public User getSender() {
        return sender;
    }

    public TypeOfTransaction getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        if ((typeOfTransaction == DEBIT && sum > 0) || (typeOfTransaction == CREDIT && sum < 0)) {
            receiver.setBalance(receiver.getBalance() - this.sum);
            receiver.setBalance(receiver.getBalance() + sum);
            this.sum = sum;
        } else {
            System.err.println("Illegal Sum Of Transaction.");
            System.exit(-1);
        }
    }

    public Transaction getNextTransaction() {
        return nextTransaction;
    }

    public void setNextTransaction(Transaction nextTransaction) {
        this.nextTransaction = nextTransaction;
    }

}
