package Entity;


public class Market {

    private int cashMarket;


    public int getCashMarket() {
        return cashMarket;
    }


    public void setCashMarket(int cashMarket) {
        this.cashMarket = cashMarket;
    }







    @Override
    public String toString() {
        return "Market{" +
                "cashMarket=" + cashMarket +
                '}';
    }
}
