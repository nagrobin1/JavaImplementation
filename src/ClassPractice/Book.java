package ClassPractice;

/**
 * Created by test on 3/15/17.
 */
public class Book {

    // Composition using the Author class, Has-a relationship
    private Author [] author;

    private String name;
    private double price;
    private int quantatity;

    public Book(Author [] a, String n, double p, int q){
        author = a;
        name = n;
        price = p;
        quantatity = q;
    }

    public String getAuthorName(){
        String names = "";
        for(Author au: this.author){
            names = names + au.getName()+ " , ";
        }
        return names;
    }

    public String toString(){
        return "Name of book: " + this.name + " Authors:(" + this.getAuthorName() + ") Price: " + this.price + " Quantity: " + quantatity;
    }

}
