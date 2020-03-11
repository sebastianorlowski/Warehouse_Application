import api.UserDao;
import api.UserFacade;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import facade.UserFacadeImpl;
import service.UserImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {

    private static UserFacade userFacade = UserFacadeImpl.getInstance();

    static Scanner scanner = new Scanner(System.in);

    public static void logIn() {
        boolean app = true;
        while(app = true) {
            System.out.println("Zaloguj się");
            System.out.println("Login ");
            String login = scanner.next();
            System.out.println("Password ");
            String password = scanner.next();
            if (userFacade.loginUser(login,password)) {
                System.out.println("Zalogowałeś się poprawnie");
            }
            else {
                System.out.println("Zły login lub hasło!");
            }


            System.out.println("Chcesz skończyć? 1 nie, 2 tak");
            int finish = scanner.nextInt();

            switch (finish) {
                case 1:
                    app = true;
                case 2:
                    app = false;
                    System.exit(1);
            }
        }
    }
    public static void main(String[] args) {
        logIn();

        System.out.println("Register");
        System.out.println("Login: ");
        String login = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();
        System.out.println("EmailL ");
        String email = scanner.next();
        User user = new User(login, password, email);
        userFacade.registerUser(user);


    }
}
