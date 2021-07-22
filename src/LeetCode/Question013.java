package LeetCode;

/**
 * @author Struggle
 * @date Created in 22:52 2021/5/15
 * description 罗马数字转整数
 * node:
 * path: https://leetcode-cn.com/problems/roman-to-integer/
 * level: easy
 **/
public class Question013 {

    /**
     * LeetCode 参考解法
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sum = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case 'M':
                    sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'C':
                    if (i != (charArray.length - 1) && charArray[i + 1] == 'D') {
                        sum += 400;
                        i++;
                    } else if (i != (charArray.length - 1) && charArray[i + 1] == 'M') {
                        sum += 900;
                        i++;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'X':
                    if (i != (charArray.length - 1) && charArray[i + 1] == 'L') {
                        sum += 40;
                        i++;
                    } else if (i != (charArray.length - 1) && charArray[i + 1] == 'C') {
                        sum += 90;
                        i++;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    if (i != (charArray.length - 1) && charArray[i + 1] == 'V') {
                        sum += 4;
                        i++;
                    } else if (i != (charArray.length - 1) && charArray[i + 1] == 'X') {
                        sum += 9;
                        i++;
                    } else {
                        sum += 1;
                    }
                    break;
                default:
                    break;
            }
        }
        return sum;

    }

    /**
     * 本人比较暴力的解法
     *
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        int res = 0;
        int i = 0;
        int len = s.length();

        // 判断千位, 千位最多为3千, 如果是M开头, 一定代表千位, 计算M的个数
        if (s.charAt(i) == 'M') {
            int k = 1;
            while (++i < len && s.charAt(i) == 'M') {
                k++;
            }
            res = k * 1000;
        }

        if (i == len) {
            return res;
        }

        // 判断百位, 百位有C开头和D开头, C开头有后面接D结束和M结束的情况
        if (s.charAt(i) == 'C') {
            int k = 1;
            while (++i < len && s.charAt(i) == 'C') {
                k++;
            }

            if (i == len) {
                return res + 100 * k;
            }

            // 以D结束表示比500少几百
            if (s.charAt(i) == 'D') {
                res += (5 - k) * 100;
                i++;
            } else if (s.charAt(i) == 'M') {
                // 以M结束表示900
                res += 900;
                i++;
            } else {
                // 否则就是几百
                res += k * 100;
            }
        }

        if (i == len) {
            return res;
        }

        // 以D开头, 统计C的个数, 相当于比500多几百
        if (s.charAt(i) == 'D') {
            int k = 0;
            while (++i < len && s.charAt(i) == 'C') {
                k++;
            }

            res += (5 + k) * 100;
        }

        if (i == len) {
            return res;
        }

        // 判断十位, 方法与百位相同
        if (s.charAt(i) == 'X') {
            int k = 1;
            while (++i < len && s.charAt(i) == 'X') {
                k++;
            }

            if (i == len) {
                return res + 10 * k;
            }

            if (s.charAt(i) == 'L') {
                res += (5 - k) * 10;
                i++;
            } else if (s.charAt(i) == 'C') {
                res += 90;
                i++;
            } else {
                res += k * 10;
            }
        }

        if (i == len) {
            return res;
        }

        if (s.charAt(i) == 'L') {
            int k = 0;
            while (++i < len && s.charAt(i) == 'X') {
                k++;
            }

            res += (5 + k) * 10;
        }

        if (i == len) {
            return res;
        }

        // 判断个位, 方法类推
        if (s.charAt(i) == 'I') {
            int k = 1;
            while (++i < len && s.charAt(i) == 'I') {
                k++;
            }

            if (i == len) {
                return res + k;
            }

            if (s.charAt(i) == 'V') {
                res += (5 - k);
                i++;
            } else if (s.charAt(i) == 'X') {
                res += 9;
                i++;
            } else {
                res += k;
            }
        }

        if (i == len) {
            return res;
        }

        if (s.charAt(i) == 'V') {
            int k = 0;
            while (++i < len && s.charAt(i) == 'I') {
                k++;
            }

            res += (5 + k);
        }

        return res;
    }

    public static void main(String[] args) {
        Question013 q = new Question013();
        System.out.println(q.romanToInt("DCXXI"));
    }
}
