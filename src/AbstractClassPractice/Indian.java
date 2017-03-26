package AbstractClassPractice;

/**
 * Created by test on 3/23/17.
 */
public class Indian extends Human{

    // this field is particular to an Indian object
    private String province;

    public Indian(String name, int age, String province){
        // call the Human constructor
        super(name, age);
        // initialize other unique fields inside Indian class
        this.province = province;
    }
    // Abstract method from Human, so need to implemented
    public String SayHelloInNativeLanguage(){
        return "Namaste";
    }
}

class HumanTest{
    public static void main(){

        Indian virat = new Indian("Virat", 23, "Bengal");

        // Call abstract method
        System.out.println(virat.SayHelloInNativeLanguage());

        // Call static concrete method of abstract class
        // Requires no object
        Human.getPopulation();

        // Call concrete method from abstract class
        // Requires object
        virat.sayMoo();
    }
}