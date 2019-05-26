import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.general.SeriesException; 
import org.jfree.data.time.*; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;

import java.util.*;

public class Graph extends ApplicationFrame {

   public Graph (final String title, FileIO ob1, FileIO ob2, FileIO ob3) {
      super(title);         
      
      String[] x = ob1.getDates();
      double[] y = ob1.getData();
      double[] z = ob2.getData();
      double[] w = ob3.getData();
      
      final XYDataset dataset = createDataset(x, y, z, w);         
      final JFreeChart chart = createChart(dataset);  
      
      final ChartPanel chartPanel = new ChartPanel(chart);         
      chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));         
      chartPanel.setMouseZoomable(true, false);         
      
      setContentPane(chartPanel);
   }

   private XYDataset createDataset(String[] x, double[] y, double[] z, double[] w) {
      final TimePeriodValues s1 = new TimePeriodValues("Company 1");
      int index = 0;
      for (int i = 0; i < x.length; i++) {
       if (x[i] == null) {
           index = i;
           break;}}
      
      
      for(int i = 0; i < index; i++) 
      {
          String temp = x[i];
          String[] parts = temp.split("/");
          int day = Integer.parseInt(parts[1]);
          int month = Integer.parseInt(parts[0]);
          int year = Integer.parseInt(parts[2]);
          Day date = new Day(day, month, year); //integer
          s1.add(new SimpleTimePeriod(date.getStart(), date.getEnd()), y[i]);
      }
      
      final TimePeriodValues s2 = new TimePeriodValues("Company 2");         
      for(int i = 0; i < index; i++) 
      {
          String[] parts = x[i].split("/");
          int day = Integer.parseInt(parts[1]);
          int month = Integer.parseInt(parts[0]);
          int year = Integer.parseInt(parts[2]);
          Day date = new Day(day, month, year); //integer
          s2.add(new SimpleTimePeriod(date.getStart(), date.getEnd()), z[i]);
      }
      
      final TimePeriodValues s3 = new TimePeriodValues("Index");         
      for(int i = 0; i < index; i++) 
      {
          String[] parts = x[i].split("/");
          int day = Integer.parseInt(parts[1]);
          int month = Integer.parseInt(parts[0]);
          int year = Integer.parseInt(parts[2]);
          Day date = new Day(day, month, year); //integer
          s3.add(new SimpleTimePeriod(date.getStart(), date.getEnd()), w[i]);
      }
      
      final TimePeriodValuesCollection dataset = new TimePeriodValuesCollection(); //Forked from http://www.java2s.com/Code/Java/Chart/JFreeChartTimePeriodValuesDemo2.htm
      dataset.addSeries(s1); //also forked
      dataset.addSeries(s2);
      dataset.addSeries(s3);
      dataset.setDomainIsPointsInTime(false); //also forked
      
      return dataset;
   }     

   private JFreeChart createChart(final XYDataset dataset) {
      return ChartFactory.createTimeSeriesChart(             
         "Stock Market Analysis", 
         "Date",              
         "Prices",              
         dataset,             
         true,              
         false,              
         false);
   }

   public static void graphStocks(FileIO ob1, FileIO ob2, FileIO ob3) {
      final String title = "Stock Market Analysis";         
      final Graph demo = new Graph(title, ob1, ob2, ob3);         
      demo.pack();         
      RefineryUtilities.positionFrameRandomly(demo);         
      demo.setVisible(true);
   }
}   
