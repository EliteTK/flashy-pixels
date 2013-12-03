package main;

import extendedTypes.matrix.Matrix;

/**
 *
 * @author main
 */
public class Start3 {

    public static void main(String[] args) {
        double[][] mat1 = {{1.0, 3.0, 1.0}, {4.0, 2.0, 1.0}, {7.0, 4.0, 1.0}};
        double[][] mat2 = {{34.0}, {12.0}, {4.0}};
        double[][] mat3 = {{1.0, 3.0, 1.0}};

        Matrix.print(mat1);
        System.out.println();
        Matrix.print(mat2);
        System.out.println();
        Matrix.print(Matrix.invert(mat1));
        System.out.println();
        Matrix.print(Matrix.multiply(Matrix.invert(mat1), mat2));
        System.out.println();
        Matrix.print(Matrix.multiply(mat1, Matrix.multiply(Matrix.invert(mat1), mat2)));
        System.out.println();
        Matrix.print(mat2);
    }
}
