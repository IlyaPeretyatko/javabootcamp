package s21.day01.ex04;


public interface UsersList {

    void addUser(User user);

    User getUser(int id);

    User getUserByIndex(int index);

    int getCountOfUsers();

}
