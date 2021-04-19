import java.awt.Color;

/**
 * Write a description of class SharpenFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SharpenFilter extends Filter
{
    private static float[] sharpenFilter = {
        -1f,-1f,-1f,
        -1f,9f,-1f,
        -1f,-1f,-1f
    };
    /**
     * Constructor for objects of class SharpenFilter
     */
    public SharpenFilter(String name)
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
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                image.setPixel(x, y, image.getPixel(x, y).sharpen());
            }
        }
    }
}
