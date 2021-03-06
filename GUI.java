import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Dimension;
import javax.swing.text.JTextComponent;
import java.awt.Insets;

public class GUI extends JFrame{
    private JLabel a;
    private JTextField company1, company2, index, beta1, beta2, invest, high1, 
    low1, high2, low2;
    public static JTextArea result;
    private JButton analyze;
    public static String c1FileDir, c2FileDir, indexFileDir;
    public static double c1beta, c2beta, principal, c1High, c1Low, c2High, c2Low;
    
    public GUI() {
        
        this.setResizable(false);
        //adds the picture
        a = new JLabel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        a.setIcon(new ImageIcon("StockSmart GUI.png"));
        add(a);
        pack();
        //
        //adds the text fields to type in
        
        index = new JTextField("dataTest1.txt" , 15);
        index.setSize( index.getPreferredSize() );
        index.setLocation(350, 235);
        a.add(index);
        
        company1 = new JTextField("dataTest1.txt" , 15);
        company1.setSize( company1.getPreferredSize() );
        company1.setLocation(350, 315);
        a.add(company1);
         
        beta1 = new JTextField("1" , 5);
        beta1.setSize( beta1.getPreferredSize() );
        beta1.setLocation(350, 368);
        a.add(beta1);
        
        company2 = new JTextField("dataTest1.txt" , 15);
        company2.setSize( company2.getPreferredSize() );
        company2.setLocation(350, 443);
        a.add(company2);
        
        beta2 = new JTextField("1" , 5);
        beta2.setSize( beta2.getPreferredSize() );
        beta2.setLocation(350, 497);
        a.add(beta2);
         
        invest = new JTextField("100000" , 5);
        invest.setSize( invest.getPreferredSize() );
        invest.setLocation(693, 235);
        a.add(invest);
        
        high1 = new JTextField("2000" , 5);
        high1.setSize( high1.getPreferredSize() );
        high1.setLocation(693, 315);
        a.add(high1);
        
        low1 = new JTextField("1000" , 5);
        low1.setSize( low1.getPreferredSize() );
        low1.setLocation(693, 368);
        a.add(low1);
        
        high2 = new JTextField("2000" , 5);
        high2.setSize( high2.getPreferredSize() );
        high2.setLocation(693, 443);
        a.add(high2);
        
        low2 = new JTextField("1000" , 5);
        low2.setSize( low2.getPreferredSize() );
        low2.setLocation(693, 497);
        a.add(low2);
        
        analyze = new JButton("Analyze");
        analyze.setSize(new Dimension(100, 30));
        analyze.setLocation(437,565);
        ListenForButton lForButton = new ListenForButton();
        analyze.addActionListener(lForButton);
        a.add(analyze);
 
        result = new JTextArea();
        result.setMargin( new Insets(5,5,5,5) );
        result.setLineWrap(true); 
        result.setWrapStyleWord(true);
        result.setSize(new Dimension(705,100));
        result.setLocation(150, 655);
        a.add(result);
    }
    
    public static String getFile1(){
        return c1FileDir;
    }
    
    public static String getFile2(){
        return c2FileDir;
    }
    
    public static String getIndexFile(){
        return indexFileDir;
    }
    
    public static void gui(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
    private class ListenForButton implements ActionListener{
        
        // This method is called when an event occurs
        
        public void actionPerformed(ActionEvent e){
            
            // Check if the source of the event was the button
            
            if(e.getSource() == analyze){
                
                // getText returns a String so you have to parse it
                // into a double in this situation
                
                try{
                    StockSmart.ready = true;
                    int count = 0;
                    if (company1.getText().length() > 0) {
                        c1FileDir = company1.getText();
                    }
                    if (company2.getText().length() > 0) {
                        c2FileDir = company2.getText();
                    }
                    if (index.getText().length() > 0) {
                        indexFileDir = index.getText();
                    }
                    if(beta1.getText().length() > 0) {
                        c1beta = Double.parseDouble(beta1.getText());
                    }
                    if(beta2.getText().length() > 0) {
                        c2beta = Double.parseDouble(beta2.getText());
                    }
                    if(invest.getText().length() > 0) {
                        principal = Double.parseDouble(invest.getText());
                    }
                    if(high1.getText().length() > 0) {
                        c1High = Double.parseDouble(high1.getText());
                    }
                    if(low1.getText().length() > 0) {
                        c1Low = Double.parseDouble(low1.getText());
                    }
                    if(high2.getText().length() > 0) {
                        c2High = Double.parseDouble(high2.getText());
                    }
                    if(low2.getText().length() > 0) {
                        c2Low = Double.parseDouble(low2.getText());
                    }
                }
                
                catch(NumberFormatException excep){
                    
                    // JOptionPane displays a popup on the screen
                    // (parentComponent, message, title, error icon)
                    // Error Icons: WARNING_MESSAGE, QUESTION_MESSAGE, PLAIN_MESSAGE
                    
                    System.exit(0); // Closes the Java app
                }
            }
        }
        
    }
}
