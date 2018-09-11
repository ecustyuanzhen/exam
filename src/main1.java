import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:zhenyuan
 * @Date:Created in 上午11:37 2018/8/12
 */

public class main1 {

    static Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String s = sc.nextLine();
        String[] temp = s.split(" ");
        int[] ends = new int[N];
        int[] starts = new int[N];
        for (int i=0;i<N;i++){
            int end = Integer.parseInt(temp[2*i+1]);
            int start = Integer.parseInt(temp[2*i]);
            if (end ==0){
                end = M;
            }
            starts[i] = start;
            map.put(end,i);
            ends[i] = end;
        }
        Arrays.sort(ends);
        int count =0;
        for (int i=1;i<N;i++){
            int index = map.get(ends[i]);

        }
    }
}
