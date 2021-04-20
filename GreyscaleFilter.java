import java.awt.Color;

/**
 * This class creates the greyscale filter that can be applied to any selected image.
 *
 * @author Ben Suarez
 * @version 04-19-2021
 */
public class GreyscaleFilter extends Filter
{
    /**
     * Constructor for objects of class GreyscaleFilter
     */
    public GreyscaleFilter(String name)
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
                Color pixel = image.getPixel(x, y);
                int average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                image.setPixel(x, y, new Color(average, average, average));
            }
        }
    }
}
