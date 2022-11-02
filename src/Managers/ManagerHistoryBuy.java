package Managers;

import Entity.Buyer;
import Entity.HistoryBuy;
import Entity.Product;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ManagerHistoryBuy {

    private final Scanner scanner;
    public static int TotalSumma;
    public static int Product;
    public static int Buyer;
    public static int QuantityProduct_final;
    public ManagerHistoryBuy() {
        scanner = new Scanner(System.in);
    }
    public HistoryBuy createStoryList(Product[] products, Buyer[] buyers) throws IOException {

        String historyProduct = String.valueOf(products[Product-1].getTitle());

        HistoryBuy historyBuy = new HistoryBuy();
        historyBuy.setHistoryProductName(historyProduct);
        historyBuy.setHistoryProductPrice(String.valueOf(TotalSumma));
        historyBuy.setHistoryProductQantity(String.valueOf(QuantityProduct_final));
        historyBuy.setBuyer(buyers[Buyer - 1]);
        historyBuy.setBuyOnProduct(new GregorianCalendar().getTime());


        return historyBuy;
    }
    public void BuyProduct(Product[] products, Buyer[] buyers) {
        System.out.println("Список покупателей: ");
        for (int i = 0; i < buyers.length; i++) {
            System.out.println(i + 1);
            System.out.println(buyers[i].getFirstname());
            System.out.println(buyers[i].getLastname());
            System.out.println("номер телефона"+buyers[i].getPhone());
        }
        System.out.print("Номер покупателя: ");
        Buyer = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список продуктов: ");
        for (int j = 0; j < products.length; j++) {

            System.out.println("."+j + 1);
            System.out.println("Название продукта"+products[j].getTitle());
            System.out.println("Количество"+products[j].getQuantity());
            System.out.println("Цена продукта"+products[j].getPrice());
        }
        System.out.println();
        System.out.print("Выберите товар: ");
        Product = scanner.nextInt(); scanner.nextLine();
        System.out.print("Выберите кол-во товара: ");

        int QuantityProduct = scanner.nextInt(); scanner.nextLine();
        int a = products[Product - 1].getQuantity();
        int b = products[Product - 1].getPrice();

        if (QuantityProduct <= a) {
            int TotalSummaProduct = b * QuantityProduct;
            if (TotalSummaProduct > buyers[Buyer - 1].getCash()) {
                System.out.println("Недостаточно средств");
            } else {
                int balance = buyers[Buyer - 1].getCash() - TotalSummaProduct;
                buyers[Buyer - 1].setCash(balance);
                int ark = products[Product - 1].getQuantity() - QuantityProduct;
                products[Product - 1].setQuantity(ark);
                TotalSumma = TotalSummaProduct;
                QuantityProduct_final = QuantityProduct;

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
