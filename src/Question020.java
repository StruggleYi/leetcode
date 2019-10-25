/**
 * @author Struggle
 * @date Created in 11:33 2019/10/21
 *
 * description : 符号匹配
 **/

public class Question020 {
    private static boolean isValid(String s){
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                sb.append(s.charAt(i));
            }else if(s.charAt(i) == ')' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '('){
                sb.deleteCharAt(sb.length() - 1);
            }else if(s.charAt(i) == ']' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '['){
                sb.deleteCharAt(sb.length() - 1);
            }else if(s.charAt(i) == '}' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '{'){
                sb.deleteCharAt(sb.length() - 1);
            }else {
                return false;
            }
            i++;
        }
        return sb.length() == 0;
    }

    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(isValid(s));
    }
}
