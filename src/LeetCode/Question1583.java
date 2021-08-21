package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:34 2021/8/14
 * description 统计不开心的朋友
 * node:
 * path: https://leetcode-cn.com/problems/count-unhappy-friends/
 * level: medium
 **/
public class Question1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] relations = new int[n];
        int ans = 0;
        for(int i = 0; i < pairs.length; i++){
            relations[pairs[i][0]] = pairs[i][1];
            relations[pairs[i][1]] = pairs[i][0];
        }
        for(int i = 0; i < preferences.length; i++){
            if(checkRelation(preferences, relations, i, relations[i])){
                ans++;
            }
        }
        return ans;
    }
    public boolean checkRelation(int[][] preferences, int[] relations, int x, int y){
        for(int j = 0; j < preferences.length; j++){
            if(preferences[x][j] != y){
                int u = preferences[x][j];
                int v = relations[u];
                for(int r : preferences[u]){
                    if(r == x){
                        return true;
                    }else if(r == v){
                        break;
                    }
                }
            }else{
                break;
            }
        }
        return false;
    }
}
