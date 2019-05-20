import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.general.SeriesException; 
import org.jfree.data.time.Second; 
import org.jfree.data.time.TimeSeries; 
import org.jfree.data.time.TimeSeriesCollection; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.time.Day;

public class TimeSeries_AWT extends ApplicationFrame {

   public TimeSeries_AWT( final String title ) {
      super( title );         
      String[] x = {"1/3/2002","1/4/2002"};
      final XYDataset dataset = createDataset(x);         
      final JFreeChart chart = createChart( dataset );         
      final ChartPanel chartPanel = new ChartPanel( chart );         
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 370 ) );         
      chartPanel.setMouseZoomable( true , false );         
      setContentPane( chartPanel );
   }

   private XYDataset createDataset(String[] x) {
      final TimeSeries series = new TimeSeries( "Data" );         
      for(String ind : x) 
      {
          String[] parts = ind.split("/");
          int day = Integer.parseInt(parts[1]);
          int month = Integer.parseInt(parts[0]);
          int year = Integer.parseInt(parts[2]);
          Day date = new Day(day, month, year); //integer
          series.add(date,12.0);
      }
      return new TimeSeriesCollection(series);
   }     

   private JFreeChart createChart( final XYDataset dataset ) {
      return ChartFactory.createTimeSeriesChart(             
         "Computing Test", 
         "Seconds",              
         "Value",              
         dataset,             
         false,              
         false,              
         false);
   }

   public static void main( final String[ ] args ) {
      final String title = "Time Series Management";         
      final TimeSeries_AWT demo = new TimeSeries_AWT( title );         
      demo.pack( );         
      RefineryUtilities.positionFrameRandomly( demo );         
      demo.setVisible( true );
   }
}   