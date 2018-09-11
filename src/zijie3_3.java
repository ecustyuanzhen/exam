import java.util.Scanner;

/**
 * @Author:zhenyuan
 * @Date:Created in 上午11:23 2018/9/9
 */

public class zijie3_3 {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        int row = input;
        int col = input;

        char[][] Matrix = new char[row][col];
        for (int i=0;i<row;i++){
            String ss = sc.nextLine().replaceAll(" ","");
            Matrix[i] = ss.toCharArray();
        }

        System.out.println(numIslands(Matrix));
    }


    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    count ++;
                    isIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void isIsland (char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            isIsland(grid, i+1, j);
            isIsland(grid, i-1, j);
            isIsland(grid, i, j+1);
            isIsland(grid, i, j-1);
        }
    }

}
