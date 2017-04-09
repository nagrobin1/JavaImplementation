import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by test on 4/8/17.
 */
public class PlayDummy {

    public static void main(String [] args){

        String g = "1, 2, 4";
        Scanner s = new Scanner(g).useDelimiter(",");
        ArrayList<Integer> initialInventory = new ArrayList<Integer>();
        while (s.hasNext()) {
            int input = s.nextInt();
            // Only accept negative numbers
            if(input > 0){
                initialInventory.add(input);
            }
        }
    }

}
