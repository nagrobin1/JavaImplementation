/**
 * Created by test on 4/6/17.
 */
public class GenericMethod {

    public static void main(String [] args){

        // Print array of any type
        Integer [] integers = {1,2,3,4,5,6};
        Double [] doubles = {1.0, 2.0, 3.0, 4.0, 5.0};
        String [] strings = {"tonu", "robin"};

        printAnyArray(integers);
        printAnyArray(doubles);
        printAnyArray(strings);

        System.out.println("Max item is " + maxItem(integers));
        System.out.println("Max item is " + maxItem(doubles));

    }

    public static <T> void printAnyArray(T [] input){

        for(T item: input){
            System.out.println(item);
        }

    }

    // Since T is a reference type, we cannot use normal
    // oprators like > , <, == , on them. We need to use
    // the compareTo method. To do this, we have to make
    // sure that T is limited to Comparable reference types
    // The Return Type can also be T
    public static <T extends Comparable> T maxItem(T[] input){
        T max = input[0];
        for(T item: input){
            // need to use compareTo function to compare
            if(item.compareTo(max) == 1){
                max = item;
            }
        }

        return max;

    }

}
