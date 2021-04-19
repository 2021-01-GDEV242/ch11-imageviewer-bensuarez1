import java.awt.Color;

/**
 * Write a description of class BlurFilter here.
 *
 * @author Ben Suarez
 * @version 04-19-2021 v1.0
 */
public class BlurFilter extends Filter
{
    /**
     * Constructor for objects of class BlurFilter
     */
    public BlurFilter(String name)
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
        Color up = null;
        Color down = null;
        Color right = null;
        Color left = null;
        Color downRight = null;
        Color downLeft = null;
        Color upRight = null;
        Color upLeft = null;
        Color[][] pixels = new Color[width][height];
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                pixels[x][y] = image.getPixel(x,y);
            }
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(y <= 0){
                    up = pixels[x][y];
                    down = pixels[x][y+1];
                    if(x >= width-1){
                        upRight = pixels[x][y];
                        upLeft = pixels[x-1][y];
                        right = pixels[x][y];
                        left = pixels[x-1][y];
                        downRight = pixels[x][y+1];
                        downLeft = pixels[x-1][y+1];
                    }
                    else if(x<=0){
                        upRight = pixels[x+1][y];
                        upLeft = pixels[x][y];
                        right = pixels[x+1][y];
                        left = pixels[x][y];
                        downRight = pixels[x+1][y+1];
                        downLeft = pixels[x][y+1];
                    }
                    else{
                        upRight = pixels[x+1][y];
                        upLeft = pixels[x-1][y];
                        right = pixels[x+1][y];
                        left = pixels[x-1][y];
                        downRight = pixels[x+1][y+1];
                        downLeft = pixels[x-1][y+1];
                    }
                }
                else if(y>=height-1){
                    up = pixels[x][y-1];
                    down = pixels[x][y];
                    if(x >= width-1){
                        upRight = pixels[x][y-1];
                        upLeft = pixels[x-1][y-1];
                        right = pixels[x][y];
                        left = pixels[x-1][y];
                        downRight = pixels[x][y];
                        downLeft = pixels[x-1][y];
                    }
                    else if(x<=0){
                        upRight = pixels[x+1][y-1];
                        upLeft = pixels[x][y-1];
                        right = pixels[x+1][y];
                        left = pixels[x][y];
                        downRight = pixels[x+1][y];
                        downLeft = pixels[x][y+1];
                    }
                    else{
                        upRight = pixels[x+1][y-1];
                        upLeft = pixels[x-1][y-1];
                        right = pixels[x+1][y];
                        left = pixels[x-1][y];
                        downRight = pixels[x+1][y];
                        downLeft = pixels[x-1][y];
                    }
                }
                else{
                    up = pixels[x][y-1];
                    down = pixels[x][y];
                    if(x >= width-1){
                        upRight = pixels[x][y-1];
                        upLeft = pixels[x-1][y-1];
                        right = pixels[x][y];
                        left = pixels[x-1][y];
                        downRight = pixels[x][y+1];
                        downLeft = pixels[x-1][y+1];
                    }
                    else if(x<=0){
                        upRight = pixels[x+1][y-1];
                        upLeft = pixels[x][y-1];
                        right = pixels[x+1][y];
                        left = pixels[x][y];
                        downRight = pixels[x+1][y+1];
                        downLeft = pixels[x][y+1];
                    }
                    else{
                        upRight = pixels[x+1][y-1];
                        right = pixels[x+1][y];
                        left = pixels[x-1][y];
                        downRight = pixels[x+1][y+1];
                        downLeft = pixels[x-1][y+1];
                    }
                }
                int red = (pixels[x][y].getRed()+up.getRed()+upRight.getRed()+upLeft.getRed()+right.getRed()+left.getRed()+down.getRed()+downRight.getRed()+downLeft.getRed())/9;
                int green = (pixels[x][y].getGreen()+up.getGreen()+upRight.getGreen()+upLeft.getGreen()+right.getGreen()+left.getGreen()+down.getGreen()+downRight.getGreen()+downLeft.getGreen())/9;
                int blue = (pixels[x][y].getBlue()+up.getBlue()+upRight.getBlue()+upLeft.getBlue()+right.getBlue()+left.getBlue()+down.getBlue()+downRight.getBlue()+downLeft.getBlue())/9;
                image.setPixel(x, y, new Color(red, green, blue));
            }
        }
    }
}
