package leetcode.editor;

import java.util.Arrays;

/**
 * <p>
 * N皇后问题
 * </p>
 *
 * @author edoup
 * @date 2020/11/28 0:13
 */
public class Code52 {


    public static void main(String[] args) {

        Code52 code51 = new Code52();
        System.out.println(code51.solveNQueens(8));
        //   System.out.println(code51.solveNQueens(8).toString());
    }
    static  Integer a = 0;

    public Integer solveNQueens(int n) {
        char[][] row = new char[n][n];

        for (int i = 0; i < row.length; i++) {
            Arrays.fill(row[i], ' ');
        }
        so(0,row);
       return a;
    }

    public void so(int row, char[][] vals){
        if (row == vals.length){
            a  = a + 1;
            return;
        }
        for (int col = 0; col < vals.length; col++) {
            if (!isSuccess(vals, row,col)) {
                continue;
            }
            vals[row][col] ='Q';
            so(row +1,vals);
            vals[row][col] = ' ';
        }
    }

    public Boolean isSuccess(char[][] vals, int row, int col){
        int n = vals.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (vals[i][col] == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (vals[i][j] == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (vals[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
