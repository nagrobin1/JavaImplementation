package ClassPractice;

/**
 * Created by test on 2/1/17.
 */
public class Animal {

    int height;
    int weight;

    private int ID;

    // Super-Class Constructor
    public Animal(int h, int w){
        this.height = h;
        this.weight = w;
        this.ID += 1;
    }

    // public method
    public void alive(){
        System.out.println("Alive");
    }

    // Super Class equals
    public boolean equals(Object a){
        if (a == this){
            return true;
        }

        if(a == null){
            return false;
        }

        if(!(a instanceof Animal)){
            return false;
        }

        // cast to Animal

        Animal o = (Animal) a;



        if(this.height == o.height &&
                this.weight == o.weight){
            return true;
        }

        return false;
    }

}
// no modifier means "package protected", so the class may be accessed by classes from the same package.
class Dog extends Animal {

    boolean bark;
    String breed;

    public Dog(int h, int w, boolean b, String brd){

        // Call SuperClass Constructor to set values for
        // height and weight
        super(h,w);
        // set the specific fields of Dog class
        this.bark = b;
        this.breed = brd;
    }

    public String toString(){
        return " " + height + "" + weight + " " + breed;

        // You cannot access ID because that is a private field
        // inside the super-class of Animal
    }

    public boolean equals(Object a){
        if (a == this){
            return true;
        }

        if(a == null){
            return false;
        }

        if(!(a instanceof Dog)){
            return false;
        }

        // cast to dog

        Dog o = (Dog) a;



        if(this.bark == o.bark && this.breed == o.breed &&  super.equals(o)){
            return true;
        }

        return false;
    }

}

class TestDog {

    public static void main(String args[]) {
        Dog dogA = new Dog(23,30, true,"Shepard");   // Animal reference and object

        Dog dogB = new Dog(2,30,true, "Shepard");

        dogA.alive();

        System.out.println(dogA.equals(dogB));

        // Allowed because Dog is a Dog
        Dog a = new Dog(2,3,true, "she");
        System.out.println(a.getClass()); // Dog

        // Not Allowed because a new Animal is not a Dog by default
        // Dog b = new Animal(2, 3);

        // Allowed because an Animal is an Animal
        Animal c = new Animal(2,3);
        System.out.println(c.getClass()); // Animal

        // Allowed because a new Dog is an Animal by default
        Animal d = new Dog(2,3,true,"he");
        System.out.println(d.getClass()); // DOG

        // Upcasting: Turning Dog a into an Animal -> Already true by default
        Animal e = (Animal) a;
        System.out.println(e.getClass()); // DOG

        // Downcasting, turning Animal C into a Dog
        //c = (Dog) c;
        //System.out.println(c.getClass()); // DOG

    }
}




