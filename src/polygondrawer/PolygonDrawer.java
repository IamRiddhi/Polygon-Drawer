package polygondrawer;

import javax.swing.JFrame;

/**
 *
 * @author riddhi
 */
public class PolygonDrawer
{
    public static void main(String[] args) 
    {
        JFrame f= new CenteredFrame("Polygon Drawer", 1, 1);
        f.add(new PolygonDrawerPanel());
        f.setVisible(true);
                
    }
    
}
