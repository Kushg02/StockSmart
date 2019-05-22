import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.general.SeriesException; 
import org.jfree.data.time.*; 
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.xy.XYDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.time.Day;

public class TimeSeries_AWT extends ApplicationFrame {

   public TimeSeries_AWT (final String title) {
      super(title);         
      
      String[] x = {"1/3/2002","1/4/2002", "1/5/2002", "1/6/2002", "1/7/2002"};
      double[] y = {1313.13, 1232.24, 1313.13, 1353.13, 1213.13};
      double[] z = {1132.32, 1242.43, 1253.53, 1353.32, 1125.14};
      double[] w = {1511.54, 1534.53, 1564.35, 1645.34, 1542.24};
      
      final XYDataset dataset = createDataset(x, y, z, w);         
      final JFreeChart chart = createChart(dataset);  
      
      final ChartPanel chartPanel = new ChartPanel(chart);         
      chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));         
      chartPanel.setMouseZoomable(true, false);         
      
      setContentPane(chartPanel);
   }

   private XYDataset createDataset(String[] x, double[] y, double[] z, double[] w) {
      final TimePeriodValues s1 = new TimePeriodValues("Data1");         
      for(int i = 0; i < x.length; i++) 
      {
          String[] parts = x[i].split("/");
          int day = Integer.parseInt(parts[1]);
          int month = Integer.parseInt(parts[0]);
          int year = Integer.parseInt(parts[2]);
          Day date = new Day(day, month, year); //integer
          s1.add(new SimpleTimePeriod(date.getStart(), date.getEnd()), y[i]);
      }
      
      final TimePeriodValues s2 = new TimePeriodValues("Data2");         
      for(int i = 0; i < x.length; i++) 
      {
          String[] parts = x[i].split("/");
          int day = Integer.parseInt(parts[1]);
          int month = Integer.parseInt(parts[0]);
          int year = Integer.parseInt(parts[2]);
          Day date = new Day(day, month, year); //integer
          s2.add(new SimpleTimePeriod(date.getStart(), date.getEnd()), z[i]);
      }
      
      final TimePeriodValues s3 = new TimePeriodValues("Data3");         
      for(int i = 0; i < x.length; i++) 
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
         false,              
         false,              
         false);
   }

   public static void main(final String[ ] args) {
      final String title = "Stock Market Analysis";         
      final TimeSeries_AWT demo = new TimeSeries_AWT(title);         
      demo.pack();         
      RefineryUtilities.positionFrameRandomly(demo);         
      demo.setVisible(true);
   }
}   
