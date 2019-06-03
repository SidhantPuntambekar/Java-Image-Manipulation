import java.awt.image.*;

/**
 * Provides an interface to a picture as an array of Pixels
 * 
 * @author Richard Dunn, modified by Donald Chinn
 * @version March 1, 2002
 */
public class PixelImage
{
    private BufferedImage myImage;
    private int width;
    private int height;

    /**
     * Map this PixelImage to a real image
     * @param bi The image
     */
    public PixelImage(BufferedImage bi)
    {
        // initialise instance variables
        this.myImage = bi;
        this.width = bi.getWidth();
        this.height = bi.getHeight();
    }

    /**
     * Return the width of the image
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Return the height of the image
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * IGNORE THIS METHOD 
     */
    public BufferedImage getImage() {
        return this.myImage;
    }

    /**
     * Return the image's pixel data as an array of Pixels.  The
     * first coordinate is the x-coordinate, so the size of the 
     * array is [width][height], where width and height are the 
     * dimensions of the array
     * @return The array of pixels
     */
    public Pixel[][] getData() {
        Raster r = this.myImage.getRaster();
        Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
        int[] samples = new int[3];

        for (int row = 0; row < r.getHeight(); row++) {
            for (int col = 0; col < r.getWidth(); col++) {
                samples = r.getPixel(col, row, samples);
                Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
                data[row][col] = newPixel;
            }
        }

        return data;
    }

    /**
     * Set the image's pixel data from an array.  This array matches
     * that returned by getData().  It is an error to pass in an
     * array that does not match the image's dimensions or that
     * has pixels with invalid values (not 0-255)
     * @param data The array to pull from
     */
    public void setData(Pixel[][] data) throws IllegalArgumentException {
        int[] pixelValues = new int[3];     // a temporary array to hold r,g,b values
        WritableRaster wr = this.myImage.getRaster();

        if (data.length != wr.getHeight()) {
            throw new IllegalArgumentException("Array size does not match");
        } else if (data[0].length != wr.getWidth()) {
            throw new IllegalArgumentException("Array size does not match");
        }

        for (int row = 0; row < wr.getHeight(); row++) {
            for (int col = 0; col < wr.getWidth(); col++) {
                pixelValues[0] = data[row][col].getRed();
                pixelValues[1] = data[row][col].getGreen();
                pixelValues[2] = data[row][col].getBlue();
                wr.setPixel(col, row, pixelValues);
            }
        }
    }

     public void getAverages(int[][] a, int offset)

  {

    Pixel[][] data = getData();

    Pixel[][] data2 = getData();

    

    int tw = getTotalWeight(a);

      

    //Get the RGB values current pixel and the 8 pixels surrounding it  

    //Repeat for every pixel

    for (int row = 1; row < getHeight()-1; row++)

    {

      for (int col = 1; col < getWidth()-1; col++)

      {

        Pixel p = data[row][col];//central pixel

        Pixel p1 = data[row-1][col-1];

        Pixel p2 = data[row-1][col];

        Pixel p3 = data[row-1][col+1];

        Pixel p4 = data[row][col-1];

        Pixel p5 = data[row][col+1];

        Pixel p6 = data[row+1][col-1];

        Pixel p7 = data[row+1][col];

        Pixel p8 = data[row+1][col+1];

        

        //Average the RGB values

        int r2 = ((p1.getRed()*a[0][0] + p2.getRed()*a[0][1] + p3.getRed()*a[0][2] + p4.getRed()*a[1][0] + p.getRed()*a[1][1] + + p5.getRed()*a[1][2] + p6.getRed()*a[2][0] + p7.getRed()*a[2][1] + p8.getRed()*a[2][2])/tw)+ offset;

        

        int g2 = ((p1.getGreen()*a[0][0] + p2.getGreen()*a[0][1] + p3.getGreen()*a[0][2] + p4.getGreen()*a[1][0] + p.getGreen()*a[1][1] + p5.getGreen()*a[1][2] + p6.getGreen()*a[2][0] + p7.getGreen()*a[2][1] + p8.getGreen()*a[2][2])/tw) + offset;

        

        int b2 = ((p1.getBlue()*a[0][0] + p2.getBlue()*a[0][1] + p3.getBlue()*a[0][2] + p4.getBlue()*a[1][0] + p.getBlue()*a[1][1] + p5.getBlue()*a[1][2] + p6.getBlue()*a[2][0] + p7.getBlue()*a[2][1] + p8.getBlue()*a[2][2])/tw) + offset;      

        

        if(r2 < 0)

        {

        	r2 = 0;

        }

        if(r2 > 255)

        {

        	r2 = 255;

        }

        if(g2 < 0)

        {

        	g2 = 0;

        }

        if(g2 > 255)

        {

        	g2 = 255;

        }

        if(b2 < 0)

        {

        	b2 = 0;

        }

        if(b2 > 255)

        {

        	b2 = 255;

        }

              

        //Store new values in a separate array

        Pixel q = new Pixel(r2, g2, b2);

        data2[row][col]= q; 

      }

    }



   setData(data2); 

  }
  
   public int getTotalWeight(int[][] a)

  {

	  int tw = 0;

	    for(int i = 0; i < 3; i++)

	    {

	    	for(int j = 0; j<a.length; j++)

	    	{

	    	   tw += a[i][j];

	    	}

	    }

	    if(tw == 0)

	    {

	    	tw = 1;

	    }

	    

	    return tw;

  }
}
