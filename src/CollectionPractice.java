import java.util.*;

/**
 * Created by test on 3/30/17.
 */
public class CollectionPractice {

    public static void main(String[] args){


        // List

        List<String> listNames = new ArrayList<>();

        listNames.add("Tom");
        listNames.add("Mary");
        listNames.add("Peter");
        listNames.add("John");
        listNames.add("Kim");


        // Removal
        for(int i = 0; i<listNames.size(); i++){
            listNames.remove(i);
        }


        // Method 1
        for (int i = 0; i < listNames.size(); i++) {
            String aName = listNames.get(i);
            System.out.println(aName);
        }

        // Method 2
        Iterator<String> iterator = listNames.iterator();
        while (iterator.hasNext()) {
            String aName = iterator.next();
            System.out.println(aName);
        }

        // Method 3
        for (String aName : listNames) {
            System.out.println(aName);
        }


        // Removal
        for(int i = 0; i<listNames.size(); i++){
            listNames.remove(i);
        }


        // ArrayList
        ArrayList<Integer> storage = new ArrayList<Integer>();
        storage.add(2);
        storage.add(5);
        Collections.max(storage); // 5
        Collections.min(storage); // 2


        // Create an array list
        ArrayList al = new ArrayList();

        // add elements to the array list
        al.add("A");
        al.add("B");
        al.add("C");
        al.add("D");
        al.add("E");
        al.add("F");
        al.add("G");

        // Create iterator
        Iterator itr = al.iterator();

        // Transverse
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // RE-INITIALIZE the iterator
        itr = al.iterator();

        // Remove item
        while(itr.hasNext()){
                itr.remove();
        }

        System.out.println(al);



        ///////////////////////////////////
        // HashSet



    }
}
