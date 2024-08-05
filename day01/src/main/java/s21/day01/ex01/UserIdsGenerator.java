package s21.day01.ex01;


public class UserIdsGenerator {

    private int id;

    private static UserIdsGenerator instance;

    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public int generateId() {
        return ++id;

    }

}
