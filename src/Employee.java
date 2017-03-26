/**
 * Created by test on 1/27/17.
 */
class Employee {

    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String toString(){
        return (this.name + " is " + this.age + " years old");
    }



}

