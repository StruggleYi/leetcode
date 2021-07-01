import java.util.*;

/**
 * @author Struggle
 * @date Created in 22:31 2021/6/20
 * description 皇位继承顺序
 * node:
 * path: https://leetcode-cn.com/problems/throne-inheritance/
 * level: medium
 **/
public class Question1600 {

    Map<String, People> map = new HashMap<>();
    String kingNames = "";

    /**
     * 提交答案的时候需要去掉void
     *
     * @param kingName
     */
    public void ThroneInheritance(String kingName) {
        People king = new People(kingName, null);
        map.put(kingName, king);
        kingNames = kingName;
    }

    public void birth(String parentName, String childName) {
        People child = new People(childName, parentName);
        People parent = map.get(parentName);
        List<String> childNames = parent.getChildName();
        childNames.add(childName);
        map.put(childName, child);
        parent.setChildName(childNames);
        map.put(parentName, parent);
    }

    public void death(String name) {
        People people = map.get(name);
        people.setDead(true);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        Stack<People> stack = new Stack<>();
        stack.push(map.get(kingNames));

        while (!stack.isEmpty()) {
            People people = stack.pop();

            if (!people.isDead()) {
                res.add(people.getName());
            }

            List<String> childNames = people.getChildName();
            for (int i = childNames.size() - 1; i >= 0; i--) {
                stack.push(map.get(childNames.get(i)));
            }
        }

        return res;
    }

}

class People {
    private String name;
    private String parentName;
    private boolean dead;
    private List<String> childName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<String> getChildName() {
        return childName;
    }

    public void setChildName(List<String> childName) {
        this.childName = childName;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public People(String name, String parentName) {
        this.name = name;
        this.parentName = parentName;
        this.dead = false;
        this.childName = new ArrayList<>();
    }
}
