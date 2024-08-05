package s21.day01.ex02;



public class User {
    public User(String name, int balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        setBalance(balance);
    }

    private final int id;

    private final String name;

    private int balance;

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
            System.err.println("Illegal Balance.");
            System.exit(-1);
        }
        this.balance = balance;
    }
}
