
/**
 * Write a description of class GreyScaleFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GrayScaleFilter implements Filter
{
    public void filter(PixelImage pi)
    {
        Pixel[][] data = pi.getData();
        
        for (int row = 0; row < data.length; row ++)
        {
            for (int col = 0; col < data[0].length; col++)
            {
                Pixel p = data[row][col];
                int red = p.getRed();
                int green = p.getGreen();
                int blue = p.getBlue();
                
                int average = ((red + blue + green) / 3);
                
                p.setRed(average);
                p.setGreen(average);
                p.setBlue(average);
            }
        }
        
        pi.setData(data);
    }
}
