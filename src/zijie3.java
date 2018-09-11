import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:zhenyuan
 * @Date:Created in 上午10:50 2018/9/9
 */

public class zijie3 {


    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(restoreIpAddresses(s).size());
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<>();
        int[] path = new int[4];
        solve(ret, s, 0,  path, 0);
        return ret;
    }

    static void solve(List<String> acc, String s, int idx, int[] path,  int segment){
        if(segment == 4 && idx == s.length() ){
            acc.add(path[0] + "." + path[1] + "."+ path[2] + "." + path[3]);
            return ;
        }else if(segment == 4 || idx == s.length() ){
            return ;
        }

        for(int len = 1; len <= 3 && idx + len <= s.length() ; len ++){
            int val = Integer.parseInt(s.substring(idx, idx + len));
            if(val > 255 || len >= 2  && s.charAt(idx) == '0')
                break;

            path[segment] = val;
            solve(acc, s, idx + len, path, segment + 1);
            path[segment] = -1; // for debug.
        }
    }
}
