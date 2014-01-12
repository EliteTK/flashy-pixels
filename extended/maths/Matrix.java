package extended.maths;

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
     * @param mat
     * @param i
     * @param j
     * @return Returns the minor of mat at position i, j.
     */
    public static double minor(double[][] mat, int i, int j) {
        /* 
         * 
         */

        if (isSquare(mat) && mat.length > 1) {
            double[][] out = new double[mat.length - 1][mat[0].length - 1];
            int wi = 0, wj = 0;
            for (int ai = 0; ai < mat.length; ai++) {

                if (ai != i) {
                    for (int aj = 0; aj < mat[0].length; aj++) {
                        if (aj != j) {
                            out[wi][wj] = mat[ai][aj];
                            wj++;
                        }
                    }
                    wj = 0;
                    wi++;
                }
            }
            return determinant(out);
        } else {
            throw new IllegalArgumentException("Invalid matrix dimensions. Matrix: minor", new ArrayIndexOutOfBoundsException());
        }
    }

    /**
     *
     * @param mat
     * @param i
     * @param j
     * @return Returns the cofactor of mat at position i, j.
     */
    public static double cofactor(double[][] mat, int i, int j) {
        if (isSquare(mat)) {
            return Math.pow(-1, i + j) * minor(mat, i, j);
        } else {
            throw new IllegalArgumentException("Invalid matrix dimensions. Matrix: cofactor", new ArrayIndexOutOfBoundsException());
        }
    }

    /**
     *
     * @param mat
     * @return The cofactor matrix of mat.
     */
    public static double[][] cofactor(double[][] mat) {
        if (isSquare(mat)) {
            double[][] out = new double[mat.length][mat.length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    out[i][j] = cofactor(mat, i, j);
                }
            }
            return out;
        } else {
            throw new IllegalArgumentException("Invalid matrix dimensions. Matrix: cofactor", new ArrayIndexOutOfBoundsException());
        }
    }

    /**
     *
     * @param mat
     * @return The determinant of the matrix mat.
     */
    public static double determinant(double[][] mat) {
        if (isSquare(mat)) {
            switch (mat.length) {
                case 1:
                    return mat[0][0];

                case 2:
                    return det2(mat);

                case 3:
                    return det3(mat);

                default:
                    return detDefault(mat);
            }
        } else {
            throw new IllegalArgumentException("Invalid matrix dimensions. Matrix: determinant", new ArrayIndexOutOfBoundsException());
        }
    }

    private static double det2(double[][] mat) {
        /* [a b]
         * [c d]
         *
         * det = ad - bc
         */

        return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
    }

    private static double det3(double[][] mat) {
        /* [a b c]
         * [d e f]
         * [g h i]
         *
         * det = (aei+bfg+cdh)-(ceg+bdi+afh)
         */

        return ((mat[0][0] * mat[1][1] * mat[2][2])
                + (mat[0][1] * mat[1][2] * mat[2][0])
                + (mat[0][2] * mat[1][0] * mat[2][1]))
                - ((mat[0][2] * mat[1][1] * mat[2][0])
                + (mat[0][1] * mat[1][0] * mat[2][2])
                + (mat[0][0] * mat[1][2] * mat[2][1]));
    }

    private static double detDefault(double[][] mat) {
        double val = 0.0;
        for (int i = 0; i < mat[0].length; i++) {
            val += cofactor(mat, 0, i) * mat[0][i];
        }
        return val;
    }

    public static double[][] transpose(double[][] mat) {
        double[][] out = new double[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                out[j][i] = mat[i][j];
            }
        }
        return out;
    }

    /**
     *
     * @param mat
     * @return Returns the inverse of the matrix mat;
     */
    public static double[][] invert(double[][] mat) {
        if (isSquare(mat)) {
            return multiply(transpose(cofactor(mat)), 1 / determinant(mat));
        } else {
            throw new IllegalArgumentException("Invalid matrix dimensions. Matrix: invert", new ArrayIndexOutOfBoundsException());
        }
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
            throw new IllegalArgumentException("Invalid matrix dimensions. Matrix: subtract", new ArrayIndexOutOfBoundsException());
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

    /**
     *
     * @param mat
     * @return Returns true if the matrix is a square matrix.
     */
    public static boolean isSquare(double[][] mat) {
        return mat.length == mat[0].length;
    }
}
