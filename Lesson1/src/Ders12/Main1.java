package Ders12;

import java.util.HashSet;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(longestSubs("abcabcabc"));
    }

    public static int longestSubs(String s) {
        if (s.equals(" ")) {
            System.out.println("a");
            return 1;
        }
        if (s.equals("")) {
            System.out.println("B");
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        HashSet<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If currentChar is already in the set, remove characters from the start
            // until currentChar can be added
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(start));
                start++;
            }

            // Add currentChar to the set
            charSet.add(currentChar);

            // Update maxLength
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
