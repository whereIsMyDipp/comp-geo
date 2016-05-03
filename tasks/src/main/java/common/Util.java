package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dipp on 19.03.2016.
 */
public class Util {
    public static List<Point2D> generateRandomPoints() throws Exception {
        throw new Exception("not yet implemented yet");
    }

    /**
     * Calculates the distance between to defined points
     * @param from first Point
     * @param to second Point
     * @return result
     */
    public static Point2D distancePoint(Point2D from, Point2D to) {
        return new Point2D(to.getX()-from.getX(),to.getY()-from.getY());

    }

    public static double crossProduct(Point2D a, Point2D b) {
        return a.getX() * b.getY() - b.getX() * a.getY();
    }

    public static double ccw(Point2D p1, Point2D p2, Point2D p3) {
        System.out.println("Checking ccw");
        System.out.println("Point p1 \t" + p1.getX() + " \t " + p1.getY());
        System.out.println("Point p2 \t" + p2.getX() + " \t " + p2.getY());
        System.out.println("Point p3 \t" + p3.getX() + " \t " + p3.getY());

        double result = (p1.getX() * p2.getY() - p1.getY() * p2.getX()) +
                (p2.getX()* p3.getY() - p2.getY() * p3.getX()) +
                (p3.getX()* p1.getY() - p3.getY() * p1.getX());

        System.out.println("result-> \t "+ result);
        return result;
    }

    public static int sameSide (double x0, double y0, double x1, double y1,
                                 double px0, double py0, double px1, double py1) {
        int sameSide = 0;

        double dx = x1 - x0;
        double dy = y1 - y0;
        double dx1 = px0 - x0;
        double dy1 = py0 - y0;
        double dx2 = px1 - x1;
        double dy2 = py1 - y1;

        // Cross product of the vector from the endpoint of the line to the point
        double c1 = dx * dy1 - dy * dx1;
        double c2 = dx * dy2 - dy * dx2;

        if (c1 != 0 && c2 != 0)
            sameSide = c1 < 0 != c2 < 0 ? -1 : 1;
        else if (dx == 0 && dx1 == 0 && dx2 == 0)
            sameSide = !isBetween(y0, y1, py0) && !isBetween(y0, y1, py1) ? 1 : 0;
        else if (dy == 0 && dy1 == 0 && dy2 == 0)
            sameSide = !isBetween(x0, x1, px0) && !isBetween(x0, x1, px1) ? 1 : 0;

        return sameSide;
    }

    public static Line2D convertStringToLine(String input) {
        String[] in = input.split(" ");

        Line2D line2D = new Line2D(new Point2D(
                    Double.parseDouble(in[0]),
                    Double.parseDouble(in[1])),
                        new Point2D(
                    Double.parseDouble(in[2]),
                    Double.parseDouble(in[3])));
        return line2D;
    }

    /**
     * Return true if c is between a and b.
     */
    private static boolean isBetween (double a, double b, double c)
    {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }

    public static List<Line2D> readLinesFromFile(String fileName) throws IOException {
        List<Line2D> line2DList = new ArrayList<Line2D>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream in = classloader.getResourceAsStream(fileName);
        System.out.println(in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            line2DList.add(Util.convertStringToLine(line));

        }
        System.out.println(out.toString());   //Prints the string content read from input stream
        reader.close();
        return line2DList;
    }
}
