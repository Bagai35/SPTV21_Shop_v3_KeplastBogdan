package Managers;

import Entity.Product;

import java.util.Scanner;

public class ManagerBookProduct {

    Scanner scanner;

    public ManagerBookProduct() {
        scanner = new Scanner(System.in);
    }

    public Product createBookProduct() {
        System.out.print("Введите название продукта: ");
        String productName = scanner.nextLine();
        System.out.print("Введите количество продуктов: ");
        String quantity = scanner.nextLine();
        System.out.print("Введите цену продукта: ");
        String price = scanner.nextLine();
        Product product = createProduct(productName, Integer.parseInt(quantity), new Integer(price));
        return product;
    }

    public Product createProduct(String productName, int quantity, int price) {
        Product product = new Product();
        product.setTitle(productName);
        product.setQuantity(quantity);
        product.setPrice(price);
        return product;
    }

    public void printListBookProduct(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.print("."+i + 1);
            System.out.print("Название продукта"+products[i].getTitle());
            System.out.print("Количество"+products[i].getQuantity());
            System.out.print("Цена продукта"+products[i].getPrice());
        }
        System.out.println();
    }

    public void ProductChange(Product[] products) {
        printListBookProduct(products);
        System.out.print("Выберите номер продукта: ");
        int ProductNumberValues = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Название продукта: ");
        System.out.println(products[ProductNumberValues - 1].getTitle());
        System.out.print("Изменить название? (да/нет)");
        String edit = scanner.nextLine();
        if (edit.equals("да")) {
            System.out.print("Введите новое название: ");
            products[ProductNumberValues - 1].setTitle(scanner.nextLine());
        }
        System.out.print("Изменить цену: ");
        System.out.println(products[ProductNumberValues - 1].getPrice());
        System.out.print("Изменить цену? (да/нет)");
        edit = scanner.nextLine();
        if (edit.equals("да")) {
            System.out.print("Введите новое цену: ");
            products[ProductNumberValues - 1].setPrice(scanner.nextInt());
            scanner.nextLine();
        }
        System.out.print("Количество товара: ");
        System.out.println(products[ProductNumberValues - 1].getQuantity());
        System.out.print("Изменить количество? (да/нет)");
        edit = scanner.nextLine();
        if (edit.equals("да")) {
            System.out.print("Введите количество: ");
            products[ProductNumberValues - 1].setQuantity(scanner.nextInt());
            scanner.nextLine();
        }
    }
}
