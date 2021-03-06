import java.awt.Color;

/**
 * This class creates the mirror filter that can be applied to any selected image.
 *
 * @author Ben Suarez
 * @version 04-19-2021 v1.0
 */
public class MirrorFilter extends Filter
{
    /**
     * Constructor for objects of class MirrorFilter
     */
    public MirrorFilter(String name)
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
                Color left = image.getPixel(x, y);
                image.setPixel(x, y, image.getPixel(width-1-x, y));
                image.setPixel(width-1-x, y, left);
            }
        }
    }
}
