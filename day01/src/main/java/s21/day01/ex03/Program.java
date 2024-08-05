package s21.day01.ex03;

import java.util.UUID;

import static s21.day01.ex03.Transaction.TypeOfTransaction.CREDIT;
import static s21.day01.ex03.Transaction.TypeOfTransaction.DEBIT;

public class Program {
    public static void main(String[] args) {
        User Ilya = new User("Ilya", 33500);
        User Oleg = new User("Oleg", 1000);
        User Kolya = new User("Kolya", 300);
        UUID firstTransDebitId = UUID.randomUUID();
        UUID firstTransCreditId = UUID.randomUUID();
        UUID secondTransDebitId = UUID.randomUUID();
        UUID secondTransCreditId = UUID.randomUUID();
        Transaction firstTransDebit = new Transaction(firstTransDebitId, DEBIT, Oleg, Ilya, 23500);
        Transaction firstTransCredit = new Transaction(firstTransCreditId, CREDIT, Ilya, Oleg, -23500);
        Transaction secondTransDebit = new Transaction(secondTransDebitId, DEBIT, Kolya, Ilya, 5500);
        Transaction secondTransCredit = new Transaction(secondTransCreditId, CREDIT, Ilya, Kolya, -5500);
        TransactionsLinkedList transactionsLinkedList = new TransactionsLinkedList();
        transactionsLinkedList.addTransaction(firstTransDebit);
        transactionsLinkedList.addTransaction(firstTransCredit);
        transactionsLinkedList.addTransaction(secondTransDebit);
        transactionsLinkedList.addTransaction(secondTransCredit);
        Transaction[] transactions = transactionsLinkedList.toArray();
        for (Transaction transaction : transactions) {
            System.out.println("ID transaction: " + transaction.getId() + " Type: " + transaction.getTypeOfTransaction() + " Receiver: " + transaction.getReceiver().getName() + " Sender: " + transaction.getSender().getName() + " Sum: " + transaction.getSum());
        }
        transactionsLinkedList.deleteTransaction(firstTransCreditId);
        transactions = transactionsLinkedList.toArray();
        for (Transaction transaction : transactions) {
            System.out.println("ID transaction: " + transaction.getId() + " Type: " + transaction.getTypeOfTransaction() + " Receiver: " + transaction.getReceiver().getName() + " Sender: " + transaction.getSender().getName() + " Sum: " + transaction.getSum());
        }
    }
}

