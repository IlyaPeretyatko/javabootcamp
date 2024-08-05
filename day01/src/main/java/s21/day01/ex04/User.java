package s21.day01.ex04;


public class User {
    public User(String name, int balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.transactionsList = new TransactionsLinkedList();
        setBalance(balance);
    }

    private final int id;

    private final String name;

    private int balance;

    private final TransactionsList transactionsList;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance < 0) {
            throw new IllegalTransactionException();
        }
        this.balance = balance;
    }

    public TransactionsList getTransactionsList() {
        return transactionsList;
    }

}
