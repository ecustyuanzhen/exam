import java.util.*;

/**
 * @Author:zhenyuan
 * @Date:Created in 下午7:33 2018/9/4
 */

public class xiecheng {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int[] order = new int[num];
        long[] start = new long[num];
        long[] stop = new long[num];
        long aim = Long.parseLong(sc.nextLine());
        String temp;
        String[] temps;
        HashMap<Long,Long> hashMap1 = new HashMap<>();
        HashMap<Long,Integer> hashMap2 = new HashMap<>();
        for (int i=0;i<num;i++){

            temp = sc.nextLine();
            temps = temp.split(" ");
            order[i] = Integer.parseInt(temps[0]);
            start[i] = Long.parseLong(temps[1]);
            hashMap1.put(start[i],stop[i]);
            hashMap2.put(start[i],order[i]);
            stop[i] = Long.parseLong(temps[2]);
        }
        Arrays.sort(start);
        int i = commonBinarySearch(start,aim);

        for (int j =i;j<num;j++){
            if (hashMap1.get(start[i])>=aim){
                int p = hashMap2.get(start[i]);
                System.out.println(p);
            }
        }



    }

    public static int commonBinarySearch(long[] arr,long key){
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;			//定义middle

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(arr[middle] > key){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(arr[middle] < key){
                //比关键字小则关键字在右区域
                low = middle + 1;
            }else{
                return middle;
            }
        }

        return arr[middle]<key?middle:middle-1;
    }
}
