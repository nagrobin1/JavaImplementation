/**
 * Created by test on 3/29/17.
 */
public class StringBuild {

    public static void addHello(String s){
        s =  s + " Hello";
    }

    public static void addHello(StringBuilder sb){
        sb.append(" Hello");

    }
    public static void main(String[] args){

        // s is immutable
        String s = "robin";
        addHello(s);
        System.out.println(s); // robin

        /////////////////////////////////

        // sb is mutable
        StringBuilder sb = new StringBuilder("tonusri");
        addHello(sb);
        System.out.println(sb); // tonusri Hello


    }
}
