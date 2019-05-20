
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
    private String fileName;
    private String[] dates;
    private double[] data;
    
    public FileIO(String file) throws FileNotFoundException {
        fileName = file;
        System.out.println("Scanning file" + fileName);
        Scanner input = new Scanner(new File(file));
        int index = 0; 
        
        dates = new String[100];
        data = new double[100];
        
        while(input.hasNextLine()) {
            String line = input.nextLine();
            String[] words = line.split(", ");
            System.out.println(Arrays.toString(words));
            dates[index] = words[0];
            data[index] = Double.parseDouble(words[1]);
            index++;
        }
    }
    
    public String[] getDates(){
        return dates;
    }
    
    public double[] getData(){
        return data;
    }
    
    public String getFileName(){
        return fileName;
    }
}
