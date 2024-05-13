package huaweiTest;
import java.util.*;
public class LuoxuanNumJuzheng {



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt(); // 数字个数
            int m = scanner.nextInt(); // 行数
            int[][] matrix = new int[m][m]; // 创建一个m行m列的矩阵
            int num = 1; // 要填充的数字
            int left = 0, right = m - 1; // 矩阵左右边界
            int top = 0, bottom = m - 1; // 矩阵上下边界

            // 按照顺时针螺旋向内的顺序填充矩阵
            while (num <= n) {
                // 从左到右填充上边界
                for (int i = left; i <= right && num <= n; i++) {
                    matrix[top][i] = num++;
                }
                top++;

                // 从上到下填充右边界
                for (int i = top; i <= bottom && num <= n; i++) {
                    matrix[i][right] = num++;
                }
                right--;

                // 从右到左填充下边界
                for (int i = right; i >= left && num <= n; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;

                // 从下到上填充左边界
                for (int i = bottom; i >= top && num <= n; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }

            // 输出填充后的矩阵
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j]);
                    if (j < m - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            scanner.close();
        }
    }


