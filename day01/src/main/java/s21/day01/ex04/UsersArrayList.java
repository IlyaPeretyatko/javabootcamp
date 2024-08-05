package s21.day01.ex04;


public class UsersArrayList implements UsersList {

    User[] users;

    int size;

    int capacity;

    public UsersArrayList() {
        capacity = 10;
        users = new User[capacity];
    }

    @Override
    public void addUser(User user) {
        users[size] = user;
        size++;
        if (size == capacity) {
            capacity *= 2;
            User[] newArray = new User[capacity];
            System.arraycopy(users, 0, newArray, 0, capacity / 2);
            users = newArray;
        }
    }

    @Override
    public User getUser(int id) {
        for (int i = 0; i < size; ++i) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex(int index) {
        if (index >= size || index < 0) {
            throw new UserNotFoundException();
        }
        return users[index];
    }

    @Override
    public int getCountOfUsers() {
        return size;
    }
}
