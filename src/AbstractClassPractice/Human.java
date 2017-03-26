package AbstractClassPractice;

/**
 * Created by test on 3/23/17.
 */
public abstract class Human {

    private String name;
    private int age;

    // this field will be common to all Humans
    private static int Population = 0;

    // these  methods will be
    // the same among all subclasses, so
    // we can just implement them as concrete
    // methods in the abstract class
    public void setName(String name, int age){
        this.name = name;}

    public String getName(){
        return this.name;}

    public void setAge(int age){
        this.age = age;}

    public int getAge(){
        return this.age;}

    // A concrete static method is allowed
    // Meaning no object is required to call
    // this method
    public static int getPopulation(){
        return Population;}

    // Plain Concrete method
    // Meaning an object will be required
    // to call this method
    public void sayMoo(){
        System.out.println("MOO");}

    // Constructor, which will be called
    // when an object of the subclass is called
    public Human(String name, int age){
        this.name = name;
        this.age = age;
        Population++;}

    // Abstract method, will be implemented by subclass
    public abstract String SayHelloInNativeLanguage();

}



