package ClassPractice;

/**
 * Created by test on 3/15/17.
 */
public class PointTriangleTest {

    public static void main(String[] args){

        System.out.println("Triangle Tests...");

        Point A1 = new Point(0,0);
        Point A2 = new Point(3, 0);
        Point A3 = new Point(0, 4);

        // Create new triangle with 3 Points
        Triangle T = new Triangle(A1, A2, A3);

        System.out.println(T.toString());
        System.out.println(T.getPerimeter());
        System.out.println(T.getType());

        System.out.println("Changing values of vertex..");
        // Change one of the original points
        A2.setXY(4, 0);

        // Check if the triangle's vertex has also changed or not - YES
        System.out.println(T.toString());
        System.out.println(T.getPerimeter());
        System.out.println(T.getType());

    }
}
