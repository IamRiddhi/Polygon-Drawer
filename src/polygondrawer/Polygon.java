package polygondrawer;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author riddhi
 */
public class Polygon
{
    private int xcoordinates[],ycoordinates[];
    private int n;
    Polygon(int x[], int y[], int n)
    {
       xcoordinates= x;
       ycoordinates= y;
       this.n= n;
    }
    public int[] getXcords()
    {
        return xcoordinates;
    }
    public int[] getYcords()
    {
        return ycoordinates;
    }
    public int getSize()
    {
        return n;
    }
}
