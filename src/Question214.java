public class Question214 {

    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int k = (len - 1) / 2;
        while (k >= 0) {
            if (s.charAt(k) == s.charAt(k + 1)) {
                String s1 = new StringBuffer(s.substring(0, k + 1)).reverse().toString();
                String s2 = s.substring(k + 1, 2 * k + 2);
                if (s1.equals(s2)) {
                    return new StringBuffer(s.substring(k + 1)).reverse().toString() + s2;
                }
            }
            if (k > 0) {
                String s1 = new StringBuffer(s.substring(0, k)).reverse().toString();
                String s2 = s.substring(k + 1, 2 * k + 1);
                if (s1.equals(s2)) {
                    return new StringBuffer(s.substring(k + 1)).reverse().toString() + s.substring(k);
                }
            }
            k--;
        }
        return new StringBuffer(s.substring(1)).reverse().toString() + s;
    }

    public static void main(String[] args) {
        Question214 q = new Question214();
        System.out.println(q.shortestPalindrome("aacecaaa"));
    }
}
