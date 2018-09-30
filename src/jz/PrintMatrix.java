package jz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11239 on 2018/8/6.
 * 给定一个矩阵
 * 从外向内顺时针的顺序依次打印每一个数字
 * <p>
 * 问题分解，第一步找出有多少圈
 * 第二步，打印每圈的数字
 *
 * 注意：画图，确定每次转折点的坐标
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null)
            return null;
        ArrayList<Integer> results = new ArrayList<>();
        //1.确定需要打多少圈
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 0 && cols == 0)
            return null;
        int rowStart = 0;
        int colStart = 0;
        //2.打印每一圈的数字
        while (rows > rowStart * 2 && cols > colStart * 2) {
            printCircleNum(matrix, results, rowStart, colStart, rows, cols);
            rowStart++;
            colStart++;
        }
        return results;
    }

    private void printCircleNum(int[][] matrix, ArrayList<Integer> res, int rowStart, int colStart, int rows, int cols) {
        int rowsEnd = rows - 1 - rowStart;
        int colsEnd = cols - 1 - colStart;
        //1.从左到右打印行
        for (int i = colStart; i <= colsEnd; i++) {
            res.add(matrix[rowStart][i]);
        }
        //2.从上到下打印列
        if (rowsEnd > rowStart) {
            for (int i = rowStart + 1; i <= rowsEnd; i++) {
                res.add(matrix[i][colsEnd]);
            }
        }
        //3.从右向左打印行
        if (rowsEnd > rowStart && colsEnd > colStart) {
            for (int i = colsEnd-1; i >= colStart; i--) {
                res.add(matrix[rowsEnd][i]);
            }
        }
        //4.从下向上打印列
        if (rowsEnd > rowStart && colsEnd > colStart) {
            for (int i = rowsEnd-1; i >rowStart; i--) {
                res.add(matrix[i][colStart]);
            }
        }
    }

}
