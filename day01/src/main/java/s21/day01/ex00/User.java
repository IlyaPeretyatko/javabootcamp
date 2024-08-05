package s21.day01.ex00;

import java.util.UUID;

public class User {

    public User(UUID id, String name, int balance) {
        this.id = id;
        this.name = name;
        setBalance(balance);
    }

    private final UUID id;

    private final String name;

    private int balance;

    public UUID getId() {
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
