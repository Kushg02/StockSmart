
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
        
        System.out.println("Enter the file directory: ");
        Scanner in = new Scanner(System.in);
        Scanner input = new Scanner(new File(file));
        int index = 0; 
        while(input.hasNextLine()) {
            String line = input.nextLine();
            String[] words = line.split(", ");
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
