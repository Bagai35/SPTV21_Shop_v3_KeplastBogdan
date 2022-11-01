package Managers;

import Entity.Buyer;

import java.util.Scanner;

public class ManagerBuyer {

    Scanner scanner;


    public ManagerBuyer() {
        scanner = new Scanner(System.in);
    }
    public void printListBuyer(Buyer[] buyers) {
        for (int i = 0; i < buyers.length; i++) {
            System.out.println(i + 1);
            System.out.println(buyers[i].getFirstname());
            System.out.println(buyers[i].getLastname());
            System.out.println("номер телефона"+buyers[i].getPhone());
        }
    }
    public Buyer newBuyer() {
        Buyer buyer = new Buyer();
        System.out.print("Введите имя: ");
        buyer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        buyer.setLastname(scanner.nextLine());
        System.out.print("Введите номер телефона: ");
        buyer.setPhone(scanner.nextLine());
        return buyer;
    }
    public void Refill(Buyer[] buyers) {
        System.out.println("Выберите покупателя для записи балланса");
        System.out.println("список покупателей");
        for (int i = 0; i < buyers.length; i++) {
            System.out.println(i + 1);
            System.out.println(buyers[i].getFirstname());
            System.out.println(buyers[i].getLastname());
            System.out.println("номер телефона"+buyers[i].getPhone());
        }
        System.out.print("Введите номер покупателя: ");
        int buyer = scanner.nextInt(); scanner.nextLine();
        System.out.print("Сколько денег желаете добавить на счет? : ");
        int addMoney = scanner.nextInt(); scanner.nextLine();
        int TotalMoney = buyers[buyer - 1].getCash() + addMoney;
        buyers[buyer - 1].setCash(TotalMoney);
        System.out.println("Счет пополнен!");
        System.out.println("На счету : " + buyers[buyer - 1].getCash());

    }
    public void PrintCash(Buyer[] buyers){
        System.out.println("список покупателей");
        for (int i = 0; i < buyers.length; i++) {
            System.out.println(i + 1);
            System.out.println(buyers[i].getFirstname());
            System.out.println(buyers[i].getLastname());
            System.out.println("номер телефона"+buyers[i].getPhone());
        }
        System.out.print("Введите ид покупателя и посмотрите кэш: ");
        int balans = scanner.nextInt(); scanner.nextLine();
        int printCash = buyers[balans-1].getCash();
        System.out.println("Баланс покупателя: " + printCash);
    }
}