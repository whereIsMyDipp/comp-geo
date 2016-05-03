package common;

import org.junit.Test;

import java.util.List;

/**
 * Created by Dipp on 20.03.2016.
 */
public class ClosestPointNaivTest {

    @Test
    public void naiv1000() throws Exception{
        List<Line2D> list = Util.readLinesFromFile("s_5_1.dat");
        System.out.println("List size: " + list.size());
        Long timeStart = System.currentTimeMillis();
        Thread.sleep(1000);
        for (Line2D line: list) {
            for (Line2D line2: list) {
                if (!line.equals(line2)) {
                    double result = Util.ccw(line.getP1(), line.getP2(), line2.getP1());
                    double result2 = Util.ccw(line.getP1(), line.getP2(), line2.getP2());



                    if (result > 0 && result2 < 0 || result < 0 && result2 > 0) {
                        System.out.println("line crossed");
                    }
                    //colinear check ccw == 0?
                        //schnitt von punkten
                        //
                }
            }
        }

        System.out.println("time consumed:" + (System.currentTimeMillis()-timeStart));
    }


}
