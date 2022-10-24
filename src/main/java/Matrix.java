import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Matrix {


    //fields
    private int height, width;
    private int[][] m;


    //constructors
    public Matrix() { m = new int[][] {}; }

    public Matrix(int height, int width)
    {
        this.height = height;
        this.width = width;
        m = new int[height][width];
    }

    public Matrix(int[][] matrix) {
        height = matrix.length;
        width = matrix[0].length;

        m = new int[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                m[i][j] = matrix[i][j];
            }
        }
    }

    public Matrix(Matrix matrix) {
        height = matrix.height;
        width = matrix.width;

        m = new int[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                m[i][j] = matrix.m[i][j];
            }
        }
    }



    //methods
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("height = " + height + "\n");
        builder.append("width = " + width + "\n");
        builder.append("array:" + "\n");
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                builder.append(m[i][j] + " ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }



    public void inputMatrix() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                System.out.println("Input M[" + i + "][" + j + "] : ");
                Scanner userInput = new Scanner( System.in );
                this.m[i][j] = userInput.nextInt();
            }
        }
    }


    public int getElement(int row, int column) {
        if(row <= height && row > 0 && column <= width && column > 0) {
            return m[row - 1][column - 1];
        } else {
            throw new IndexOutOfBoundsException("check row and column values");
        }
    }

    public int[] getRow(int row) {
        if(row <= height && row > 0) {
            return m[row - 1];
        } else {
            throw new IndexOutOfBoundsException("check row value");
        }
    }

    public int[] getColumn(int column) {
        if(column <= width && column > 0) {
            int[] c = new int[height];
            for(int i = 0; i < height; i++) {
                c[i] = m[i][column - 1];
            }

            return c;
        } else {
            throw new IndexOutOfBoundsException("check row value");
        }
    }

    public int[] getDimension(){
        return new int[] {height, width};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        boolean result = height == matrix.height && width == matrix.width;
        for(int i = 0; i < height; i++) {
            result = result && Arrays.equals(m[i], matrix.m[i]);
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(height, width);
        for(int[] row: m) {
            result = 31 * result + Arrays.hashCode(row);
        }
        return result;
    }



    public static Matrix createDiagonalMatrix(int[] v) {
        int[][] arr = new int[v.length][v.length];
        for(int i = 0; i < v.length; i++) {
            arr[i][i] = v[i];
        }

        return new Matrix(arr);
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.m[0].length != matrix2.m.length) {
            throw new UnsupportedOperationException("It is not possible two multiply these matrices");
        }

        int[][] result = new int[matrix1.m.length][matrix2.m[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(matrix1.m, matrix2.m, row, col);
            }
        }

        return new Matrix(result);
    }

    private static int multiplyMatricesCell(int[][] firstMatrix, int[][] secondMatrix, int row, int col) {
        int cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }
 }
