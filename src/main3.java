/**
 *  判断一个数是不是二叉树的后序遍历
 * @Author:zhenyuan
 * @Date:Created in 上午10:43 2018/8/17
 */

public class main3 {

    static Boolean lB ;
    static Boolean rB ;
    public boolean VerifySquenceOfBST(int [] sequence) {

        int length = sequence.length;
        if (length==0)return false;
        return f(sequence,0,length-1);
    }

    public static Boolean f(int[] array,int l,int h){
        while ((h-l)>2){
            int index = h;
            int temp = array[index];
            if (array[index]<array[index-1]){
                while (index>l&&array[--index]>temp);
                int i = index;
                while (i>l&&array[--i]>temp){
                    return false;
                }
                lB =  f(array,l,index);
                rB =  f(array,index+1,h);
                return lB&rB;
            }else{
                while (index>l&&array[--index]>temp){
                    return false;
                }
                lB = f(array,l,h-1);
                rB = true;
                return lB&rB;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] a = {7,4,6,5};
        System.out.println(new main3().VerifySquenceOfBST(a));
    }
}
