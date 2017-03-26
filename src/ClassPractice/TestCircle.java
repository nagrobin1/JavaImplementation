package ClassPractice;

/**
 * Created by test on 3/14/17.
 */
public class TestCircle {

    public static void main(String [] args){
        Circle a = new Circle();
        Author jk = new Author("Robin", "gmail", 'm');
        Author pk = new Author("Ro", "gmail", 'f');
        Author [] loist = {jk, pk};
        Book HP = new Book(loist, "Escape from Ajkaben", 9.99, 20);
        System.out.println(HP);
        // System.out.println(HP.getAuthorName());
    }
}
