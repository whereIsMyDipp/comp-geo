package common;

import org.junit.Test;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dipp on 20.03.2016.
 */
public class Aufgabe1Test {

    /**
     * Logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Aufgabe1Test.class);

    /**
     * Check with 5 dummy lines
     * @throws Exception
     */
    @Test
    public void naive5() throws Exception{
        LOGGER.debug("Naive test started");
        this.ccwCheck(Util.readLinesFromFile("s_5_1.dat"));
    }

    /**
     * Comaprison method as described in out task
     * @param list
     */
    private void ccwCheck(List<Line2D> list) {
        LOGGER.debug("List size: {}", list.size());
        int crossed = 0;
        Long timeStart = System.currentTimeMillis();
        for (Line2D line: list) {
            for (Line2D line2: list) {
                if (!line.equals(line2)) {
                    double result = Util.ccw(line.getP1(), line.getP2(), line2.getP1());
                    double result2 = Util.ccw(line.getP1(), line.getP2(), line2.getP2());


                    if (result > 0 && result2 < 0 || result < 0 && result2 > 0) {
                        LOGGER.debug("line crossed");
                        crossed ++;
                    }
                    if (result == result2) {
                        LOGGER.debug("Colinear");
                    }
                }
            }
        }

        LOGGER.debug("Time consumed: {}", (System.currentTimeMillis()-timeStart));
        LOGGER.debug("Lines crossings: {} out of {}", crossed, list.size());
    }


}
