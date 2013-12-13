package main;

import extended.types.matrix.Matrix;

/**
 *
 * @author main
 */
public class Start3 {

    public static void main(String[] args) {
        double[][] mat1 = {{1,2,3},{4,5,6},{5,4,3}};
        double[][] mat2 = new double[3][3];
        
        assert(Matrix.isSquare(mat1));
        assert(Matrix.isSquare(mat2));
        
        for (int x = 0; x < mat1.length; x++) {
            for (int y = 0; y < mat1[0].length; y++) {
                System.out.println(x + " " + y);
                mat2[x][y] = Matrix.cofactor(mat1, x, y);
            }
        }
        
        Matrix.print(mat1);
        Matrix.print(mat2);
    }
}
