package ClassPractice;

/**
 * Created by test on 3/15/17.
 */
public class PolynomialTest {

    public static void main(String [] args){

        // 2x^5+x^4-2x-1
        Polynomial a = new Polynomial(-1,-2,0,0,1,2);

        System.out.println(a.toString());

        System.out.println(a.evaluate(2));
    }

}
