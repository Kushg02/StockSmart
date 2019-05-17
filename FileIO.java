
/**
 * Write a description of class FileIO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class FileIO extends Main
{
    public static void subroutine1() throws FileNotFoundException {
        System.out.println("Enter the file directory: ");
        Scanner in = new Scanner(System.in);
        String file = in.next();
        Scanner input = new Scanner(new File(file));
        int index = 0; 
        while(input.hasNextLine()) {
            String line = input.nextLine();
            String[] words = line.split(", ");
            data[0][index] = Double.parseDouble(words[0]);
            data[1][index] = Double.parseDouble(words[1]);
            index++;
        }
    }
}
