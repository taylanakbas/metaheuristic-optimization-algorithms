package live.problems.tsp.instances;
/**
 * author:taylanakbas
 **/
public class Point {
    double x;
    double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point p){
        return Math.hypot(Math.abs(p.y - this.y), Math.abs(p.x - this.x ));
    }

}
