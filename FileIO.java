
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
        HashMap<Integer, Double> data = new HashMap<Integer, Double>();
        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] words = line.split(", ");
            data.put(Integer.parseInt(words[0]) ,Double.parseDouble(words[1]));
            System.out.println(Arrays.toString(words));
        }
        
      /* Display content using Iterator*/
      Set set = data.entrySet();
      Iterator iterator = set.iterator();
        
        ArrayList<Double> est = new ArrayList<>();
        System.out.println("data size:" + data.size());
        System.out.println("data value 0:" + data.get(0));

        for(int i = 0; i < data.size()-2; i++) {
            est.add((data.get(i)+data.get(i+1))/2);
        }
        double slope = est.get(est.size()-1) - est.get(est.size()-2);
        est.add(slope+est.get(est.size()-1));
        PrintStream output = new PrintStream(new File("analysisResult.txt"));
        output.println(est);
    }
}
