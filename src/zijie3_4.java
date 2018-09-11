import java.util.Scanner;

/**
 * @Author:zhenyuan
 * @Date:Created in 上午11:43 2018/9/9
 */

public class zijie3_4 {

    private static int mask1 = 0x80; // 1000 0000
    private static int mask2 = 0xc0; // 1100 0000
    private static int mask3 = 0xe0; // 1110 0000
    private static int mask4 = 0xf0; // 1111 0000
    private static int mask5 = 0xf8; // 1111 1000

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());

        String[] s = sc.nextLine().split(" ");
        int[] a = new int[input];
        for (int i=0;i<input;i++){
            a[i] = Integer.parseInt(s[i]);
        }

        System.out.println(validUtf8(a));
    }



    public static int validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int head = data[i];
            int len = 0;
            if ((head & mask1) == 0) { // 0xxx xxxx
                continue;
            } else if ((head & mask3) == mask2) { // 110xx xxxx
                len = 1;
            } else if ((head & mask4) == mask3) { // 1110 xxxx
                len = 2;
            } else if ((head & mask5) == mask4) { // 1111 0xxx
                len = 3;
            } else {
                return 0;
            }
            for (int j = 0; j < len; j++) {
                if (++i == data.length) { // need more byte
                    return 1;
                }
                if ((data[i] & mask2) != mask1) { // not fllowed by 10xx xxxx
                    return 0;
                }
            }
        }
        return 1;
    }
}
