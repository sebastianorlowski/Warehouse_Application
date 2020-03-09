import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import service.UserImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {

    private static UserDao userDao = UserDaoImpl.getInstance();
    private static UserService userService = UserImpl.getInstance();


    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello, please register!");
        System.out.println("Login ");
        String login = scanner.next();
        System.out.println("Password ");
        String password = scanner.next();
        System.out.println("Email ");
        String email = scanner.next();

        User user = new User(login, password, email);
        userService.addUser(user);

        System.out.println("Please give me login and password to change password");
        System.out.println("Login: ");
        String loginToChange = scanner.next();
        System.out.println("Password: ");
        String passwordToChange = scanner.next();
        System.out.println("New Password: ");
        String newPassword = scanner.next();

        userService.updateUserPassword(loginToChange, passwordToChange, newPassword);





    }
}
