import java.util.*;

public class Pusk {
    public static void main(String[] args) {

 String[] massivimiz={
         "Havanisə",
         "Etibar",
         "Mələk",
         "Malik",
         "Heydər",
         "Nicat",
         "Sevil",
         "Zərda",
         "Xəyalə",
         "Lalə",
         "Anar",
         "Əmrah",
         "Aysu",
         "Ülkər",
         "Elnur",
         "İnqlab",
         "Sevinc"};

        List<String> names= Arrays.asList(massivimiz);
        Collections.shuffle(names
        );
        System.out.println(names.get(0));


    }
}
