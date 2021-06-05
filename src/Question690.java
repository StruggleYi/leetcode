import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 23:53 2021/6/5
 * description 员工的重要性
 * node:
 * path: https://leetcode-cn.com/problems/employee-importance/
 * level: easy
 **/
public class Question690 {

    public int getImportance(List<Employee> employees, int id) {

        // 使用map 记录员工, 便于更快查找到该用户相关信息
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        int sum = map.get(id).importance;
        Stack<Integer> stack = new Stack<>();

        List<Integer> subordinatesList = map.get(id).subordinates;
        stack.addAll(subordinatesList);

        while (!stack.isEmpty()) {

            Employee employee = map.get(stack.pop());
            sum += employee.importance;

            stack.addAll(map.get(employee.id).subordinates);
        }

        return sum;
    }

}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
