package managers;


import entity.Market;

public class MarketManagers {
    public Market marketCashEveryTime(int summaProduct){
        Market market = new Market();
        market.setCashMarket(summaProduct);
        return market;
    }

    public Market createMarketList() {
        int summaProduct = ManagerHistoryBuy.totalSumma;
        return marketCashEveryTime(summaProduct);
    }

    public void marketCashList(Market[] markets) {
        int sum = 0;
        for (Market market : markets) {
            sum = sum + market.getCashMarket();
        }
        System.out.print("Общая прибыль магазина: " + sum);

        System.out.println();
    }

}
