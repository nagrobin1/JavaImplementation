package InterfacePractice;

/**
 * Created by test on 3/22/17.
 */
public class Tiger implements Animal {

    private int runTime;

    public Tiger(int runTime){
        this.runTime = runTime;
    }

    // Need to implement the abstract methods from Animal interface
    public int distance(int walkSpeed){
        return walkSpeed * this.runTime;
    }

    // Need to implement the abstract methods from Animal interface
    public String makeNoise(){
        return "ROAR";
    }
}

class Test{

    public static void main(String [] args){

        Tiger tonu = new Tiger(30);

        // Calling an interface method implemented in the Tiger class
        System.out.println(tonu.distance(20));
        System.out.println(tonu.makeNoise());

        // Calling a concrete method from the Animal interface
        // This requires not object since it is a static method
        Animal.makeMoo();

        // Accessing a member variable from interface
        // This requires not object since it is a static method
        System.out.println(Animal.alive);
    }
}
