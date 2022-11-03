package ShopApp;

import Entity.BookProduct;
import Entity.Buyer;
import Entity.HistoryBuy;
import Entity.Product;
import Entity.Market;
import Managers.ManagerBookProduct;
import Managers.ManagerBuyer;
import Managers.ManagerHistoryBuy;
import Managers.MarketManagers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    private final Scanner scanner;
    private Buyer[] buyers;

    private Market[] markets;

    private Product[] products;
    private HistoryBuy[] historyBuys;
    private final ManagerBuyer managerBuyer;
    private final ManagerBookProduct managerBookProduct;
    private final ManagerHistoryBuy managerHistoryBuy;

    private final MarketManagers marketManagers;

    private final BookProduct bookProduct;
    private HistoryBuy historyBuy;
    

    public App(){
        scanner = new Scanner(System.in);
        buyers = new Buyer[0];
        products = new Product[0];
        historyBuys = new HistoryBuy[0];
        managerBuyer = new ManagerBuyer();
        managerBookProduct = new ManagerBookProduct();
        managerHistoryBuy = new ManagerHistoryBuy();
        bookProduct = new BookProduct();
        marketManagers = new MarketManagers();
        Market[] market = new Market[0];
    }

    public void run() throws IOException {
        boolean repeat = true;
        do {
            System.out.println("");
            System.out.println("Задача");
            System.out.println("");
            System.out.println("0 - выход - 0");
            System.out.println("1 - добавить продукт");
            System.out.println("2 - добавить покупателя");
            System.out.println("3 - Список продуктов");
            System.out.println("4 - Список покупателей");
            System.out.println("5 - Выдать товар");
            System.out.println("6 - История покупок");
            System.out.println("7 - Добавить денег покупателю");
            System.out.println("8 - Посмотреть баланс");
            System.out.println("9 - Изменить данные о товаре");
            System.out.println("10 - Удаление продукта");
            System.out.println("11 - Прибыль магазина");

            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0 : repeat = false;
                case 1 :
                    System.out.println("1. Добавить продукт");
                    addProduct(managerBookProduct.createBookProduct());
                    break;

                case 2 :
                    System.out.println("2. Добавить покупателя");
                    addBuyer(managerBuyer.newBuyer());
                    break;
                case 3 :
                    System.out.println("3. Список продуктов");
                    managerBookProduct.printListBookProduct(products);
                    break;
                case 4 :
                    System.out.println("4. Список покупателей");
                    managerBuyer.printListBuyer(buyers);
                    break;
                case 5 :
                    System.out.println("5. Купить товар");
                    managerHistoryBuy.BuyProduct(products, buyers);
                    addCashMarket(marketManagers.createMarketList());
                    addHistoryMarket(managerHistoryBuy.createStoryList(products, buyers));
                    break;
                case 6 :
                    System.out.println("6. История покупок в магазине");
                    managerHistoryBuy.printListBuys(historyBuys);
                    break;
                case 7 :
                    System.out.println("7. Пополнить счет");
                    managerBuyer.Refill(buyers);
                    break;
                case 8 :
                    System.out.println("8. Посмотреть баланс");
                    managerBuyer.PrintCash(buyers);
                    break;
                case 9 :
                    System.out.println("9. Изменить данные о товаре");
                    managerBookProduct.ProductChange(products);
                    break;
                case 10 :
                    System.out.println("10. Удаление продукта");
                    bookProduct.removeProduct();
                    break;
                case 11 :
                    System.out.println("11. Прибыль магазина");
                    marketManagers.MarketCashList(markets);
                    break;
            }


        } while (repeat);
        System.out.println("ББ");

    }
    private void addProduct(Product product){
        this.products = Arrays.copyOf(this.products, this.products.length + 1);
        this.products[this.products.length  - 1] = product;

    }

    private void addBuyer(Buyer buyer){
        this.buyers = Arrays.copyOf(this.buyers, this.buyers.length + 1);
        this.buyers[this.buyers.length  - 1] = buyer;
    }
    private void addCashMarket(Market market){
        this.markets = Arrays.copyOf(this.markets, this.markets.length + 1);
        this.markets[this.markets.length  - 1] = market;
    }

    private void addHistoryMarket(HistoryBuy historyBuy){
        this.historyBuys = Arrays.copyOf(this.historyBuys, this.historyBuys.length + 1);
        this.historyBuys[this.historyBuys.length  - 1] = historyBuy;
    }


}
