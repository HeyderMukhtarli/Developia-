public class PermutationChecker {

    public static boolean permutation(String s, String t) {
        // If the lengths of the strings are different, they cannot be permutations
        if (s.length() != t.length()) {
            return false;
        }

        // Create an array to count the occurrences of each character
        int[] letters = new int[128]; // Assuming ASCII characters

        // Convert the first string to a char array and count each character
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }

        // Check the characters of the second string
        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        // If we have not returned false, the strings are permutations of each other
        return true;
    }

    public static void main(String[] args) {
        // Test the permutation method
        String s1 = "abcde";
        String s2 = "edbca";
        String s3 = "abcd";

        System.out.println(permutation(s1, s2)); // Should print true
        System.out.println(permutation(s1, s3)); // Should print false
    }
}
