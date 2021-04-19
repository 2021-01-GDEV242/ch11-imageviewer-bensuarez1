import java.awt.Color;

/**
 * This class creates the pixalize filter that can be applied to any selected image.
 *
 * @author Ben Suarez
 * @version 04-19-2021 v1.0
 */
public class PixalizeFilter extends Filter
{
    /**
     * Constructor for objects of class PixalizeFilter
     */
    public PixalizeFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        final int PIXEL_SIZE = 5;
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y += PIXEL_SIZE) {
            for(int x = 0; x < width; x += PIXEL_SIZE) {
                Color pixel = image.getPixel(x, y);
                for(int py = y; py < y + PIXEL_SIZE; py++) {
                    for(int px =x; px < x + PIXEL_SIZE; px++) {
                        if(px < width && py < height) {
                            image.setPixel(px, py, pixel);
                        }
                    }
                }
            }
        }
    }
}
