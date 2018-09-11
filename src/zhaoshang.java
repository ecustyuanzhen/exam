import com.apple.eawt.AppEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:zhenyuan
 * @Date:Created in 下午8:13 2018/8/30
 */

public class zhaoshang {



    public static int method_2(int [] arr) {
        int [] left = new int[arr.length];
        int [] right = new int[arr.length];

        int leftMax=arr[0];
        int rightMax=arr[arr.length-1];
        for(int i=0;i<arr.length;i++)
        {
            leftMax=Math.max(leftMax, arr[i]);
            left[i]=leftMax;
        }
        for(int i=arr.length-1;i>=0;i--)
        {
            rightMax=Math.max(rightMax, arr[i]);
            right[i]=rightMax;
        }

        for(int i=0;i<left.length;i++)
            System.out.print(left[i]+" ");

        System.out.println();
        for(int i=0;i<right.length;i++)
            System.out.print(right[i]+" ");
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++)
        {
            max=Math.max(Math.abs(left[i]-right[i+1]),max);
        }
        return max;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();

        int length = s.length();
        int sum =0,sum2 = 0;
        List<Integer> list = new ArrayList();
        int index = s.indexOf("C");
        int i = 0;
        while (index!=-1){
            list.add(index);
            index = s.indexOf("C",index+1);
        }

        if (list.size()==0){
            System.out.println(0);
        }else {
            for (int j=0;j<list.size();j++){
                sum += list.get(j)-j;
            }
            for (int j=list.size()-1;j>=0;j--){
                sum2 += length-- -list.get(j);
            }

            System.out.println(sum>sum2?sum2:sum);
        }
    }

}
