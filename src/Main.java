import java.util.Scanner;

public class Main {
    static int maxPeople = 0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int row = s.length;
        int[][] Matrix=new int[row][row];
        for (int j = 0; j< row; j++){
            Matrix[0][j] = Integer.parseInt(s[j]);
        }
        for (int i=1;i<row;i++){
            String[] ss = sc.nextLine().split(" ");
            for (int j = 0; j< row; j++){
                Matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }
        System.out.println(getCount(Matrix));
    }

    public static String getCount(int[][] a){
        if (a == null||a[0]==null){
            return 0+","+0;
        }
        int m = a.length;
        int n = a[0].length;
        int res = 0;
        int max = 0;
        for (int i =0;i<m;i++){
            for (int j=0;j<n;j++){
                if (a[i][j]==1){
                    res++;
                    maxPeople = 0;
                    maxPeople = influence(a,i,j,m,n);
                    max = maxPeople >max? maxPeople :max;
                }
            }
        }
        return res+","+max;
    }

    public static int influence(int[][] a, int i, int j, int N, int M){
        if (i<0||i>=N||j<0||j>=M||a[i][j]!=1){
            return maxPeople;
        }
        a[i][j] = 2;
        maxPeople++;
        influence(a,i+1,j,N,M);
        influence(a,i-1,j,N,M);
        influence(a,i,j+1,N,M);
        influence(a,i,j-1,N,M);
        influence(a,i-1,j-1,N,M);
        influence(a,i+1,j+1,N,M);
        influence(a,i+1,j-1,N,M);
        influence(a,i-1,j+1,N,M);
        return maxPeople;
    }
}