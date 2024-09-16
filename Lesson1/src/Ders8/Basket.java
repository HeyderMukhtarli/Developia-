package Ders8;

public class Basket {
    private Product[] pr;

    public Basket(Product[] pr) {
        this.pr = pr;
    }

    public Product[] getPr() {
        return pr;
    }

    public void setPr(Product[] pr) {
        this.pr = pr;
    }
}
