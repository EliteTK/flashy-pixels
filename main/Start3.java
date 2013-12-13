package main;

import extended.types.matrix.Matrix;

/**
 *
 * @author main
 */
public class Start3 {

    public static void main(String[] args) {
        double[][] mat1 = {{1,-5,3,4},{5,6,-7,8},{9,1,8,0},{3,-4,0,0}};
        double val2 = 0.0;
        
        assert(Matrix.isSquare(mat1));
        
        val2 = Matrix.determinant(mat1);
        
        Matrix.print(mat1);
        System.out.println(val2);
    }
}
