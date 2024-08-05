package s21.day01.ex04;


import java.util.UUID;

import static s21.day01.ex04.Transaction.TypeOfTransaction.DEBIT;

public class Program {
    public static void main(String[] args) {
        TransactionsService transactionsService = new TransactionsService();
        User Ilya = new User("Ilya", 33500);
        User Oleg = new User("Oleg", 1000);
        User Kolya = new User("Kolya", 300);
        transactionsService.addUser(Ilya);
        transactionsService.addUser(Oleg);
        transactionsService.addUser(Kolya);
        transactionsService.transfer(Ilya.getId(), Oleg.getId(), 13500);
        transactionsService.transfer(Ilya.getId(), Kolya.getId(), 10000);
        System.out.println("Transaction of Ilya:");
        for (Transaction transaction : transactionsService.getTransfersOfUser(Ilya.getId())) {
            System.out.println("ID transaction: " + transaction.getId() + " Type: " + transaction.getTypeOfTransaction() + " Receiver: " + transaction.getReceiver().getName() + " Sender: " + transaction.getSender().getName() + " Sum: " + transaction.getSum());
        }
        System.out.println("Transaction of Oleg:");
        for (Transaction transaction : transactionsService.getTransfersOfUser(Oleg.getId())) {
            System.out.println("ID transaction: " + transaction.getId() + " Type: " + transaction.getTypeOfTransaction() + " Receiver: " + transaction.getReceiver().getName() + " Sender: " + transaction.getSender().getName() + " Sum: " + transaction.getSum());
        }
        System.out.println("Transaction of Kolya:");
        for (Transaction transaction : transactionsService.getTransfersOfUser(Kolya.getId())) {
            System.out.println("ID transaction: " + transaction.getId() + " Type: " + transaction.getTypeOfTransaction() + " Receiver: " + transaction.getReceiver().getName() + " Sender: " + transaction.getSender().getName() + " Sum: " + transaction.getSum());
        }
        Ilya.getTransactionsList().addTransaction(new Transaction(UUID.randomUUID(), DEBIT, Ilya, Kolya, 1000));
        System.out.println("Not paired transactions:");
        Transaction[] notPairedTransactions = transactionsService.getNotPairedTransactions();
        for (Transaction transaction : notPairedTransactions) {
            System.out.println("ID transaction: " + transaction.getId() + " Type: " + transaction.getTypeOfTransaction() + " Receiver: " + transaction.getReceiver().getName() + " Sender: " + transaction.getSender().getName() + " Sum: " + transaction.getSum());
        }
        System.out.println("Balance of Ilya: " + transactionsService.getBalanceOfUser(Ilya.getId()));
    }
}
