package extendedTypes.matrix;

public class Matrix {

    public static double[][] identity(int dim) {
        double[][] i = new double[dim][dim];
        for (int mn = 0; mn < dim; mn++) {
            i[mn][mn] = 1;
        }
        return i;
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        int aM = a.length;
        int aN = a[0].length;
        int bM = b.length;
        int bN = b.length;
        if (aN != bM) {
            throw new RuntimeException("Invalid vector dimensions. Matric: multiply");
        }
        double[][] c = new double[aM][aN];
        for (int m = 0; m < aM; m++) {
            for (int n = 0; n < bN; n++) {
                for (int o = 0; o < bM; o++) {
                    c[m][n] += a[m][o] * b[o][n];
                }
            }
        }
        return c;
    }
}
