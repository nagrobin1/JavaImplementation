package ClassPractice.InheritancePractice;

import ClassPractice.Circle;

/**
 * Created by test on 3/15/17.
 * Try rewriting the Circle-Cylinder of the previous exercise using composition (as shown in the class diagram)
 * instead of inheritance. That is, "a cylinder is composed of a base circle and a height".
 */

public class CylinderComposition {

    // A cylinder has a relation to circle
    // Hence, we will use composition to achieve the same
    // functionality as we did in Cylinder.java
    private Circle base;
    private double height;

    public CylinderComposition(){
        base = new Circle();
        height = 1;
    }
    // This getArea method will return the surface area
    // This getArea method will still use the getArea() from the Circle class
    // Returns the surface area (=2π×radius×height + 2×base-area)
    public double getArea(){
        return (2 * Math.PI*this.base.getRadius()*this.getHeight()) + (2*this.base.getArea());
    }

    public CylinderComposition(double height){
        base = new Circle();
        this.height = height;
    }

    public CylinderComposition(double height, double radius){
        base = new Circle(radius);
        this.height = height;
    }

    public CylinderComposition(double height, double radius, String color){
        base = new Circle(radius, color);
        this.height = height;
    }

    public void setBase(double r, String c){
        this.base.setRadius(r);
        this.base.setColor(c);
    }

    public void setHeight(double h){
        this.height = h;
    }

    public double getHeight(){
        return this.height;
    }

    public double getVolume(){
        return this.base.getArea() * this.height;
    }

    @Override
    public String toString(){
        return "Cylinder Property: " + this.getHeight() + " Circular Properties: " + this.base.toString();
    }

    // TESTING
    public static void main (String[] args) {
        // Declare and allocate a new instance of cylinder
        //   with default color, radius, and height
        CylinderComposition c1 = new CylinderComposition();
        System.out.println(c1.getArea());
        System.out.println(c1.toString());

        // Declare and allocate a new instance of cylinder
        //   specifying height, with default color and radius
        CylinderComposition c2 = new CylinderComposition(10.0);
        System.out.println(c2.getArea());
        System.out.println(c2.toString());

        // Declare and allocate a new instance of cylinder
        //   specifying radius and height, with default color
        CylinderComposition c3 = new CylinderComposition(2.0, 10.0);
        System.out.println(c3.getArea());
        System.out.println(c3.toString());

    }
}
