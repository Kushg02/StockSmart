import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.general.SeriesException; 
import org.jfree.data.time.TimePeriodValues; 
import org.jfree.data.time.TimePeriodValuesCollection; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.time.Day;

public class Graph extends ApplicationFrame {

   public Graph (final String title) {
      super(title);         
      String[] x = {"1/3/2002","1/4/2002"};
      double[] y = {1313.13, 1232.24};
      final XYDataset dataset = createDataset(x, y);         
      final JFreeChart chart = createChart( dataset );         
      final ChartPanel chartPanel = new ChartPanel(chart);         
      chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));         
      chartPanel.setMouseZoomable(true, false);         
      setContentPane(chartPanel);
   }

   private XYDataset createDataset(String[] x, double[] y) {
      final TimePeriodValues series = new TimePeriodValues("Data");         
      for(int i = 0; i < x.length; i++) 
      {
          String[] parts = x[i].split("/");
          int day = Integer.parseInt(parts[1]);
          int month = Integer.parseInt(parts[0]);
          int year = Integer.parseInt(parts[2]);
          Day date = new Day(day, month, year); //integer
          series.add(date, y[i]);
      }
      return TimePeriodValuesCollection(series);
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
      final Graph demo = new Graph(title);         
      demo.pack();         
      RefineryUtilities.positionFrameRandomly(demo);         
      demo.setVisible(true);
   }
}   
