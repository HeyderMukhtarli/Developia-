package ders14;

public class MenimExc extends  ArrayIndexOutOfBoundsException{
    private Alma alma;

    public Alma getAlma() {
        return alma;
    }

    public MenimExc(String message, Alma alma){
        super(message);
        this.alma=alma;
    }
}
