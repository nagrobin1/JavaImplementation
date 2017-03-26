package ClassPractice.InheritancePractice;

import ClassPractice.Circle;

/**
 * Created by test on 3/15/17.
 *
 * This file implements Cylinder using Inheritance of the Circle class.
 * IS-a relation
 */

// Inherits Circle
public class Cylinder extends Circle {

    private double height;

    public Cylinder(){
        super();
        this.height = 1.0;

    }

    // Overriding Circle getArea method
    // This getArea method will return the surface area
    // This getArea method will still use the getArea() from the Circle class
    // Returns the surface area (=2π×radius×height + 2×base-area)
    @Override
    public double getArea(){
        return (2*Math.PI*this.getRadius()*this.getHeight()) + (2*super.getArea());
    }


    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double radius, double height){
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color){
        super(radius,color);
        this.height = height;
    }

    public double getHeight(){
        return this.height;
    }

    public void setHeight(double h){
        this.height = h;
    }

    public double getVolume(){
        return this.getArea() * this.height;
    }

    // Overriding the toString method
    // This method will return more info
    // This toString method will still use the toString() from the Circle class
    //@Override
//    public String toString(){
//        return "Cylinder Property: " + this.getHeight() + " Circular Properties: " + super.toString();
//    }



    // TESTING
    public static void main (String[] args) {
        // Declare and allocate a new instance of cylinder
        //   with default color, radius, and height
        Cylinder c1 = new Cylinder();
        System.out.println(c1.getArea());
        System.out.println(c1.toString());

        // Declare and allocate a new instance of cylinder
        //   specifying height, with default color and radius
        Cylinder c2 = new Cylinder(10.0);
        System.out.println(c2.getArea());
        System.out.println(c2.toString());

        // Declare and allocate a new instance of cylinder
        //   specifying radius and height, with default color
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println(c3.getArea());
        System.out.println(c3.toString());


        Circle h = new Cylinder();

    }

}
