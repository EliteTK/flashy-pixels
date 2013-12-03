package extendedTypes.matrix;

public class Matrix {

    /**
     *
     * @param dim
     * @return Returns an identity matrix of size dim by dim.
     */
    public static double[][] identity(int dim) {
        double[][] identity = zero(dim);
        for (int mn = 0; mn < dim; mn++) {
            identity[mn][mn] = 1;
        }
        return identity;
    }

    /**
     *
     * @param dim
     * @return Returns a zero matrix of size dim by dim.
     */
    public static double[][] zero(int dim) {
        double[][] zero = new double[dim][dim];
        for (int x = 0; x < dim; x++) {
            for (int y = 0; y < dim; y++) {
                zero[x][y] = 0;
            }
        }
        return zero;
    }

    /**
     *
     * @param mat1
     * @param mat2
     * @return Matrix a multiplied by matrix b;
     */
    public static double[][] multiply(double[][] mat1, double[][] mat2) {
        int aM = mat1.length;
        int aN = mat1[0].length;
        int bM = mat2.length;
        int bN = mat2[0].length;
        if (aN != bM) {
            throw new IllegalArgumentException("Invalid matrix dimensions. Matrix: multiply", new ArrayIndexOutOfBoundsException());
        }
        double[][] c = new double[aM][bN];
        for (int m = 0; m < aM; m++) {
            for (int n = 0; n < bN; n++) {
                for (int o = 0; o < bM; o++) {
                    c[m][n] += mat1[m][o] * mat2[o][n];
                }
            }
        }
        return c;
    }

    /**
     *
     * @param mat
     * @param multiplier
     * @return Returns mat with each of its elements multiplied by multiplier.
     */
    public static double[][] multiply(double[][] mat, double multiplier) {
        double[][] matOut = new double[mat.length][mat[0].length];
        for (int x = 0; x < mat.length; x++) {
            for (int y = 0; y < mat[0].length; y++) {
                matOut[x][y] = mat[x][y] * multiplier;
            }
        }
        return matOut;
    }

    /**
     *
     * @param mat
     * @return Returns the inverse of the matrix mat;
     */
    public static double[][] invert(double[][] mat) {
        double[][] matOut = new double[mat.length][mat[0].length];
        return matOut;
    }

    /**
     *
     * @param mat1
     * @param mat2
     * @return Add mat1 and mat2 by corresponding elements. The determinants of
     * mat1 and mat2 have to be the same.
     */
    public static double[][] add(double[][] mat1, double[][] mat2) {

        if ((mat1.length == mat2.length) && (mat1[0].length == mat2[0].length)) {
            double[][] matOut = new double[mat1.length][mat1[0].length];

            for (int x = 0; x < mat1.length; x++) {
                for (int y = 0; y < mat1[0].length; y++) {
                    matOut[x][y] = mat1[x][y] + mat2[x][y];
                }
            }

            return matOut;
        } else {
            throw new IllegalArgumentException("Invalid matrix dimensions. Matrix: add", new ArrayIndexOutOfBoundsException());
        }
    }

    /**
     *
     * @param mat1
     * @param mat2
     * @return Subtract mat1 and mat2 by corresponding elements. The
     * determinants of mat1 and mat2 have to be the same.
     */
    public static double[][] subtract(double[][] mat1, double[][] mat2) {

        if ((mat1.length == mat2.length) && (mat1[0].length == mat2[0].length)) {
            double[][] matOut = new double[mat1.length][mat1[0].length];

            for (int x = 0; x < mat1.length; x++) {
                for (int y = 0; y < mat1[0].length; y++) {
                    matOut[x][y] = mat1[x][y] - mat2[x][y];
                }
            }

            return matOut;
        } else {
            throw new IllegalArgumentException("Invalid matrix dimensions. Matrix: add", new ArrayIndexOutOfBoundsException());
        }
    }

    public static void print(double[][] mat) {
        for (int x = 0; x < mat.length; x++) {
            for (int y = 0; y < mat[0].length; y++) {
                System.out.print("[" + String.valueOf(mat[x][y]) + "]");
            }
            System.out.println();
        }
    }
}
