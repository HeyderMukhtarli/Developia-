package ders_21;

import java.util.ArrayList;

public class MainRunner {
    public static void main(String[] args) {
        var words=new ArrayList<String>();
        words.add("Alma");
        words.add("Heyva");
        words.add("Nar");
        words.add("Armud");
        words.add("Alca");

//        for (int i = 0; i < words.size(); i++) {
//            if(words.get(i).startsWith("A")){
//                System.out.println(words.get(i));
//            }
//
//        }

//        words .stream() .filter(s->s.startsWith("A")).
//                forEach(System.out::println);

        words .stream() .filter(w->w.startsWith("A"))
                        .
                map(w->w.toUpperCase()).
                forEach(System.out::println);

    }
}
