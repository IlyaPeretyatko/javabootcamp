package s21.day01.ex05;


import java.util.UUID;

import static s21.day01.ex05.Transaction.TypeOfTransaction.DEBIT;
import static s21.day01.ex05.Transaction.TypeOfTransaction.CREDIT;

public class TransactionsService {

    UsersList usersList;

    public TransactionsService() {
        usersList = new UsersArrayList();
    }

    public void addUser(User user) {
        usersList.addUser(user);
    }

    public int getBalanceOfUser(int id) {
        return usersList.getUser(id).getBalance();
    }

    public String getUserName(int id) {
        return usersList.getUser(id).getName();
    }

    public void transfer(int idFrom, int idTo, int sum) {
        User from = usersList.getUser(idFrom);
        User to = usersList.getUser(idTo);
        UUID id = UUID.randomUUID();
        Transaction debit = new Transaction(id, DEBIT, to, from, sum);
        Transaction credit = new Transaction(id, CREDIT, from, to, -sum);
        from.getTransactionsList().addTransaction(credit);
        to.getTransactionsList().addTransaction(debit);
    }

    public Transaction[] getTransfersOfUser(int id) {
        return usersList.getUser(id).getTransactionsList().toArray();
    }

    public void deleteTransferOfUserById(int id, UUID idTrans) {
        usersList.getUser(id).getTransactionsList().deleteTransaction(idTrans);
    }

    public Transaction[] getNotPairedTransactions() {
        Transaction[] allTransactions = getAllTransaction().toArray();
        TransactionsLinkedList listNotPairedTransactions = new TransactionsLinkedList();
        int counter = 0;
        for ( int i = 0; i < allTransactions.length; ++i) {
            UUID id = allTransactions[i].getId();
            counter = 0;
            for ( int j = 0; j < allTransactions.length; ++j) {
                if (id.equals(allTransactions[j].getId())) {
                    counter++;
                }
            }
            if (counter != 2) {
                Transaction tmp = allTransactions[i];
                listNotPairedTransactions.addTransaction(tmp);
            }
        }
        return listNotPairedTransactions.toArray();

    }

    private TransactionsLinkedList getAllTransaction() {
        TransactionsLinkedList allTransactions  = new TransactionsLinkedList();
        for (int i = 0; i < usersList.getCountOfUsers(); ++i ) {
            Transaction[] arrayUsersTransactions = usersList.getUserByIndex(i).getTransactionsList().toArray();
            for (int  j = 0; j < usersList.getUserByIndex(i).getTransactionsList().getSize(); ++j) {
                Transaction tmp = arrayUsersTransactions[j];
                allTransactions.addTransaction(tmp);
            }
        }
        return allTransactions;
    }

}
