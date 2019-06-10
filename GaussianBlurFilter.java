
/**
 * Write a description of class GaussianBlurFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GaussianBlurFilter implements Filter
{
    public void filter(PixelImage pi)
    {
        int[][] g = {{1,2,1},{2,4,2},{1,2,1}}; 

        pi.getAverages(g, 0);
    }
}
