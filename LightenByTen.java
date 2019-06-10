
/**
 * Write a description of class LightenByTen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LightenByTen implements Filter
{
    public void filter(PixelImage pi)
    {
        Pixel[][] data = pi.getData();
        
        for (int row = 0; row < data.length; row++)
        {
            for (int col = 0; col < data[row].length; col++)
            {
                Pixel p = data[row][col];
                
                int red = (int)Math.round(25+p.getRed());
                int green = (int)Math.round(25+p.getGreen());
                int blue = (int)Math.round(25+p.getBlue());
                
                if (red > 225) red = 225;
                if (green > 225) green = 225;
                if (blue > 225) blue = 225;
                
                p.setRed(red);
                p.setGreen(green);
                p.setBlue(blue);
            }
        }
        pi.setData(data);
    }
}
