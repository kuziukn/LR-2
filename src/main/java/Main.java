public class Main {

    public static void main(String[] args) {

        //1 create empty matrix
        /*
        Matrix mat = new Matrix();
        System.out.println(mat);
        */


        //2 create matrix with size
        /*
        Matrix mat = new Matrix(2, 5);
        System.out.println(mat);
        */


        //3 input matrix elements
        /*
        Matrix mat = new Matrix(2, 3);
        mat.inputMatrix();
        System.out.println(mat);
        */


        //4 copy matrix
        /*
        Matrix matCopy = new Matrix(mat);
        System.out.println(matCopy);
        */


        //5 get row/column/element
        /*
        printArray(mat.getRow(1));
        printArray(mat.getRow(2));

        printArray(mat.getColumn(1));
        printArray(mat.getColumn(2));
        printArray(mat.getColumn(3));

        System.out.println(mat.getElement(2, 3));
        */


        //6 get dimension
        //System.out.println("Dimension of the matrix:\n" + mat.getDimension()[0] + " * " + mat.getDimension()[1]);


        //7 equals method
        /*
        Matrix m1 = new Matrix(new int[][]{
                new int[] {1,2,3},
                new int[] {4,5,6}
        });
        Matrix m2 = new Matrix(new int[][]{
                new int[] {1,2,3},
                new int[] {4,5,6}
        });
        System.out.println(m1.equals(m2));
        */


        //8 hashCode method
        /*
        Matrix m1 = new Matrix(new int[][]{
                new int[] {1,2,3},
                new int[] {4,5,6}
        });
        System.out.println(m1.hashCode());
        Matrix m2 = new Matrix(new int[][]{
                new int[] {1,2,3},
                new int[] {4,5,6}
        });
        System.out.println(m2.hashCode());
        System.out.println(m1.hashCode() == m2.hashCode());
        */


        //9 create diagonal matrix
        //Matrix m = Matrix.createDiagonalMatrix(new int[]{1,5,7,5,7,9,5});


        //10 multiply matrices
        /*
        Matrix m1 = new Matrix(new int[][]{
                new int[] {1,2,3},
                new int[] {4,5,6}
        });

        Matrix m2 = new Matrix(new int[][]{
                new int[] {1,2},
                new int[] {3,4},
                new int[] {5,6}
        });
        System.out.println(Matrix.multiply(m1, m2));
         */

        //11
        /*
        ImmutableMatrix m = new ImmutableMatrix(2, 3);
        System.out.println(m);
        */
    }
    
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
