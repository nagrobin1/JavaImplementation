package ClassPractice;

/**
 * Created by test on 2/1/17.
 */
public class CommissionEmployee {

    int age;
    int salary;

    CommissionEmployee(int salary, int age){
        if(salary < 0){
            throw new IllegalArgumentException("Salary must be greater than 0");
        }

        if(age  < 18){
            throw new IllegalArgumentException("Age must be over 18 years old");
        }

        this.salary = salary;
        this.age = age;
    }
}

class CommisitonTest{
     public static void main(String [] args){

         CommissionEmployee rob = new CommissionEmployee(-23, 0);

     }

        }
