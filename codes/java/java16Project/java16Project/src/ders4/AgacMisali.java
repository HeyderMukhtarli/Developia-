package ders4;

public class AgacMisali {
    public static void main(String[] args) {
        double suVerilen = 1.0;
        double agacBoyumesi = 0.15;
        double agacBoyu = 0.3;
        int gunSayi = 0;
        double maxBoy=19;
        while (agacBoyu < maxBoy) {
            agacBoyu += suVerilen * agacBoyumesi;
            suVerilen *= 1.5;
            gunSayi++;
        }

        System.out.println("Agac "+maxBoy+" metr boya " + gunSayi + " gün sonra catar.");
    }
}
