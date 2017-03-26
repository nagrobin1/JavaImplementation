package ClassPractice;

/**
 * Created by test on 3/14/17.
 */
public class Author {

    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) throws  IllegalArgumentException{
        this.name = name;
        this.email = email;

        if(gender == 'f' || gender == 'm'){
            this.gender = gender;
        }else{
            throw new IllegalArgumentException("Gender must be either m or f");
        }

    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public char getGender(){
        return this.gender;
    }

    public void setEmail(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " Email: " + this.email + " Gender: " + this.gender;
    }
}
