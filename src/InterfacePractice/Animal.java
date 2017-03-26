package InterfacePractice;

/**
 * Created by test on 3/22/17.
 */

interface Animal {

    // by default member variables are public, static, and final
    boolean alive = true;

    // by default methods are abstract and public
    int distance(int walkSpeed);
    String makeNoise();

    // concrete method, this can be called without an object
    public static void makeMoo(){
        System.out.println("Moo");
    }

}
