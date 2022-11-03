package managers;

import entity.Buyer;
import entity.HistoryBuy;
import entity.Product;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ManagerHistoryBuy {

    private final Scanner scanner;
    public static int totalSumma;
    public int product;
    public int buyer;
    public  int quantityBuyingProduct_final;
    public ManagerHistoryBuy() {
        scanner = new Scanner(System.in);
    }
    public HistoryBuy createStoryList(Product[] products, Buyer[] buyers) throws IOException {

        String historyProduct = String.valueOf(products[product-1].getTitle());

        HistoryBuy historyBuy = new HistoryBuy();
        historyBuy.setHistoryProductName(historyProduct);
        historyBuy.setHistoryProductPrice(String.valueOf(totalSumma));
        historyBuy.setHistoryProductQantity(String.valueOf(quantityBuyingProduct_final));
        historyBuy.setBuyer(buyers[buyer - 1]);
        historyBuy.setBuyOnProduct(new GregorianCalendar().getTime());


        return historyBuy;
    }
    public void buyProduct(Product[] products, Buyer[] buyers) {
        System.out.println("Список покупателей: ");
        for (int i = 0; i < buyers.length; i++) {
            System.out.println(i + 1);
            System.out.println(buyers[i].getFirstname());
            System.out.println(buyers[i].getLastname());
            System.out.println("номер телефона"+buyers[i].getPhone());
        }
        System.out.print("Номер покупателя: ");
        buyer = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список продуктов: ");
        for (int j = 0; j < products.length; j++) {

            System.out.println("."+j + 1);
            System.out.println("Название продукта"+products[j].getTitle());
            System.out.println("Количество"+products[j].getQuantity());
            System.out.println("Цена продукта"+products[j].getPrice());
        }
        System.out.println();
        System.out.print("Выберите товар: ");
        product = scanner.nextInt(); scanner.nextLine();
        System.out.print("Выберите кол-во товара: ");

        int quantityBuyingProduct = scanner.nextInt(); scanner.nextLine();
        int productQuantity = products[product - 1].getQuantity();
        int productPrice = products[product - 1].getPrice();

        if (quantityBuyingProduct <=productQuantity) {
            int totalPrisePushares = productPrice * quantityBuyingProduct;
            if (productPrice > buyers[buyer - 1].getCash()) {
                System.out.println("Недостаточно средств");
            } else {
                int balance = buyers[buyer - 1].getCash() - totalPrisePushares;
                buyers[buyer - 1].setCash(balance);
                int ark = products[product - 1].getQuantity() - quantityBuyingProduct;
                products[product - 1].setQuantity(ark);
                totalSumma = totalPrisePushares;
                quantityBuyingProduct_final = quantityBuyingProduct;

                System.out.println("Балланс: " + balance);
            }
        } else {
            System.out.println("Товара нет");
        }
    }
    public void printListBuys(HistoryBuy[] historyBuys) {
        for (int i = 0; i < historyBuys.length; i++) {
            System.out.println(i + 1);
            System.out.println("Название продукта"+historyBuys[i].getHistoryProductName());
            System.out.println("Цена продукта"+historyBuys[i].getHistoryProductPrice());
            System.out.println("Колл-во продукта"+historyBuys[i].getHistoryProductQantity());
            System.out.println("Покупатель"+historyBuys[i].getBuyer());
            System.out.println(""+historyBuys[i].getBuyOnProduct());
        }
        System.out.println();
    }



}
