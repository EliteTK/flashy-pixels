
package renderer.modelManager.polygon;

import extended.type.vector.Vec2d;
import extended.type.vector.Vec3d;
import extended.maths.Matrix;

/**
 *
 * @author main
 */
public class ProjectionMatrix {
    
    
    double[][] matrix = new double[4][4];
    double[][] camera = new double[3][1];
    
    
    public ProjectionMatrix() {
        
    }
    
    /**
     *
     * @param vector
     * @return Returns the perspective projected 2d positional screen vector.
     */
    public Vec2d project(Vec3d vector) {
        
        Matrix.multiply( matrix, Matrix.subtract(vector.matrixCol(), camera) );
        
        return null;
        
    }
}
