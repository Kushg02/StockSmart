
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
    private double currentPrice;
    private double lowPrice;
    private double highPrice;
    
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
        
        currentPrice = data[0];
        
	double max = data[1];
	for(int i=2; i<data.length;i++){
	    if(data[i]>max){
	        max = data[i];
	    }
	}
	highPrice = max;
	
	double min = data[1];
	for(int i=2; i<data.length;i++){
	    if(data[i]<min){
	        min = data[i];
	    }
	}
	lowPrice = min;
    }
    
    public String[] getDates(){
        return dates;
    }
    
    public double[] getData(){
        return data;
    }
    
    public double getHigh(){
        return highPrice;
    }
    
    public double getLow(){
        return lowPrice;
    }
    
    public double getCurr(){
        return currentPrice;
    }
        
    public String getFileName(){
        return fileName;
    }
}
