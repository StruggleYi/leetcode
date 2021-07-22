package LeetCode;

import java.util.*;

/**
 * @author Struggle
 * @date Created in 21:34 2021/7/5
 * description  原子的数量
 * node:
 * path: https://leetcode-cn.com/problems/number-of-atoms/
 * level: hard
 **/
public class Question726 {

    /**
     * 思路接近, 采用的是递归的思路, 分别计算了左括号与右括号的个数, 省去了每次计算子串的个数
     *
     * @param formula
     * @return
     */
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = func(formula, 0, formula.length() - 1);
        ArrayList<String> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            int v = map.get(s);
            sb.append(s);
            if (v > 1) {
                sb.append(v);
            }
        }
        return sb.toString();
    }

    private Map<String, Integer> func(String s, int lo, int hi) {
        Map<String, Integer> map = new HashMap<>();
        String v = "";
        for (int i = lo; i <= hi; ) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int tmp = s.charAt(i) - '0';
                while (++i <= hi && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    tmp = tmp * 10 + s.charAt(i) - '0';
                }
                map.put(v, map.getOrDefault(v, 0) + tmp);
            } else if (s.charAt(i) == '(') {
                int count = 1;
                i++;
                int l = i;
                while (i <= hi && count != 0) {
                    if (s.charAt(i) == '(') {
                        count++;
                    } else if (s.charAt(i) == ')') {
                        count--;
                    }
                    i++;
                }
                Map<String, Integer> tmpMap = func(s, l, i - 2);
                int times;
                if (i > hi) {
                    times = 1;
                } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    times = s.charAt(i) - '0';
                    while (++i <= hi && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        times = times * 10 + s.charAt(i) - '0';
                    }
                } else {
                    times = 1;
                }
                for (Map.Entry<String, Integer> entry : tmpMap.entrySet()) {
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * times);
                }
            } else {
                int l = i;
                while (++i <= hi && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                }
                v = s.substring(l, i);
                if (i > hi || s.charAt(i) < '0' || s.charAt(i) > '9') {
                    map.put(v, map.getOrDefault(v, 0) + 1);
                }
            }
        }
        return map;
    }

    /**
     * 最初AC的思路：将括号去除, 使其变成一个不含括号的字符串
     * 本题可以分为以下几种情况：
     * 1、如果没有括号, 直接计算字符串中原子数量，比较简单;
     * 2、如果有括号, 则需要进行递归计算：
     *      a、没有遇到括号时, 累计当前遍历的字符;
     *      b、遇到左括号, 把当前累计的字符压栈, 清空累计的字符;
     *      c、遇到右括号, 计算右括号后的数字, 将其乘到括号里面的字符中,
     *      并且需要弹出栈顶的字符串, 将计算完成的结果放到右边（是因为左边可能存在平级关系的字符串, 将其合并到一起）;
     * @param formula
     * @return
     */
    public String countOfAtoms2(String formula) {

        //统计该原子表达式中各元素的数量
        Map<String, Integer> map = count(formula);
        StringBuilder res = new StringBuilder();

        // 将元素进行排序
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        // 按照元素的顺序以及个数重新排列, 返回结果
        for (String s : list) {
            res.append(s).append(map.get(s) == 1 ? "" : map.get(s));
        }

        return res.toString();
    }

    /**
     * 计算字符串中各个元素的个数
     * @param s
     * @return
     */
    private Map<String, Integer> count(String s) {
        int len = s.length();
        int leftIndex = s.indexOf("(");


        // 里面含有括号的情况
        StringBuilder sb = new StringBuilder();
        if (leftIndex >= 0) {
            Stack<String> stack = new Stack<>();
            int k = leftIndex + 1;

            // 括号左边的字符串压栈
            stack.push(s.substring(0, leftIndex));

            // 遍历剩余的字符串
            while (k < len) {
                char c = s.charAt(k);

                // 遇到左括号压栈, 如果左括号前面目前没有值, 压入空值
                if (c == '(') {
                    if (sb.length() > 0) {
                        stack.push(sb.toString());
                    } else {
                        stack.push("");
                    }
                    sb = new StringBuilder();
                    k++;
                } else if (c == ')') {

                    // 遇到右括号, 判断括号右边的数字的值
                    int t = k + 1;
                    while (++k < len) {
                        char cc = s.charAt(k);
                        if (cc < '0' || cc > '9') {
                            break;
                        }
                    }

                    // 如果值不为空, 判断当前子串下各个元素的个数, 然后相乘
                    String ss = sb.toString();
                    if (t < k) {
                        int m = Integer.valueOf(s.substring(t, k));
                        Map<String, Integer> help = help(ss);
                        StringBuilder temp = new StringBuilder();
                        for (Map.Entry<String, Integer> entry : help.entrySet()) {
                            temp.append(entry.getKey()).append(entry.getValue() * m);
                        }

                        ss = temp.toString();
                    }

                    // 弹出栈顶的元素与当前的子串合并
                    sb = new StringBuilder(stack.pop() + ss);
                } else {
                    sb.append(c);
                    k++;
                }
            }
        } else {
            sb.append(s);
        }

        return help(sb.toString());
    }

    /**
     * 计算不含有括号的字符串中各个元素的个数
     *
     * @param s
     * @return
     */
    private Map<String, Integer> help(String s) {
        int len = s.length();
        int k = 0;

        Map<String, Integer> count = new HashMap<>();
        while (k < len) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(k));
            while (++k < len) {
                char c = s.charAt(k);
                if (c < 'a' || c > 'z') {
                    break;
                }
                sb.append(c);
            }

            int i = k;
            while (k < len) {
                char c = s.charAt(k);
                if (c < '0' || c > '9') {
                    break;
                }
                k++;
            }

            int m = 1;
            if (k > i) {
                m = Integer.valueOf(s.substring(i, k));
            }

            count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + m);
        }

        return count;
    }

    public static void main(String[] args) {
        Question726 q = new Question726();
        System.out.println(q.countOfAtoms("((N7Li31C7B10Be37B23H2H11Li40Be15)26(OBLi48B46N4)25(O48C22He)2N10O34N15B33Li39H34H26B15B23C31(C36N38O33Li38H15H46He21Be38B50)8)3"));
    }
}
