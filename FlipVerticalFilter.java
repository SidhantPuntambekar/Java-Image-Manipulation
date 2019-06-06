public class FlipVerticalFilter implements Filter
{
   public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
    
        for(int row = 0; row < data.length / 2; row++)
       {
            for(int col = 0; col < data[0].length; col++)
            {
                Pixel p = data[row][col];
                data[row][col] = data[data.length - row - 1][col];
                data[data.length - row - 1][col] = p;
            }
        }
        
        pi.setData(data);
    }
}
