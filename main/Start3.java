package main;

import extended.types.matrix.Matrix;

/**
 *
 * @author main
 */
public class Start3 {

    public static void main(String[] args) {
        double[][] mat1 = {{0.21314, -0.12351}, {0.56323, 0.7156}};
        double[][] mat2;
        mat2 = Matrix.invert(mat1);

        Matrix.print(mat1);
        Matrix.print(mat2);
        Matrix.print(Matrix.multiply(mat1, mat2));
        Matrix.print(Matrix.multiply(mat2, mat1));
    }
}
