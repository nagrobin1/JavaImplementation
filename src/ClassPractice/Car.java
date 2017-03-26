package ClassPractice;

/**
 * Created by test on 3/13/17.
 */
public class Car {

    private int year;
    private boolean used;

    Car(int year, boolean used){
        this.year = year;
        this. used = used;
    }
    public final void honk(){
        System.out.println("HOONNNKKK");
    }
}
class Truck extends Car{

    Truck(int year, boolean used){
        super(year, used);
    }
    // if a truck object calls honk, it will
    // automatically call the honk method from
    // the Car class
}

class test{
    public static void main(String [] args){
        Truck A = new Truck(1992, false);
        // Can directly call honk method
        // since the Truck method inherits Car
        A.honk();
        }
}
