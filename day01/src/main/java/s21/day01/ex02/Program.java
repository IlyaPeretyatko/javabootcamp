package s21.day01.ex02;


public class Program {
    public static void main(String[] args) {
        UsersArrayList usersArrayList = new UsersArrayList();
        User person = new User("Ilya", 4444);
        System.out.println("Id: " + person.getId() + " Name: " + person.getName() + " Balance: " + person.getBalance());
        User animal = new User("Bobik", 200);
        System.out.println("Id: " + animal.getId() + " Name: " + animal.getName() + " Balance: " + animal.getBalance());
        usersArrayList.addUser(person);
        usersArrayList.addUser(animal);
        System.out.println(usersArrayList.getCountOfUsers());
        User firstUser = usersArrayList.getUser(1);
        User secondUser = usersArrayList.getUserByIndex(1);
        System.out.println("Id: " + firstUser.getId() + " Name: " + firstUser.getName() + " Balance: " + firstUser.getBalance());
        System.out.println("Id: " + secondUser.getId() + " Name: " + secondUser.getName() + " Balance: " + secondUser.getBalance());
    }
}
