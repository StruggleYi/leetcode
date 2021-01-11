import java.util.HashSet;
import java.util.Set;

/**
 * @author Struggle
 * @date Created in 20:31 2021/1/11
 * description Unique Email Addresses 给定一组邮件地址，判断有效邮件地址的个数
 * node: "." 可以忽略, "+" 后面的内容全部忽略
 * path: https://leetcode.com/problems/unique-email-addresses/
 * level: easy
 **/
public class Question929 {

    /**
     * 比较简单的解法，将"." 去除，"+" 的内容截取掉即可
     * 有更时间更短的方法，可以采用遍历的方式去取出local与domain的值，避免使用substring方法
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String s : emails) {
            int index = s.indexOf("@");
            String local = s.substring(0, index).replace(".", "");
            String domain = s.substring(index);

            int k = local.indexOf("+");
            if (k > 0){
                local = local.substring(0, k);
            }

            set.add(local + domain);
        }

        return set.size();
    }

    public static void main(String[] args) {
        Question929 q = new Question929();

        String[] sList = new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        System.out.println(q.numUniqueEmails(sList));
    }
}
