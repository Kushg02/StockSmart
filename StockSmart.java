
/**
 * Main Runner
 *
 * @Kush (your name)
 * @1.0 (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class StockSmart //Main Program
{
    private double StockSmartScore1;
    private double StockSmartScore2;
    
    public static boolean ready = false;
    
    private static double beta = 1.0;
    private static double principalInvestment = 100.0;
    private static double predictedHigh = 1900.0;
    private static double predictedLow = 1790.0;
    
    public StockSmart()
    {
        StockSmartScore1 = 0;
        StockSmartScore2 = 0;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException //DISCLAIMER: Used in conjunction with reasearch, not an independent analyzer
    {
        StockSmart app = new StockSmart(); //Creates Main App Object
        GUI.gui();
        
        while(!ready){
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        
        //Stock1
        FileIO amzn = new FileIO(GUI.c1FileDir);
        amzn.getData();
        Calculation.Calc1(GUI.c1beta, amzn.getCurr(), GUI.principal, amzn.getLow(), amzn.getHigh(), GUI.c1High, GUI.c1Low);
        app.StockSmartScore1 = Calculation.getScore1();
        
        //Stock2
        FileIO nvda = new FileIO(GUI.c2FileDir);
        nvda.getData();
        Calculation.Calc1(GUI.c2beta, nvda.getCurr(), GUI.principal, nvda.getLow(), nvda.getHigh(), GUI.c2High, GUI.c2Low);
        app.StockSmartScore2 = Calculation.getScore1();
        
        FileIO index = new FileIO(GUI.indexFileDir);
        index.getData();
        Calculation.Calc1(GUI.c2beta, nvda.getCurr(), GUI.principal, nvda.getLow(), nvda.getHigh(), GUI.c2High, GUI.c2Low);
        app.StockSmartScore2 = Calculation.getScore1();
        
        
        System.out.println("Stock 1 has a score of: " + app.StockSmartScore1);
        System.out.println("Stock 2 has a score of: " + app.StockSmartScore2);
        
        String analysis = "<html>";
        
        if(app.StockSmartScore1 > app.StockSmartScore2){
            analysis += amzn.getFileName() + " is the better stock to invest in, because its quanitfiable risk is outweighted by its return on investment";
            analysis += "\n";
        }
        else if(app.StockSmartScore1 < app.StockSmartScore2){
            analysis += nvda.getFileName()+" is the better stock to invest in, because its quanitfiable risk is outweighted by its return on investment";
            analysis += "\n";
        }
        else{
            analysis += "It appears both stocks yielded the same score, this is an extraordinary situation. Our Risk/ROI model determines that neither stock has a conclusive, quantifiable advantage over the other. Choose the stock which you feel more confident in, as neither stock appears to be a poor choice.";   
            analysis += "\n";
        }
        analysis += "</html>";
        GUI.result.setText(analysis);
        //FileIO.subroutine1();
        //GUI.subroutine2();
        Graph.graphStocks(amzn, nvda, index);
        
    }
}
