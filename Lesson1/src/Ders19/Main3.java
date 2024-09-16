package Ders19;

//package Ders19;
//
//public class Main3 {
//    public static void main(String[] args) {
//        System.out.println(longestPalindrome("bb"));
//    }
//
//    public static boolean checkPolyndrome(String s){
//        char[] c=s.toCharArray();
//        char[] chars=new char[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
//        boolean isOdd=false;
//        for(char character:c){
//            if(Character.getNumericValue(character)!=-1){
//                System.out.println(Character.getNumericValue(character));
//                chars[Character.getNumericValue(character)-Character.getNumericValue('a')]++;
//            }
//        }
//        for(int i:chars){
//
//            if(i%2!=0){
//                if(isOdd){
//                    return false;
//                }
//                isOdd=true;
//
//            }
//        }
//        return  true;
//
//    }
//    public static boolean checkPolyndrome2(String s){
//        char[] c=s.toCharArray();
//       for(int i=0;i<=Math.floor((double) s.length()/2);i++){
//           if(c[i]!=c[s.length()-1-i]){
//               return false;
//           }
//       }
//       return true;
//
//    }
//    public static String longestPalindrome(String s) {
//       String x;
//       StringBuilder longest=new StringBuilder("");
//       int move=0;
//       if(s.length()==1){
//           return s;
//       }
//       for(int i=0;i<s.length();i++){
//         if(i!=s.length()-1){
//             for(int j=i+1;j<=s.length();j++){
//                 if(checkPolyndrome2(s.substring(i,j))&&s.substring(i,j).length()>longest.length()){
//                     longest=new StringBuilder(s.substring(i,j));
//                 }
//             }
//         }
//
//       }
//       return longest.toString();
//    }
//}
public class Main3 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
