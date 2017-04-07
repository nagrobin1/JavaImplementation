package StreamIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by test on 4/6/17.
 */
public class FileAndDirectoryInfo {

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter file or directory name:");

        // create Path object based on user input
        // Paths is a class the implements the Path interface
        // The java.nio.file.Paths class’s get() static method is used to create a Path.
        // This method converts a path string, or a sequence of  strings that when joined form a path string, to a Path.
        Path path = Paths.get(input.nextLine());

        // Use Files Class to see if the path exsists
        if(Files.exists(path)){
            // get the file name from the path
            System.out.println(path.getFileName());

            // Is the path a directory or not
            System.out.println(Files.isDirectory(path));

            // Print the file path
            System.out.println(path.toAbsolutePath());

        }

    }
}
