
/**
 * Write a description of class FileIO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class FileIO
{
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter the file directory: ");
        Scanner in = new Scanner(System.in);
        String file = in.next();
        Scanner input = new Scanner(new File(file));
        Hashmap<Integer, Double> data = new ;
        while(input.hasNextLine()) {
            String line = input.nextLine();
            String[] words = line.split(", ");
            data.add(Double.parseDouble(words[1]));
        }
        ArrayList<Double> est = new ArrayList<>();
        for(int i = 0; i < data.size()-1; i++) {
            est.add((data.get(i)+data.get(i+1))/2);
        }
        double slope = est.get(est.size()-1) - est.get(est.size()-2);
        est.add(slope+est.get(est.size()-1));
        PrintStream output = new PrintStream(new File("analysisResult.txt"));
        output.println(est);
    }
}
