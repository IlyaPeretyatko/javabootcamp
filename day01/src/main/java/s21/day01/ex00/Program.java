package s21.day01.ex00;

import java.util.UUID;

import static s21.day01.ex00.Transaction.TypeOfTransaction.CREDIT;
import static s21.day01.ex00.Transaction.TypeOfTransaction.DEBIT;

public class Program {
    public static void main(String[] args) {
        User Ilya = new User(UUID.randomUUID(), "Ilya", 33500);
        User Tinkoff = new User(UUID.randomUUID(), "Oleg", 0);
        System.out.println("ID user: " + Ilya.getId() + "  Name: " + Ilya.getName() + " Balance: " + Ilya.getBalance());
        System.out.println("ID user: " + Tinkoff.getId() + " Name: " + Tinkoff.getName() + " Balance: " + Tinkoff.getBalance());
        Tinkoff.setBalance(1000000);
        System.out.println("ID user: " + Tinkoff.getId() + " Name: " + Tinkoff.getName() + " Balance: " + Tinkoff.getBalance());
        Transaction debtRepaymentDebit = new Transaction(UUID.randomUUID(), DEBIT, Tinkoff, Ilya, 33500);
        Transaction debtRepaymentCredit = new Transaction(UUID.randomUUID(), CREDIT, Ilya, Tinkoff, -33500);
        System.out.println("ID transaction: " + debtRepaymentDebit.getId() + " Type: " + debtRepaymentDebit.getTypeOfTransaction() + " Receiver: " + debtRepaymentDebit.getReceiver().getName() + " Sender: " + debtRepaymentDebit.getSender().getName() + " Sum: " + debtRepaymentDebit.getSum());
        System.out.println("ID transaction: " + debtRepaymentCredit.getId() + " Type: " + debtRepaymentCredit.getTypeOfTransaction() + " Receiver: " + debtRepaymentCredit.getReceiver().getName() + " Sender: " + debtRepaymentCredit.getSender().getName() + " Sum: " + debtRepaymentCredit.getSum());
        System.out.println("ID user: " + Ilya.getId() + "  Name: " + Ilya.getName() + " Balance: " + Ilya.getBalance());
        System.out.println("ID user: " + Tinkoff.getId() + " Name: " + Tinkoff.getName() + " Balance: " + Tinkoff.getBalance());
        debtRepaymentDebit.setSum(13500);
        debtRepaymentCredit.setSum(-13500);
        System.out.println("ID transaction: " + debtRepaymentDebit.getId() + " Type: " + debtRepaymentDebit.getTypeOfTransaction() + " Receiver: " + debtRepaymentDebit.getReceiver().getName() + " Sender: " + debtRepaymentDebit.getSender().getName() + " Sum: " + debtRepaymentDebit.getSum());
        System.out.println("ID transaction: " + debtRepaymentCredit.getId() + " Type: " + debtRepaymentCredit.getTypeOfTransaction() + " Receiver: " + debtRepaymentCredit.getReceiver().getName() + " Sender: " + debtRepaymentCredit.getSender().getName() + " Sum: " + debtRepaymentCredit.getSum());
        System.out.println("ID user: " + Ilya.getId() + "  Name: " + Ilya.getName() + " Balance: " + Ilya.getBalance());
        System.out.println("ID user: " + Tinkoff.getId() + " Name: " + Tinkoff.getName() + " Balance: " + Tinkoff.getBalance());
    }
}
