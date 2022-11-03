package managers;


import entity.Market;

public class MarketManagers {
    public Market MarketCashEveryTime(int SummaProduct){
        Market market = new Market();
        market.setCashMarket(SummaProduct);
        return market;
    }

    public Market createMarketList() {
        int SummaProduct = ManagerHistoryBuy.TotalSumma;
        return MarketCashEveryTime(SummaProduct);
    }

    public void MarketCashList(Market[] markets) {
        for (int i = 0; i < markets.length; i++) {
            System.out.println(i + 1);
            System.out.print("Прибыль магазина c покупателя:"+markets[i].getCashMarket());
        }
        int sum = 0;
        for (Market market : markets) {
            sum = sum + market.getCashMarket();
        }
        System.out.print("Общая прибыль магазина: " + sum);

        System.out.println();
    }

}
