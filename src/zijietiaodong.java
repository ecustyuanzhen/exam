import java.util.Scanner;

/**
 * @Author:zhenyuan
 * @Date:Created in 上午9:36 2018/9/9
 */

public class zijietiaodong {


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        int row = input;
        int col = input;

        int[][] Matrix=new int[row][col];
        for (int i=0;i<row;i++){
            String[] ss = sc.nextLine().split(" ");
            for (int j = 0; j< col; j++){
                Matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }

        if (row == 0){
            System.out.println(0);
        }else {
            System.out.println(getCount(Matrix));
        }

    }

    public static int getCount(int[][] a){
        if (a == null||a[0]==null){
            return 0;
        }
        int m = a.length;
        int res = 0;
        for (int i =0;i<m;i++){
            for (int j=0;j<m;j++){
                if (a[i][j]==1){
                    res++;
                    influence(a,i,j,m,m);
                }
            }
        }
        return res;
    }

    public static void influence(int[][] a, int i, int j, int N, int M){
        if (i<0||i>=N||j<0||j>=M||a[i][j]!=1){
            return ;
        }
        a[i][j] = 2;
        influence(a,i+1,j,N,M);
        influence(a,i-1,j,N,M);
        influence(a,i,j+1,N,M);
        influence(a,i,j-1,N,M);

    }
}
