package ClassPractice;

/**
 * Created by test on 3/15/17.
 */
public class Point {

    private int x;
    private int y;

    public Point(){
        x = 0;
        y = 0;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int[] getXY(){
        int [] XY = {this.x, this.y};
        return XY;
    }

    public void setXY(int X, int Y){
        this.x = X;
        this.y = Y;
    }


    @Override
    public String toString(){
        return "(" + this.x +" ," + this.y + ")";
    }

    public double distance(int x, int y){
        return Math.sqrt(Math.pow((this.x - x), 2.0) + Math.pow((this.y - y), 2.0));
    }

    // Overload
    public double distance(Point p){
        return Math.sqrt(Math.pow((this.x - p.getX()), 2.0) + Math.pow((this.y - p.getY()), 2.0));
    }

    // Overload
    public double distance(){
        return Math.sqrt(Math.pow(this.x, 2.0) + Math.pow(this.y, 2.0));
    }
}
