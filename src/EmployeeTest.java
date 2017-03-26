/**
 * Created by test on 1/27/17.
 */
public class EmployeeTest {

    public static void main(String [] args){
        Employee r =new Employee();
        r.setName("Robin");
        r.setAge(23);
        Employee t = new Employee();
        t = r;


        Integer p = 3;
        Integer d = 4;
        System.out.println(p+d);

        System.out.println(r.toString());
        System.out.println(t.toString());

        t.setName("Tonu");
        t.setAge(28);

        System.out.println(r.toString());
        System.out.println(t.toString());
    }
}
