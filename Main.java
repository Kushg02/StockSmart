
/**
 * Main Runner
 *
 * @Kush (your name)
 * @1.0 (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class Main
{
    public static double[][] data;

    public Main()
    {
        data = new double[2][100];
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        Main app = new Main(); //Creates Main App Object
        app.data[0][0] = 4.20; 
        
        System.out.println(data.toString());
        
        //FileIO.subroutine1();
        //GUI.subroutine2();
        GraphPanel.subroutine3();
        
    }
}
