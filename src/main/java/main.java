import api.UserDao;
import entity.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {


    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<User> users = new LinkedList<User>();

        System.out.println("Hello");
        System.out.print("Please enter your login ");
        String login = scanner.next();
        System.out.println();
        System.out.print("Please enter your password ");
        String password = scanner.next();
        System.out.println();
        System.out.println("Please enter your email ");
        String email = scanner.next();

        User user = new User(login, password, email);
        users.add(user);
        UserDao userDao = new UserDao(users);
    }
}
