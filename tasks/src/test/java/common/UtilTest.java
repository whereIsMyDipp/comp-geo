package common;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dipp on 19.03.2016.
 */
public class UtilTest {

    @Test
    public void distancePoint() {
        Point2D p1 = new Point2D(1, 1);
        Point2D p2 = new Point2D(3, 3);
        Point2D p3 = new Point2D(-5, 10);
        Point2D p4 = new Point2D(2, 2);

        Point2D resultP = Util.distancePoint(p1, p2);

        Assert.assertEquals(2, resultP.getX(),01.d);
        Assert.assertEquals(2, resultP.getY(),01.d);

        Point2D resultP2 = Util.distancePoint(p2, p1);

        Assert.assertEquals(-2, resultP2.getX(),01.d);
        Assert.assertEquals(-2, resultP2.getY(),01.d);

        Point2D resultP3 = Util.distancePoint(p3, p1);

        Assert.assertEquals(6, resultP3.getX(),01.d);
        Assert.assertEquals(-9, resultP3.getY(),01.d);
    }

    @Test
    public void testCCW() {
        Point2D p1 = new Point2D(1.0d,1.0d);
        Point2D p2 = new Point2D(3.0d,3.0d);
        Point2D p3 = new Point2D(1.0d,5.0d);

        double result = Util.ccw(p1,p2,p3);

        Assert.assertEquals(result, 8.0d, 0.1d);
    }

    @Test
    public void testCCW2() {
        Point2D p1 = new Point2D(1.0d,1.0d);
        Point2D p2 = new Point2D(3.0d,3.0d);
        Point2D p3 = new Point2D(0.0d,10.0d);

        double result = Util.ccw(p1,p2,p3);

        Assert.assertEquals(result, 20.0d, 0.1d);
    }

    @Test
    public void testCCW3() {
        Point2D p1 = new Point2D(0.0d,0.0d);
        Point2D p2 = new Point2D(7.0d,0.0d);
        Point2D p3 = new Point2D(4.0d,3.0d);

        double result = Util.ccw(p1,p2,p3);

        Assert.assertEquals(result, 21.0d, 0.1d);
    }

    @Test
    public void testCCW4() {
        Point2D p1 = new Point2D(0.0d,0.0d);
        Point2D p2 = new Point2D(7.0d,0.0d);
        Point2D p3 = new Point2D(5.0d,1.0d);

        double result = Util.ccw(p1,p2,p3);

        Assert.assertEquals(result, 7.0, 0.1d);
    }

}