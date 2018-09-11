import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:zhenyuan
 * @Date:Created in 上午10:47 2018/9/9
 */

public class zijie1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int prev = map.get(s.charAt(i));
                start = Math.max(prev + 1, start);
            }
            max = Math.max(max, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
