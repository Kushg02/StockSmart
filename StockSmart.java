
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
        
        //Stock1
        FileIO amzn = new FileIO(GUI.c1FileDir);
        amzn.getData();
        Calculation.Calc1(beta, amzn.getCurr(), principalInvestment, amzn.getLow(), amzn.getHigh(), predictedHigh, predictedLow);
        app.StockSmartScore1 = Calculation.getScore1();
        
        //Stock2
        FileIO nvda = new FileIO(GUI.c2FileDir);
        nvda.getData();
        Calculation.Calc1(beta, nvda.getCurr(), principalInvestment, nvda.getLow(), nvda.getHigh(), predictedHigh, predictedLow);
        app.StockSmartScore2 = Calculation.getScore1();
        
        System.out.println("Stock 1 has a score of" + app.StockSmartScore1);
        System.out.println("Stock 2 has a score of" + app.StockSmartScore2);
        
        if(app.StockSmartScore1 > app.StockSmartScore2)
            System.out.println("Therefore Stock 1 is the better stock");
        else if(app.StockSmartScore1 < app.StockSmartScore2)
            System.out.println("Therefore ");    
        //FileIO.subroutine1();
        //GUI.subroutine2();
        
        
    }
}
