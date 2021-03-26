package questionafter1000;

public class Question1432 {

    public int maxDiff(int num) {
        if (num < 10) {
            return 8;
        }
        String s = String.valueOf(num);

        int i = 0;
        while (i < s.length()){
            if (s.charAt(i) != '9'){
                break;
            }
            i++;
        }

        if (i == s.length()){
            return Integer.parseInt(s.replaceAll("9", "1"));
        }

        int max = Integer.parseInt(s.replaceAll(String.valueOf(s.charAt(i)), "9"));

        char k = s.charAt(0);

        int min;
        if (k != '1'){
            min = Integer.parseInt(s.replaceAll(String.valueOf(k), "1"));
        }else {
            int j = 1;
            while (j < s.length()){
                if (s.charAt(j) != k && s.charAt(j) != '0'){
                    break;
                }
                j++;
            }

            if (j == s.length()){
                min = num;
            }else {
                min = Integer.parseInt(s.replaceAll(String.valueOf(s.charAt(j)), "0"));
            }

        }

        return max - min;
    }

    public static void main(String[] args) {
        Question1432 q = new Question1432();
        System.out.println(q.maxDiff(1101057));
    }
}
