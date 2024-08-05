package s21.day01.ex05;

import java.util.Scanner;
import java.util.UUID;

public class Menu {

    private  TransactionsService transactionsService;

    public Menu() {
        transactionsService = new TransactionsService();
    }

    public void display(boolean dev) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a user.");
            System.out.println("2. View user balances.");
            System.out.println("3. Perform a transfer.");
            System.out.println("4. View all transactions for a specific user.");
            if (dev) {
                System.out.println("5. DEV – remove a transfer by ID.");
                System.out.println("6. DEV – check transfer validity.");
            }
            System.out.println("7. Finish execution.");
            String strOption = scanner.next();
            int option;
            try {
                option = Integer.parseInt(strOption);
            } catch (NumberFormatException e) {
                System.err.println("Illegal Input.");
                continue;
            }
            if (option == 1) {
                System.out.println("Enter a user name and a balance.");
                String name = scanner.next();
                String strBalance = scanner.next();
                int balance;
                try {
                    balance = Integer.parseInt(strBalance);
                } catch (NumberFormatException e) {
                    System.err.println("Illegal Input.");
                    continue;
                }
                User user = new User(name, balance);
                transactionsService.addUser(user);
                System.out.println("User with id = " + user.getId() +" is added.");
            } else if (option == 2) {
                System.out.println("Enter a user ID.");
                int id;
                String strId = scanner.next();
                try {
                    id = Integer.parseInt(strId);
                } catch (NumberFormatException e) {
                    System.err.println("Illegal Input.");
                    continue;
                }
                System.out.println(transactionsService.getUserName(id) + " - " + transactionsService.getBalanceOfUser(id));
            } else if (option == 3) {
                System.out.println("Enter a sender ID, a recipient ID, and a transfer amount.");
                int fromId;
                int toId;
                int sum;
                String strFromId = scanner.next();
                String strToId = scanner.next();
                String strSum = scanner.next();
                try {
                    fromId = Integer.parseInt(strFromId);
                    toId = Integer.parseInt(strToId);
                    sum = Integer.parseInt(strSum);
                } catch (NumberFormatException e) {
                    System.err.println("Illegal Input.");
                    continue;
                }
                transactionsService.transfer(fromId, toId, sum);
                System.out.println("The transfer is completed.");
            } else if (option == 4) {
                System.out.println("Enter a user ID.");
                int id;
                String strId = scanner.next();
                try {
                    id = Integer.parseInt(strId);
                } catch (NumberFormatException e) {
                    System.err.println("Illegal Input.");
                    continue;
                }
                Transaction[] transactions = transactionsService.getTransfersOfUser(id);
                for (Transaction transaction : transactions) {
                    System.out.println("To " + transaction.getReceiver().getName() + "(id = " + id + ") " + transaction.getSum() + " with id = " + transaction.getId() + ".");
                }
            } else if (option == 5 && dev) {
                System.out.println("Enter a user ID and a transfer ID.");
                int id;
                String strId = scanner.next();
                String strTransId = scanner.next();
                try {
                    id = Integer.parseInt(strId);
                } catch (NumberFormatException e) {
                    System.err.println("Illegal Input.");
                    continue;
                }
                transactionsService.deleteTransferOfUserById(id, UUID.fromString(strTransId));
                System.out.println("Transfer To " + transactionsService.getUserName(id) + "(id =" + id + ") " + strTransId + " removed.");
            } else if (option == 6 && dev) {
                System.out.println("Check results:");
                Transaction[] transactions = transactionsService.getNotPairedTransactions();
                for (Transaction transaction : transactions) {
                    System.out.println(transaction.getReceiver().getName() + "(id = " + transaction.getReceiver().getId() + ") has an unacknowledged transfer id = " + transaction.getId() + " from " + transaction.getSender().getName() + "(id = " + transaction.getSender().getId() + ") for " + transaction.getSum() + ".");
                }
            } else if (option == 7) {
                break;
            }
        }
        scanner.close();
    }

}
