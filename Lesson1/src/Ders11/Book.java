package Ders11;

public class Book implements Cloneable{
    public String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("Obyekt silinir");

    }

    public Object clone() throws  CloneNotSupportedException{
        return super.clone();
    }
}
