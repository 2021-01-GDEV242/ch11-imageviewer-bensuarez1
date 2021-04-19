import java.awt.Color;


/**
 * Write a description of class SolarizeFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SolarizeFilter extends Filter
{
    /**
     * Constructor for objects of class SolarizeFilter
     */
    public SolarizeFilter(String name)
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
                int red = pixel.getRed();
                if(red <= 127){
                    red = 255 - red;
                }
                int green = pixel.getGreen();
                if(green <= 127){
                    green = 255 - green;
                }
                int blue = pixel.getBlue();
                if(blue <= 127){
                    blue = 255 - blue;
                }
                image.setPixel(x, y, new Color(red, green, blue));
            }
        }
    }
}
