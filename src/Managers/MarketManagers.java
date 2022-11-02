package Managers;


import Entity.Market;

public class MarketManagers {
    public Market MarketCashEveryTime(int SummaProduct){
        Market Market = new Market();
        Market.setCashMarket(SummaProduct);
        return Market;
    }

    public Market createMarketList() {
        int SummaProduct = ManagerHistoryBuy.TotalSumma;
        Market Market = MarketCashEveryTime(SummaProduct);
        return Market;
    }

    public void MarketCashList(Market[] Markets) {
        for (int i = 0; i < Markets.length; i++) {
            System.out.println(i + 1);
            System.out.print("Прибыль магазина c покупателя:"+Markets[i].getCashMarket());
        }
        int sum = 0;
        for (Market market : Markets) {
            sum = sum + market.getCashMarket();

        }
        System.out.print("Общая прибыль магазина: " + sum);

        System.out.println();
    }

}
