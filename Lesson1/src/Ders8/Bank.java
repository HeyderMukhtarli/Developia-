package Ders8;

public class Bank {
    private double money;

    public double drowMoney(Basket bs){
        double cost=0;
        for(Product pr:bs.getPr()){
            cost+=pr.getCost()*pr.getQuantity();

        }
        return this.money-cost;
    }

    public Bank(double money) {
        this.money=money;

    }
}
