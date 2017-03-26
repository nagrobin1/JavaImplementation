package ClassPractice;

/**
 * Created by test on 3/14/17.
 */
public class Circle {

    private double radius;

    private String color;

    public double getArea(){
        return Math.pow(this.radius, 2.0) * Math.PI;
    }

    public Circle(){
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius(){
        return this.radius;
    }

    public String getColor(){
        return this.color;
    }

    public void setRadius(double r){
        this.radius = r;
    }

    public void setColor(String c){
        this.color = c;
    }

    @Override
    public String toString(){
        return "Radius:" + this.radius + " Color :" + this.color;
    }
}
