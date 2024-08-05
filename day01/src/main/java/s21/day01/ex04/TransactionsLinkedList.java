package s21.day01.ex04;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private Transaction head;

    private int size;

    @Override
    public void addTransaction(Transaction transaction) {
        if (head != null) {
            transaction.setNextTransaction(head);
        }
        transaction.setNextTransaction(head);
        head = transaction;
        size++;
    }

    @Override
    public void deleteTransaction(UUID id) {
        Transaction beforePointer = null;
        Transaction pointer = head;
        while (pointer != null) {
            if (pointer.getId().equals(id)) {
                if (beforePointer == null) {
                    head = head.getNextTransaction();
                } else {
                    beforePointer = pointer.getNextTransaction();
                }
                size--;
                return;
            }
            beforePointer = pointer;
            pointer = pointer.getNextTransaction();
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[size];
        Transaction pointer = head;
        for (int i = size - 1; i >= 0; --i) {
            transactions[i] = pointer;
            pointer = pointer.getNextTransaction();
        }
        return transactions;
    }

    public int getSize() {
        return size;
    }
}
