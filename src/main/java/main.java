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
        System.out.println("Is correct login and password");
        System.out.println("Login: ");
        String login = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();
        System.out.println(userService.isCorrectLoginAndPassword(login, password));

    }
}
