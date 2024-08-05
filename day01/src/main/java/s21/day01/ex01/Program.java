package s21.day01.ex01;


public class Program {
    public static void main(String[] args) {
        User person = new User("Ilya", 4444);
        System.out.println("Id: " + person.getId() + " Name: " + person.getName() + " Balance: " + person.getBalance());
        User animal = new User("Bobik", 200);
        System.out.println("Id: " + animal.getId() + " Name: " + animal.getName() + " Balance: " + animal.getBalance());
    }
}
