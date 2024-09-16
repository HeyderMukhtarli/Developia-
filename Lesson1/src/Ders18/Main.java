package Ders18;

public class Main {
    public static void main(String[] args) {
        LRUCache<String> items=new LRUCache<>(3);
        items.addElement("a");
        items.addElement("b");
        items.addElement("c");
        items.addElement("d");
        items.addElement("f");
        System.out.println( items.getElement(2));
        System.out.println(items.printAll());
    }
}
