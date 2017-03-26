package ClassPractice;

/**
 * Created by test on 3/15/17.
 */
public class Triangle {

    // Composition using the Point class, Has-a relationship
    // Declaration
    private Point v1;
    private Point v2;
    private Point v3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
        // Instantiation using the new keyword
        this.v1 = new Point(x1, y1);
        this.v2 = new Point(x2, y2);
        this.v3 = new Point(x3, y3);
    }

    public Triangle(Point p1, Point p2, Point p3){

        // in this way, if p1, p2, p3 ever change their values,
        // our triangle's vertexes will also change
        this.v1 = p1;
        this.v2 = p2;
        this.v3 = p3;

        /* in this way if p1, p2, p3 ever change their values,
        our triangle's vertexes will NOT also change
        this.v1 = new Point(p1.getX(), p1.getY());
        this.v2 = new Point(p2.getX(), p2.getY());
        this.v3 = new Point(p3.getX(), p3.getY());
        */
    }

    @Override
    public String toString(){
        return " v1: " + this.v1.toString() + ", v2: " + this.v2.toString() + ", v3: " + this.v3.toString();
    }

    public double getPerimeter(){
        double d1 = this.v1.distance(v2);
        double d2 = this.v2.distance(v3);
        double d3 = this.v3.distance(v1);
        return d1 + d2 + d3;
    }

    public String getType(){
        double d1 = this.v1.distance(v2);
        double d2 = this.v2.distance(v3);
        double d3 = this.v3.distance(v1);

        if(d1 == d2 && d2 == d3){
            return "Equilateral";
        }else if(d1 == d2 ^ d2 == d3 ^ d1 == d3){
            return "Isoceles";
        }else{
            return "Scalene";
        }

    }

}
