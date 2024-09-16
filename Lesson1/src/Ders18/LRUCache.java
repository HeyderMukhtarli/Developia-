package Ders18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LRUCache<T> {
    List<T> items=new ArrayList<>();
    int max;

    public LRUCache(int maxSize) {
        max=maxSize;
    }
    public  List<T> printAll(){
        return  items;
    }
    public void addElement(T item){
        if(items.size()==max){
            items.remove(0);
        }
        items.add(item);
    }
    public T getElement(int index){
       return items.get(index);
    }
}
