import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public final class ImmutableMatrix {


    //fields
    private final int height, width;
    private final int[][] m;


    //constructors
    public ImmutableMatrix() {
        m = new int[][] {};
        height=0;
        width=0;
    }

    public ImmutableMatrix(int height, int width)
    {
        this.height = height;
        this.width = width;
        m = new int[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                System.out.println("Input M[" + i + "][" + j + "] : ");
                Scanner userInput = new Scanner( System.in );
                this.m[i][j] = userInput.nextInt();
            }
        }
    }

    public ImmutableMatrix(Matrix matrix) {
        height = matrix.getHeight();
        width = matrix.getWidth();

        m = new int[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                m[i][j] = matrix.getElement(i+1, j+1);
            }
        }
    }

    public ImmutableMatrix(int[][] matrix) {
        height = matrix.length;
        width = matrix[0].length;

        m = new int[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                m[i][j] = matrix[i][j];
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

    public int[] dimensionMatrix(){
        return new int[] {height, width};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableMatrix matrix = (ImmutableMatrix) o;
        return height == matrix.height && width == matrix.width && Arrays.equals(m, matrix.m);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(height, width);
        result = 31 * result + Arrays.hashCode(m);
        return result;
    }
}
