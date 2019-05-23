
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

    public StockSmart()
    {

    }

    public static void main(String[] args) throws FileNotFoundException //DISCLAIMER: Used in conjunction with reasearch, not an independent analyzer
    {
        StockSmart app = new StockSmart(); //Creates Main App Object
        
        FileIO amzn = new FileIO("dataTest1.txt");
        amzn.getData();
        
        //FileIO.subroutine1();
        //GUI.subroutine2();
        
        
    }
}
