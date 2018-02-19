package model;
import java.awt.*;
import java.util.ArrayList;
import physics.LineSegment;

public class Absorber {

    private int width;
    private int height;
    private int xpos;
    private int ypos;
    private Color colour;
    private LineSegment ls;

    public Absorber(int x, int y, int absHeight, int absWidth){
        xpos = x;
        ypos = y;
        height = absHeight;
        width = absWidth;
        colour = Color.PINK;
        getLines();
    }

    public LineSegment getLineSegs() {
        return ls;
    }

    public ArrayList<LineSegment> getLines() {
        ArrayList<LineSegment> lines = new ArrayList<LineSegment>();
        LineSegment l1 = new LineSegment(xpos, ypos + height , xpos + width, ypos + height);
        lines.add(l1);
        return lines;
    }


    public int getX() {
        return xpos;
    }

    public int getY() { return ypos; }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColour() {
        return colour;
    }


}
