package s21.day01.ex02;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Illegal index or id of user.");
    }

}
