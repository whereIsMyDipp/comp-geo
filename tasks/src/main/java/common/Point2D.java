package common;

/**
 * Created by Dipp on 19.03.2016.
 */
public class Point2D {

    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.setX(x);
        this.setY(y);
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
