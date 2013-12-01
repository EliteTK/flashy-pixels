
package renderer.screenSpace;

import renderer.window.Window;

/**
 *
 * @author main
 */
public class Screen {
    Window window;
    PixelBuffer pBuffer;
    ZBuffer zBuffer;
    
    public Screen (Window window) {
        this.window = window;
        pBuffer = new PixelBuffer();
        
    }
}
