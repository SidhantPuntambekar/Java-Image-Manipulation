
/**
 * Write a description of class LaplacianBlurFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LaplacianBlurFilter implements Filter
{
    public void filter(PixelImage pi)
    {
    int[][] lap = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}}; 

    pi.getAverages(lap, 0);
    }
}
