import api.*;
import dao.UserDaoImpl;
import entity.Product;
import entity.User;
import enums.Color;
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

        System.out.println("Dodaj produkt");
        String name;
        Float price;
        Float weight;
        Color color;
        Integer productCount;
        String size;
        String material;

        System.out.println("Podaj nazwę");
        name = scanner.next();

        System.out.println("Podaj cenę");
        price = scanner.nextFloat();

        System.out.println("Podaj wage");
        weight = scanner.nextFloat();

        System.out.println("Podaj kolor");
        color = Color.valueOf(scanner.next());

        System.out.println("Podaj ilosc");
        productCount = scanner.nextInt();

        System.out.println("Podaj rozmiar");
        size = scanner.next();

        System.out.println("Podaj material");
        material = scanner.next();

        Product product = new Product(name, price, weight, color, productCount, size, material);
        productService.addProduct(product);


    }
}
