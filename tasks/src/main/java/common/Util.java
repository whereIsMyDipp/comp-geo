package common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    /**
     * Logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

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
        double result = (p1.getX() * p2.getY() - p1.getY() * p2.getX()) +
                (p2.getX()* p3.getY() - p2.getY() * p3.getX()) +
                (p3.getX()* p1.getY() - p3.getY() * p1.getX());

        LOGGER.debug("Result: {}  --> p1: {} p2: {} p3: {}",result,  p1.toString(), p2.toString(), p3.toString());
        return result;
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
        LOGGER.debug("Input File read: {} stream: {}  ", fileName,  in);
        reader.close();
        return line2DList;
    }
}
