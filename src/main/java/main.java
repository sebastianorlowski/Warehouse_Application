import api.*;
import dao.UserDaoImpl;
import entity.User;
import facade.UserFacadeImpl;
import service.ProductImpl;
import service.UserImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {

    private static UserFacade userFacade = UserFacadeImpl.getInstance();
    private static UserService userService = UserImpl.getInstance();
    private static ProductService productService = ProductImpl.getInstance();

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Wyswietl wszystkie produkty");
        System.out.println(productService.getAllProducts());



    }
}
