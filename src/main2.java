/**
 * 在一个有序数组中找出指定的k的出现次数
 * @Author:zhenyuan
 * @Date:Created in 下午11:27 2018/8/16
 */

public class main2 {
    public int GetNumberOfK(int[] array , int k) {
        int count = 0;
        int length = array.length;
        int index = findK(array,k,0,length-1);
        int temp = index;
        while (index>=0){
            while (index>=0){
                if (array[index--] == k) {
                    count++;
                }
            }

            while (temp<length){
                if(array[temp++] == k){
                    count++;
                }
            }
            return count-1;
        }
        return 0;
    }

    static int findK(int[] array , int k,int l,int h){
        int mid = l+(h-l)/2;
        while (l<=h){
            if (array[mid]<k){
                return findK(array,k,mid+1,h);
            }else if (array[mid]>k){
                return findK(array,k,l,mid-1);
            }else return mid;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] a = {1,2,3,3,3,3,3,4,5};
        System.out.println(new main2().GetNumberOfK(a,3));
    }
}
