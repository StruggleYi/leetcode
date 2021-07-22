package LeetCode;

import java.util.*;

/**
 * @author Struggle
 * @date Created in 22:59 2021/7/6
 * description 点菜展示表  给你一个数组 orders，表示客户在餐厅中完成的订单
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。
 * 接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量
 * node:
 * path: https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant/
 * level: medium
 **/
public class Question1418 {

    /**
     * 借鉴运行时间更短的解法, 思路类似, 但是写法更简洁
     *
     * @param orders
     * @return
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        HashSet<String> set = new HashSet<>();
        // 记录菜品名称并排序
        for (List<String> o : orders) {
            set.add(o.get(2));
        }
        List<String> food = new ArrayList<>(set);
        food.sort(null);
        food.add(0, "Table");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i < food.size(); i++) {
            map.put(food.get(i), i);
        }

        //遍历点餐记录, 将记录到每个桌子的每个菜品的数量下, 本题桌号最多到500, 所以这里设置为501
        ArrayList<String>[] list = new ArrayList[501];
        for (List<String> o : orders) {
            // 桌号
            int o1 = Integer.valueOf(o.get(1));
            // 初始化该桌号, 每种菜品的数量置为0
            if (list[o1] == null) {
                list[o1] = new ArrayList<>();
                list[o1].add(o.get(1));
                for (int i = 1; i < food.size(); i++) {
                    list[o1].add("0");
                }
            }

            // 找出该菜品的位置, 将其数量+1
            int idx = map.get(o.get(2));
            int num = Integer.valueOf(list[o1].get(idx)) + 1;
            list[o1].set(map.get(o.get(2)), String.valueOf(num));
        }

        // 遍历输出结果
        List<List<String>> res = new ArrayList<>();
        res.add(food);
        for (int i = 1; i < 501; i++) {
            if (list[i] != null) {
                res.add(list[i]);
            }
        }
        return res;
    }

    /**
     * 传统暴力解法:
     * 存储点菜的菜名、桌号、以及每桌每个菜品点的份数, 最后按规则输出
     *
     * @param orders
     * @return
     */
    public List<List<String>> displayTable2(List<List<String>> orders) {
        List<String> foodName = new ArrayList<>();
        List<Integer> tableName = new ArrayList<>();

        Map<Integer, Map<String, Integer>> data = new HashMap<>();

        for (List<String> order : orders) {
            Integer table = Integer.valueOf(order.get(1));
            String food = order.get(2);
            if (!foodName.contains(food)) {
                foodName.add(food);
            }
            if (!tableName.contains(table)) {
                tableName.add(table);
            }

            Map<String, Integer> map = data.getOrDefault(table, new HashMap<>());
            map.put(food, map.getOrDefault(food, 0) + 1);
            data.put(table, map);
        }

        Collections.sort(foodName);
        Collections.sort(tableName);

        List<List<String>> res = new ArrayList<>();

        // 写入菜单
        List<String> menu = new ArrayList<>();
        menu.add("Table");
        menu.addAll(foodName);
        res.add(menu);

        //写入每个桌子菜的数量
        for (Integer s : tableName) {
            List<String> table = new ArrayList<>();
            table.add(String.valueOf(s));

            Map<String, Integer> map = data.get(s);
            for (int i = 1; i < menu.size(); i++) {
                table.add(String.valueOf(map.getOrDefault(menu.get(i), 0)));
            }

            res.add(table);
        }

        return res;
    }

    public static void main(String[] args) {
        Question1418 q = new Question1418();

        List<List<String>> orders = new ArrayList<>();
        List<String> order1 = Arrays.asList("David", "3", "Ceviche");
        List<String> order2 = Arrays.asList("Corina", "10", "Beef Burrito");
        List<String> order3 = Arrays.asList("David", "3", "Fried Chicken");
        List<String> order4 = Arrays.asList("Carla", "5", "Water");
        List<String> order5 = Arrays.asList("Carla", "5", "Ceviche");
        List<String> order6 = Arrays.asList("Rous", "3", "Ceviche");
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        List<List<String>> lists = q.displayTable(orders);
        for (List<String> list : lists) {
            System.out.println(list.toString());
        }
    }
}
