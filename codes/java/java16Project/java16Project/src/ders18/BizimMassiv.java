package ders18;

public class BizimMassiv<T> {
    private  Object[] elements;
    private int index=0;
    public  BizimMassiv(int count){
        elements=new Object[count];
    }
    public void elaveAt(T element){
        if(index==elements.length){
            Object[] newMassiv=new Object[elements.length+1];
            for (int i = 0; i <elements.length ; i++) {
                newMassiv[i]=elements[i];
            }
            elements=newMassiv;
        }
    elements[index++]=element;

    }

    @Override
    public String toString() {
      String result="[";

        for (int i = 0; i < index-1 ; i++) {
            result+=elements[i]+", ";
        }
        result+=elements[index-1]+"]";
      return result;
    }
}
