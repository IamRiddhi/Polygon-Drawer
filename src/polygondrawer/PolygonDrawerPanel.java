package polygondrawer;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author riddhi
 */
public class PolygonDrawerPanel extends JPanel
{
    private ArrayList<Point> points=  new ArrayList<>();
    private ArrayList<Polygon> polygons= new ArrayList<>();
    private JLabel coordinates= new JLabel();
    private int clickCount;
    private static final int RADIUS=10;
    private void resetPoints()
    {
        points.clear();
    }
    public PolygonDrawerPanel()
    {
        setLayout(new BorderLayout());
        
        add(coordinates,BorderLayout.NORTH);
        
        addMouseMotionListener(new MouseMotionAdapter() 
        {
            @Override
            public void mouseMoved(MouseEvent e)
            {
                Point p= e.getPoint();
                coordinates.setText("X:"+p.x+", Y:"+p.y);
            }
        });
        
        addMouseListener(new MouseAdapter() //create an object of such a class that extends mouse adapter...annonymous inner class
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                points.add(e.getPoint());
                clickCount= e.getClickCount();
                repaint();
            }
            
        });
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int xcords[],ycords[];
        int size= points.size();
        xcords= new int[size];
        ycords= new int[size];
        try 
        {
            for(int i=0;i<size;i++)
            {
                xcords[i]=(int)(points.get(i).x);
                ycords[i]= (int)(points.get(i).y);
                g.fillOval(xcords[i]-RADIUS,ycords[i]-RADIUS,2*RADIUS,2*RADIUS);
            }

            if(clickCount==1)
                g.drawPolyline(xcords,ycords,size);
            else if(clickCount==2)
            {
                g.drawPolygon(xcords,ycords,size);
                polygons.add(new Polygon(xcords,ycords,size));
                resetPoints();
            }
            
            //printing all polygons
            for(int i=0;i<polygons.size();i++)
                g.drawPolygon(polygons.get(i).getXcords(),polygons.get(i).getYcords(),polygons.get(i).getSize());
            
        }
        catch(Exception e)
        {
             System.out.println(e);
        }
    }
}
