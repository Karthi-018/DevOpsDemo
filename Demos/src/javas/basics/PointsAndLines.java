package javas.basics;

import java.util.*;

class Point {
    private double x;
    private double y;
 
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {
        double distance = Math.sqrt(
            Math.pow(p2.getY() - p1.getY(), 2) +
            Math.pow(p2.getX() - p1.getX(), 2)
        );
        return distance;
    } 

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

class Line {
    private Point start = new Point(0, 0);
    private Point end = new Point(0, 0);

    Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) { 
        this.end = end;
    }

    public double getLineLength() {
        return Point.distance(start, end);
    }

    public String toString() {
        return "Start: " + this.start + " End: " + this.end;
    }
}

interface ListOfLines {
    Vector<Line> getLinesFromStartingPoint(Point p);
    Line getLineWithMaxLength();
    Vector<Line> list_of_lines = null;
}

class LineList implements ListOfLines {
    Vector<Line> lines;

    public LineList(Vector<Line> lines) {
        this.lines = lines;
    }

    public Vector<Line> getLinesFromStartingPoint(Point p) {
        Vector<Line> res = new Vector<>();
        for (int i = 0; i < lines.size(); i++) { 
            Line curlin = lines.elementAt(i);
            if (test(curlin.getStart(), p))
                res.add(curlin);
        }
        return res;
    }

    private boolean test(Point a, Point b) {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }

    public Line getLineWithMaxLength() {
        Line maxl = lines.elementAt(0);
        for (int i = 1; i < lines.size(); i++) {
            if (lines.elementAt(i).getLineLength() > maxl.getLineLength())
                maxl = lines.elementAt(i);
        }
        return maxl;
    }
}

public class PointsAndLines {

}
